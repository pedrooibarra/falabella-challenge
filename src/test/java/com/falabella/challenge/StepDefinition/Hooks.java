package com.falabella.challenge.StepDefinition;

import com.browserstack.local.Local;
import com.falabella.challenge.Utils.BrowserStack.BrowserStackWeb;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.LocalChromeBrowser;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.UUID;

public class Hooks {

    public Scenario scenario;
    public Local browserStackLocal;
    public String localIdentifier;
    public ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void prepareTest(Scenario scenario) throws Throwable {
        this.scenario = scenario;
        setProjectName();
        builDriver();
    }

    @After
    /**
     * If our test is on BS, we update the status there
     */
    public void terminateTest(Scenario scenario) throws URISyntaxException, IOException {
        String sessionID = getSessionId().toString();
        shutdownDriver();
        if(System.getProperty("labExecution").equals("browserstack")){
            BrowserStackWeb.markAs(String.valueOf(scenario.getStatus()),sessionID);
        }
    }

    /**
     *
     */
    public void builDriver() throws Throwable{
        String labExecution = System.getProperty("labExecution");
        switch (labExecution){
            case "local":
                DriverFactory.addDriver(LocalChromeBrowser.buildChromeBrowser());
                break;
            case "browserstack":
                prepareBrowserStackLocal();
                DriverFactory.addDriver(BrowserStackWeb.buildBrowserStackWeb(System.getProperty("browser"), System.getProperty("browser_version"), System.getProperty("browserstack.os"),System.getProperty("browserstack.os_version")));
                break;

        }
    }

    public SessionId getSessionId(){
        return ((RemoteWebDriver)DriverFactory.getDriver()).getSessionId();
    }

    public void shutdownDriver(){
        DriverFactory.getDriver().quit();
        DriverFactory.removeDriver();
    }

    public void setProjectName(){
        System.setProperty("project.name", scenario.getName());
    }

    public void prepareBrowserStackLocal() throws Exception {
        String browserStackLocalProperty = System.getProperty("browserstack.local", "true");
        if(browserStackLocalProperty.equals("true")){
            if(browserStackLocal != null){
                browserStackLocal.stop();
                browserStackLocal = null;
            }
            browserStackLocal = new Local();
            HashMap<String,String> browserStackLocalArgs = new HashMap<>();
            browserStackLocalArgs.put("key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
            browserStackLocalArgs.put("force", "true");
            browserStackLocalArgs.put("forcelocal", "true");
            localIdentifier = UUID.randomUUID().toString();
            System.setProperty("browserStack.localIdentifier", localIdentifier);
            browserStackLocalArgs.put("localIdentifier", localIdentifier);
            browserStackLocal.start(browserStackLocalArgs);
            System.out.println(browserStackLocal.isRunning());
        }
    }
}