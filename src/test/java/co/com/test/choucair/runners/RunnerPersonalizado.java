package co.com.test.choucair.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import co.com.test.choucair.exceptions.BackEndException;
import co.com.test.choucair.util.exceldata.BeforeSuite;
import net.serenitybdd.cucumber.CucumberWithSerenity;

public class RunnerPersonalizado extends Runner {

	private Class<CucumberWithSerenity> classValue;
	private CucumberWithSerenity cucumberWithSerenity;

	public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) {

		try {

			this.classValue = classValue;
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			throw new BackEndException(e);
		}
	}

	@Override
	public Description getDescription() {
		return cucumberWithSerenity.getDescription();
	}

	private void runAnnotatedMethods(Class<?> annotation) {

		try {

			if (!annotation.isAnnotation()) {
				return;
			}
			Method[] methods = this.classValue.getMethods();
			for (Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation item : annotations) {
					if (item.annotationType().equals(annotation)) {
						method.invoke(null);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new BackEndException(e);
		}
	}


	@Override
	public void run(RunNotifier notifier) {
		try {
			runAnnotatedMethods(BeforeSuite.class);
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			throw new BackEndException(e);
		}
		cucumberWithSerenity.run(notifier);
	}

}

