package co.com.test.choucair.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class SwitchToIframe implements Interaction {
	
	private Target frame;
	
	public SwitchToIframe(Target frame) {
		this.frame = frame;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).getDriver().switchTo().frame(frame.resolveFor(actor));
	}
	
	public static SwitchToIframe frame (String frame) {
		return Tasks.instrumented(SwitchToIframe.class, frame);
	}
	

}
