package com.falabella.challenge.Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;

@CucumberOptions(tags = "@smokeTest")
public class LocalChromeRunner extends MainRun{
    @BeforeClass
    public static void config(){
        System.setProperty("browser", "Chrome");
        System.setProperty("labExecution", "local");
        System.setProperty("closeDriver", "false");
    }
}
