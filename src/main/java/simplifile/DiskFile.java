package simplifile;

import java.io.File;
import java.io.IOException;

public class DiskFile {
    private final File file;

    public DiskFile(String fullPath) {
        file = new File(fullPath);
    }

    public boolean exists() {
        return file.exists();
    }

    public DiskFile create() {
        try {
            file.createNewFile();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
