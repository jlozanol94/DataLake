package co.com.test.choucair.util;

import java.io.File;

public class log {
    public static String path() {
    File f = new File(Constants.path2);
    File[] files = f.listFiles();
    String ultimo_log = files[files.length-1].getName();
        System.out.printf("dsjns"+ultimo_log);
        return ultimo_log;
    }
}
