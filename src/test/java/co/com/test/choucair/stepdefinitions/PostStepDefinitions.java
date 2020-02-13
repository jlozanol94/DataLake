package co.com.test.choucair.stepdefinitions;

import co.com.test.choucair.questions.CheckQ;
import co.com.test.choucair.questions.CheckR;
import co.com.test.choucair.tasks.ConteoSql;
import co.com.test.choucair.tasks.MoverArchivoMove;
import co.com.test.choucair.tasks.OpenUp;
import co.com.test.choucair.tasks.Prueba2;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class PostStepDefinitions {

    @Before
    public void initialConfiguration(){
        setTheStage(new OnlineCast());
    }

    @Given("^The Data Analyst wants to run a Qlik Sense scripts$")
    public void theDataAnalystWantsToRunAQlikSenseScripts() {
       theActorCalled("Jorge").wasAbleTo(OpenUp.thePage());
    }

  @When("^The analyst executed the scripts$")
    public void theAnalystExecutedTheScripts(List<String> data) {
        theActorInTheSpotlight().attemptsTo(ConteoSql.inThePageFinacle(data));
    }

    @Then("^Execution completed(.*)$")
    public void executionCompleted(String questionv) {

        theActorInTheSpotlight().should(seeThat(CheckQ.is(questionv)));
    }

    @And("^paso final2$")
    public void pasoFinal2() {

        theActorInTheSpotlight().attemptsTo(Prueba2.inThePageFinacle());
    }

    @And("^verificacion final(.*)$")
    public void verificacionFinal(String questionr) {
        theActorInTheSpotlight().should(seeThat(CheckR.is(questionr)));
    }
}
