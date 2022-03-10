package com.falabella.challenge.Page.SignUp;

import com.falabella.challenge.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(id = "testId-Button-submit") WebElement btnSignUp;
    @FindBy(id = "testId-Input-firstName") WebElement inputFirstName;
    @FindBy(id = "testId-Input-lastName") WebElement inputLastName;
    @FindBy(id = "testId-Input-document") WebElement inputDocument;
    @FindBy(id = "testId-Input-phoneNumber") WebElement inputPhoneNumer;
    @FindBy(id = "testId-Input-email") WebElement inputEmail;
    @FindBy(id = "testId-Input-password") WebElement inputPassword;
    @FindBy(id = "testId-consent-consentTemplateRegistroTyC_FAL_CL-input") WebElement inputTyC;
    @FindBy(id = "testId-consent-consentTemplateRegistroPdP_FAL_CL-input") WebElement inputPdP;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void setInputFirstName(String firstName){
        waitUntilElementIsVisible(inputFirstName);
        inputFirstName.sendKeys(firstName);
    }

    public void setInputLastName(String lastName){
        waitUntilElementIsVisible(inputLastName);
        inputLastName.sendKeys(lastName);
    }

    public void setInputDocument(String document){
        waitUntilElementIsVisible(inputDocument);
        inputDocument.sendKeys(document);
    }

    public void setInputPhoneNumer(String phoneNumber){
        waitUntilElementIsVisible(inputPhoneNumer);
        inputPhoneNumer.sendKeys(phoneNumber);
    }

    public void setInputEmail(String email){
        scrollDownToElement(inputEmail);
        waitUntilElementIsVisible(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password){
        waitUntilElementIsVisible(inputPassword);
        inputPassword.sendKeys(password);
    }

    public void clickInputTyC(){
        waitUntilElementIsVisibleNonThrow(inputTyC,3);
        moveToElementAndClick(inputTyC);
        inputTyC.click();
    }

    public void clickInputPdP(){
        waitUntilElementIsVisibleNonThrow(inputPdP,3);
        inputPdP.click();
    }

    public boolean isEnabledButtonSubmit(){
        waitUntilElementIsVisibleNonThrow(btnSignUp, 3);
        return btnSignUp.isEnabled();
    }

    public boolean isVisibleButtonSubmit(){
        scrollDownToElement(btnSignUp);
        return isVisible(btnSignUp);
    }

}
