package simplifile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DiskFileTest {

    private Path fullPath;
    private Path folderFullPath;

    @Before
    public void setUp() throws Exception {
        fullPath = Files.createTempFile("simplifile", ".txt");
        folderFullPath = Files.createTempDirectory("simplifile");
    }

    @After
    public void tearDown() {
        fullPath.toFile().delete();
        new Folder(folderFullPath.toString()).delete();
    }

    @Test
    public void shouldExists() {
        assertThat(new DiskFile(fullPath.toString()).exists()).isTrue();

        assertThat(new DiskFile("/not_existing.txt").exists()).isFalse();
    }

    @Test
    public void shouldCreate() {
        DiskFile file = new DiskFile(folderFullPath.resolve("baz.txt").toString());

        assertThat(file.create().exists()).isTrue();
    }
}
