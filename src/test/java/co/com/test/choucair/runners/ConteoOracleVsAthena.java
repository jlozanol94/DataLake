package co.com.test.choucair.runners;

import co.com.test.choucair.util.exceldata.BeforeSuite;
import co.com.test.choucair.util.exceldata.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions (features = "src/test/resources/features/DataLakeRimac.feature",
        glue = "co.com.test.choucair.stepdefinitions",
        tags = "@ConteosOracleVsAthena",
        snippets = SnippetType.CAMELCASE )


public class ConteoOracleVsAthena {
    private ConteoOracleVsAthena() {
    }

    @BeforeSuite
    public static void test() throws  IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/DataLakeRimac.feature");
    }

}