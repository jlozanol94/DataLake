package co.com.test.choucair.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import java.util.Set;
/*
Esta clase fue diseñada para cambiar entre pestañas del navegador.
 */
public class NavegarTabs implements Interaction {
    private int numTab;
    public NavegarTabs(int numTab) {
        this.numTab = numTab;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<String> allWindows = Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles();
        int i = 0;
        for(String curWindow : allWindows){
            i++;
            if (i == numTab) {
                Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(curWindow);
                break;
            }
        }
    }
    public static NavegarTabs getIN(int numTab){
        return new NavegarTabs(numTab);
    }

}
