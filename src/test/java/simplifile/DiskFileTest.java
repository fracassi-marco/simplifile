package simplifile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

import static org.assertj.core.api.Assertions.assertThat;

public class DiskFileTest {

    private Path fullPath;

    @Before
    public void setUp() throws Exception {
        fullPath = Files.createTempFile("simplifile", ".txt");
    }

    @After
    public void tearDown() {
        fullPath.toFile().delete();
    }

    @Test
    public void shouldExists() {
        assertThat(new DiskFile(fullPath.toString()).exists()).isTrue();

        assertThat(new DiskFile("/not_existing.txt").exists()).isFalse();
    }
}
