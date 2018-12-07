package simplifile;

import java.io.File;

public class Folder {

    private File file;

    public Folder(String fullPath) {
        file = new File(fullPath);
    }

    public boolean exists() {
        return file.exists();
    }
}
