package co.com.test.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


import static co.com.test.choucair.userinterface.PageBuscarQVF.BTNCLOSE;


public class Close implements Task {

    public Close(){}
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(BTNCLOSE));
    }

    public static Performable inThePageFinacle() {
        return Tasks.instrumented(Close.class);
    }
}
