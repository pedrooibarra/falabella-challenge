package com.falabella.challenge.StepDefinition.Header;

import com.falabella.challenge.Page.Header.HeaderPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HeaderDefinition {

    ScenarioContext scenarioContext;
    HeaderPage headerPage;

    public HeaderDefinition(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        headerPage = new HeaderPage(DriverFactory.getDriver());
    }

    @And("Select the sign up menu")
    public void selectTheSignUpMenu() {
        headerPage.goToSignUp();
    }

    @And("Select sign in menu")
    public void selectSignInMenu() {
        headerPage.openSignInModal();
    }

    @When("I search product code {string}")
    public void iSearchProductCode(String productCode) {
        headerPage.searchAndEnter(productCode);
    }
    
    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(headerPage.isVisibleLogOutOption());
    }

    @Then("I go to shopping cart")
    public void iGoToShoppingCart() {
        headerPage.clickShoppingCartLink();
    }
}
