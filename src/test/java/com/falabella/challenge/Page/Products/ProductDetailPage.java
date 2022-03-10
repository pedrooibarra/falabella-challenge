package com.falabella.challenge.Page.Products;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailPage extends BasePage {

    @FindBy(xpath = "//*[@id='buttonForCustomers']/button") WebElement btnAddCart;
    @FindBy(id = "linkButton") WebElement btnGoToShoppingCart;
    @FindBy(xpath = "//*[contains(@id,'testId-pod-prices')]/ol/li[1]/div/span") WebElement productValueText;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonAddCart(){
        waitUntilElementIsVisible(btnAddCart);
        btnAddCart.click();
    }

    public void clickButtonGoToShoppingCart(){
        waitUntilElementIsVisible(btnGoToShoppingCart);
        btnGoToShoppingCart.click();
    }

    public String getProductPrice(){
        waitUntilElementIsVisible(productValueText);
        return productValueText.getText();
    }

}
