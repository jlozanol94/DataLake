package co.com.test.choucair.util;

import java.io.File;

public class log {
    public static String path() {
    File f = new File(Constants.path2);
    File[] files = f.listFiles();
    String ultimo_log = files[0].getName();
        return ultimo_log;
    }
}
