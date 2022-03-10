package com.falabella.challenge.StepDefinition.Products;

import com.falabella.challenge.Page.Products.ProductDetailPage;
import com.falabella.challenge.Utils.DriverFactory;
import com.falabella.challenge.Utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductsDefinition {

    ScenarioContext scenarioContext;
    ProductDetailPage productDetailPage;

    public ProductsDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        productDetailPage = new ProductDetailPage(DriverFactory.getDriver());
    }

    @And("Add the product to shopping cart")
    public void addTheProductToShoppingCart() {
        productDetailPage.clickButtonAddCart();
        scenarioContext.setScenarioContext("productValue", productDetailPage.getProductPrice());
    }

    @Then("I choose the option go to shopping cart")
    public void iChooseTheOptionGoToShoppingCart() {
        productDetailPage.clickButtonGoToShoppingCart();
    }
}
