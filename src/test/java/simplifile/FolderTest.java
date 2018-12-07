package simplifile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FolderTest {

    private Path fullPath;

    @Before
    public void setUp() throws Exception {
        fullPath = Files.createTempDirectory("simplifile");
    }

    @After
    public void tearDown() {
        File folder = new File(fullPath.toString());
        File[] files = folder.listFiles();
        if(files != null) {
            Arrays.asList(files)
                    .forEach(each -> {
                        Arrays.asList(each.listFiles())
                                .forEach(item -> item.delete());
                        each.delete();
                    });
        }
        folder.delete();
    }

    @Test
    public void shouldExists() {
        assertThat(new Folder(fullPath.toString()).exists()).isTrue();

        assertThat(new Folder("/not_existing").exists()).isFalse();
    }

    @Test
    public void shouldCreate() {
        Folder folder = new Folder(fullPath + "/foo");

        assertThat(folder.create().exists()).isTrue();
    }

    @Test
    public void shouldCreateRecursively() {
        Folder folder = new Folder(fullPath + "/foo/bar");

        assertThat(folder.create().exists()).isTrue();
    }

    @Test
    public void shouldBeDelete() {
        Folder folder = new Folder(fullPath.toString());

        assertThat(folder.delete().exists()).isFalse();
    }

    @Test
    public void shouldBeDeletedAlsoIfHasSubfolder() {
        Folder folder = new Folder(fullPath.toString());
        Folder subfolder = new Folder(fullPath + "/foo").create();

        assertThat(folder.delete().exists()).isFalse();
        assertThat(subfolder.exists()).isFalse();
    }

    @Test
    public void shouldBeDeletedAlsoIfContainsFile() throws IOException {
        Folder folder = new Folder(fullPath.toString());
        File file = new File(fullPath + "/baz.txt");
        file.createNewFile();

        assertThat(folder.delete().exists()).isFalse();
        assertThat(file.exists()).isFalse();
    }
}
