package co.com.test.choucair.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.test.choucair.models.ConteoSqlServerEntity.getConteoQVF;
import static co.com.test.choucair.userinterface.PageBuscarQVF.*;
import static co.com.test.choucair.util.EnumControlNull.RECORD_NA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConteoSqlServer implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(BTN_COMPARE_PLAINS));
        actor.attemptsTo( WaitUntil.the(BTN_BUSCAR, isVisible()).forNoMoreThan(100).seconds() );
        actor.attemptsTo(Click.on(BTN_BUSCAR));
        actor.attemptsTo(Check.whether(!getConteoQVF().getNombreqvf().equals(RECORD_NA.getLista())).andIfSo(Enter.theValue(getConteoQVF().getNombreqvf()).into(TXTQVF)));
        actor.attemptsTo( WaitUntil.the(BTNQVF, isVisible()).forNoMoreThan(100).seconds() );
        actor.attemptsTo(Click.on(BTNQVF));
        actor.attemptsTo(NavegarTabs.getIN(2));
        actor.attemptsTo( WaitUntil.the(BTN_OPCIONES, isVisible()).forNoMoreThan(100).seconds() );
        actor.attemptsTo(Click.on(BTN_OPCIONES));
        actor.attemptsTo(Click.on(BTN_DATA_EDITOR));
        actor.attemptsTo( WaitUntil.the(Conec, isVisible()).forNoMoreThan(100).seconds() );
        actor.attemptsTo( WaitUntil.the(BTN_CARGAR_DATOS, isVisible()).forNoMoreThan(100).seconds() );
        actor.attemptsTo(Click.on(BTN_CARGAR_DATOS));

    }
    public static ConteoSqlServer conteoSqlServer() { return Tasks.instrumented(ConteoSqlServer.class); }
}
