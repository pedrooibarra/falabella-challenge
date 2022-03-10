package com.falabella.challenge.StepDefinition.Home;

import com.falabella.challenge.Page.Header.HeaderPage;
import com.falabella.challenge.Page.Home.HomePage;
import com.falabella.challenge.Page.SignUp.SignUpPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomeDefinition {

    ScenarioContext scenarioContext;
    HomePage homePage;
    HeaderPage headerPage;
    SignUpPage signUpPage;

    public HomeDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        homePage = new HomePage(DriverFactory.getDriver());
        signUpPage = new SignUpPage(DriverFactory.getDriver());
        headerPage = new HeaderPage(DriverFactory.getDriver());
    }

    @Given("I am on falabella.com")
    public void iAmOnFalabellaCom() throws InterruptedException {
        String URL_FALABELLA = "https://www.falabella.com/falabella-cl";
        DriverFactory.getDriver().get(URL_FALABELLA);
        DriverFactory.getDriver().manage().window().maximize();
        Thread.sleep(2000);
    }

    @And("Close promotions modal if is visible")
    public void closePromotionsModalIfIsVisible() {
        homePage.closeModalIfIsVisible();
    }


}
