package simplifile;

import java.io.File;

public class DiskFile {
    private final File file;

    public DiskFile(String fullPath) {
        file = new File(fullPath);
    }

    public boolean exists() {
        return file.exists();
    }
}
