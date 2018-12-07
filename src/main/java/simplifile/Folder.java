package simplifile;

import java.io.File;
import java.util.Arrays;

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
        delete(folder);

        return this;
    }

    private void delete(File item) {
        File[] files = item.listFiles();
        if(files != null) {
            Arrays.asList(files).forEach(this::delete);
        }
        item.delete();
    }
}
