package com.falabella.challenge.Page.Home;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "dy-lb-close") WebElement btnClosePromotionsModal;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void closeModalIfIsVisible(){
        waitUntilElementIsVisibleNonThrow(btnClosePromotionsModal,5);
        if(isVisible(btnClosePromotionsModal)){
            btnClosePromotionsModal.click();
        }
    }

}
