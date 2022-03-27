package com.petapi.qa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\pet_api.feature",
        glue = "com\\petapi\\qa\\stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PetAPI {
}
