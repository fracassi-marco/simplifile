package simplifile;

import java.io.File;

public class Folder {

    private File folder;

    public Folder(String fullPath) {
        folder = new File(fullPath);
    }

    public boolean exists() {
        return folder.exists();
    }

    public Folder create() {
        folder.mkdirs();
        return this;
    }

    public Folder delete() {
        folder.delete();
        return this;
    }
}
