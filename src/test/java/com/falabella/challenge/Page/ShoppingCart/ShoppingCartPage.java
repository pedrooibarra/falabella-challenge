package com.falabella.challenge.Page.ShoppingCart;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = "[data-testid='total-amount']") WebElement totalAmoutText;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalAmountValue(){
        waitUntilElementIsVisible(totalAmoutText);
        return totalAmoutText.getText();
    }

}