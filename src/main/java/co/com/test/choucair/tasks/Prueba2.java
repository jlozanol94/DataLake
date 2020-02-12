package co.com.test.choucair.tasks;

import co.com.test.choucair.interactions.Prueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class Prueba2 implements Task {



     public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Prueba.prueba2());
    }


    public static Performable inThePageFinacle() {
        return Tasks.instrumented(Prueba.class);
    }
}
