package com.falabella.challenge.StepDefinition.ShoppingCart;

import com.falabella.challenge.Page.ShoppingCart.ShoppingCartPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class ShoppingCartDefinition {

    ScenarioContext scenarioContext;
    ShoppingCartPage shoppingCartPage;

    public ShoppingCartDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        shoppingCartPage = new ShoppingCartPage(DriverFactory.getDriver());
    }


    @And("check if total price is correct")
    public void checkIfTotalPriceIsCorrect() {
        String productValue = (String) scenarioContext.getScenarioContext("productValue");
        Assert.assertEquals(shoppingCartPage.getTotalAmountValue(), productValue);
    }
}
