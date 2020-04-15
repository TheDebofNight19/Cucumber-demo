package com.github.TheDebofNight19;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = "resources.plugin.GlobalHook",
                features = "src/test/java/resources/feature",
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                glue = "cucumber/StepDefenition")

public class RunCucumberTest extends AbstractTestNGCucumberTests  {

}