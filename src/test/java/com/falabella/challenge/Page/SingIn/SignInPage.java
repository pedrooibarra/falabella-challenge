package com.falabella.challenge.Page.SingIn;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id="testId-cc-login-form-email-input") WebElement inputEmail;
    @FindBy(id="testId-cc-login-form-password-input") WebElement inputPassword;
    @FindBy(id="testId-cc-login-form-submit") WebElement buttonSubmit;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void setInputEmail(String email){
        waitUntilElementIsVisible(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password){
        scrollDownToElement(inputPassword);
        waitUntilElementIsVisible(inputPassword);
        inputPassword.sendKeys(password);
    }

    public void clickButtonSubmit(){
        waitUntilElementIsVisibleNonThrow(buttonSubmit, 30);
        if(isEnabledButtonSubmit()){
            buttonSubmit.click();
        }
    }

    public boolean isEnabledButtonSubmit(){
        waitUntilElementIsVisibleNonThrow(buttonSubmit, 30);
        return buttonSubmit.isEnabled();
    }
}
