package co.com.test.choucair.tasks;

import co.com.test.choucair.interactions.Mover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
public class MoverArchivoMove implements Task {

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Mover.mover2());
    }

    public static Performable inThePageFinacle() {
        return Tasks.instrumented(Mover.class);
    }
}
