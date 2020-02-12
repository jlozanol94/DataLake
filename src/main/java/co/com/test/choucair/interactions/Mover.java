package co.com.test.choucair.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Mover implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Path origenPath = FileSystems.getDefault().getPath("C:\\Users\\jlozano\\Documents\\Qlik\\Sense\\Log\\Script\\ConteosOracleVsAthena.2020_02_05_19_04_10.2AD09E4EE7E969D9BAF7.log");
        Path destinoPath = FileSystems.getDefault().getPath("C:\\Users\\jlozano\\Documents\\Qlik\\Sense\\Log\\ScriptOrgi\\ConteosOracleVsAthena.2020_02_05_19_04_10.2AD09E4EE7E969D9BAF7.log");

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }


    }
    public static Mover mover2() { return Tasks.instrumented(Mover.class); }
}
