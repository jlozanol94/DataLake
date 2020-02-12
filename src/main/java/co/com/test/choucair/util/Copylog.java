package co.com.test.choucair.util;

import java.io.File;

public class Copylog {
    public static String path2() {
    File f = new File(Constants.path3);
    File[] files = f.listFiles();
    String ultimo_log = files[0].getName();
        return ultimo_log;
    }
}
