package com.falabella.challenge.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.falabella.challenge.StepDefinition"},
        features = "src/test/resources/cucumber/",
        plugin = {"pretty"}
)
public class MainRun {
    @BeforeClass
    public static void principalConfig(){
        System.setProperty("project.build", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
    }
}
