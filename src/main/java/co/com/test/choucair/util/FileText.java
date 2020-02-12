package co.com.test.choucair.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileText {

    public FileText() {}

    public static List<String> read(String filepath) throws IOException {
        String strLine;
        List<String> result = new ArrayList<>();
        BufferedReader bw = new BufferedReader(new FileReader(filepath));

        while ((strLine = bw.readLine()) != null) {
            result.add(strLine + "\n");
        }

        return result;
    }
}
