package com.falabella.challenge.Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;

@CucumberOptions(tags = "@@smokeTest")
public class BSChromeWinRunner extends MainRun{
    @BeforeClass
    public static void config(){
        System.setProperty("browser", "Chrome");
        System.setProperty("labExecution", "browserstack");
        System.setProperty("browser_version", "latest");
        System.setProperty("browserstack.os", "Windows");
        System.setProperty("browserstack.os_version", "10");
        System.setProperty("browserstack.networkLogs", "false");
    }
}
