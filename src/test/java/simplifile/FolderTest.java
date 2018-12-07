package simplifile;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class FolderTest {

    @Test
    public void shouldExists() throws IOException {
        String fullPath = Files.createTempDirectory("simplifile").toString();

        assertThat(new Folder(fullPath).exists()).isTrue();

        assertThat(new Folder("/not_existing").exists()).isFalse();
    }
}
