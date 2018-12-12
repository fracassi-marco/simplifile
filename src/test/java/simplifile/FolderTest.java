package simplifile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class FolderTest {

    private Path fullPath;

    @Before
    public void setUp() throws Exception {
        fullPath = Files.createTempDirectory("simplifile");
    }

    @After
    public void tearDown() {
        new Folder(fullPath.toString()).delete();
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
        File file = create("baz.txt");

        assertThat(folder.delete().exists()).isFalse();
        assertThat(file.exists()).isFalse();
    }

    @Test
    public void shouldListFiles() throws IOException {
        create("foo.txt");
        create("bar.txt");
        Folder folder = new Folder(fullPath.toString());

        assertThat(folder.files()).hasSize(2);
    }

    private File create(String fileName) throws IOException {
        File file = new File(fullPath + "/" + fileName);
        file.createNewFile();

        return file;
    }
}
