package co.com.test.choucair.interactions;

import co.com.test.choucair.util.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.io.*;

public class Prueba implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        File f = new File(Constants.path2);
        System.out.printf(Constants.path2);
        File[] files = f.listFiles();
        String ultimo_log = files[files.length-1].getName();
        System.out.printf(ultimo_log);
    }
    public static Prueba  prueba2() { return Tasks.instrumented(Prueba.class); }
}
