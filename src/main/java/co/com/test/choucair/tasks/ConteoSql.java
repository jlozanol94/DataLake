package co.com.test.choucair.tasks;

import co.com.test.choucair.interactions.ConteoSqlServer;
import co.com.test.choucair.models.ConteoSqlServerEntity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;


public class ConteoSql implements Task {

    private List<String> data;

    public ConteoSql(List<String> data) {
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        ConteoSqlServerEntity.loadDataForTransaction(data);
        actor.attemptsTo(ConteoSqlServer.conteoSqlServer());
    }

    public static Performable inThePageFinacle(List<String> data) {
        return Tasks.instrumented(ConteoSql.class, data);
    }
}
