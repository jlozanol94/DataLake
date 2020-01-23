package co.com.test.choucair.tasks;

import co.com.test.choucair.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.awt.*;
import java.awt.event.KeyEvent;


public class OpenUp implements Task {

    HomePage homePage;

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F5);
        }catch(AWTException a){
            a.printStackTrace();
        }
    }
    public static OpenUp thePage(){
        return Tasks.instrumented(OpenUp.class);
    }
}
