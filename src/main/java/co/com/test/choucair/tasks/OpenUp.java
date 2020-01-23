package co.com.test.choucair.tasks;

import co.com.test.choucair.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class OpenUp implements Task {

    HomePage homePage;

    @Override
    public <T extends Actor> void performAs(T actor) {
    Screen screen = new Screen();
     actor.attemptsTo(Open.browserOn(homePage));
       screen.type(Key.F5);
    }
    public static OpenUp thePage(){
        return Tasks.instrumented(OpenUp.class);
    }
}
