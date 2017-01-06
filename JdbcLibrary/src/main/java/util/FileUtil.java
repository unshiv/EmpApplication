package util;

import java.io.File;
import java.io.IOException;

/**
 * Created by bukia on 12/25/2016.
 */
public class FileUtil {
    public static boolean createFile(String filePath) {
        boolean ret = false;
        int i = filePath.lastIndexOf("\\");
        String dir = filePath.substring(0, i);
        String fi = filePath.substring(i+1);

        File dirf = new File(dir);
        File filf = new File(fi);
        try {
            if (!dirf.exists()) {
                ret = dirf.mkdirs();
            }
            if (!filf.exists()) {
                ret = (ret && filf.createNewFile());
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return ret;
    }
}
