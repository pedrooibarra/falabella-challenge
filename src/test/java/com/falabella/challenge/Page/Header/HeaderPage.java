package com.falabella.challenge.Page.Header;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(id="testId-UserAction-userinfo") WebElement signInMenu;
    @FindBy(id="testId-loggedout-item-0") WebElement signInOption;
    @FindBy(id="testId-loggedout-item-1") WebElement signUpOption;
    @FindBy(id="testId-loggedin-action-item-0") WebElement logOutOption;
    @FindBy(id="testId-SearchBar-Input") WebElement searchBarInput;
    @FindBy(id="testId-UserAction-basket") WebElement shoppingCartLink;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignUp(){
        waitUntilElementIsVisible(signInMenu);
        moveToElement(signInMenu);
        clickSignUp();
    }

    public void clickSignUp(){
        waitUntilElementIsVisible(signUpOption);
        signUpOption.click();
    }

    public void openSignInModal(){
        waitUntilElementIsVisible(signInMenu);
        moveToElement(signInMenu);
        clickSignIn();
    }

    public void clickSignIn(){
        waitUntilElementIsVisible(signInOption);
        signInOption.click();
    }

    public boolean isVisibleLogOutOption(){
        waitUntilElementIsVisible(signInMenu);
        moveToElement(signInMenu);
        return isVisible(logOutOption);
    }

    public void searchAndEnter(String term){
        waitUntilElementIsVisible(searchBarInput);
        searchBarInput.sendKeys(term);
        searchBarInput.sendKeys(Keys.RETURN);
    }

    public void clickShoppingCartLink(){
        waitUntilElementIsVisible(shoppingCartLink);
        shoppingCartLink.click();
    }
}
