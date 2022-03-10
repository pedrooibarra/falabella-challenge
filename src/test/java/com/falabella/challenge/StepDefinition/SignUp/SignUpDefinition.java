package com.falabella.challenge.StepDefinition.SignUp;

import com.falabella.challenge.Page.Home.HomePage;
import com.falabella.challenge.Page.SignUp.SignUpPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SignUpDefinition {

    ScenarioContext scenarioContext;
    HomePage homePage;
    SignUpPage singUpPage;

    public SignUpDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        homePage = new HomePage(DriverFactory.getDriver());
        singUpPage = new SignUpPage(DriverFactory.getDriver());
    }

    @And("Complete the sign up form with the following values")
    public void completeTheSignUpFormWithTheFollowingValues(DataTable datatable) {
        List<Map<String, String>> table = datatable.asMaps();
        singUpPage.setInputFirstName(table.get(0).get("firstName"));
        singUpPage.setInputLastName(table.get(0).get("lastName"));
        singUpPage.setInputDocument(table.get(0).get("document"));
        singUpPage.setInputPhoneNumer(table.get(0).get("phoneNumber"));
        singUpPage.setInputEmail(table.get(0).get("email"));
        singUpPage.setInputPassword(table.get(0).get("password"));
    }

    @Then("Submit form button is enabled")
    public void submitFormButtonIsEnabled() {
        Assert.assertTrue(singUpPage.isEnabledButtonSubmit());
    }

    @And("Accept TyC and Data Use")
    public void acceptTyCAndDataUse() throws InterruptedException {
        singUpPage.clickInputTyC();
        singUpPage.clickInputPdP();
    }
}
