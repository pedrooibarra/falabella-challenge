package com.falabella.challenge.StepDefinition.SignIn;

import com.falabella.challenge.Page.SingIn.SignInPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.en.When;

public class SignInDefinition {

    ScenarioContext scenarioContext;
    SignInPage singInPage;

    public SignInDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        singInPage = new SignInPage(DriverFactory.getDriver());
    }

    @When("Complete and submit the login form with the default values")
    public void completeAndSubmitTheLoginFormWithTheDefaultValues() {
        singInPage.setInputEmail(System.getenv("FALABELLA_EMAIL"));
        singInPage.setInputPassword(System.getenv("FALABELLA_PASSWORD"));
        singInPage.clickButtonSubmit();
    }

}
