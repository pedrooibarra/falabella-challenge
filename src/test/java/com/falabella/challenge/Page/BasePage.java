package com.falabella.challenge.Page;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BasePage {

    private static final int WAIT_TIMEOUT = 15;
    private static final int POLLING = 100;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, WAIT_TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,WAIT_TIMEOUT),this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public String getTitle(){
        return getDriver().getTitle();
    }

    public void waitUntilElementIsVisible(WebElement element){
        try{
            await().atMost(WAIT_TIMEOUT, TimeUnit.SECONDS).until(() -> isVisible(element));
        }catch(ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento: %s", element));
        }
    }

    public void waitUntilElementIsVisible(By element){
        try{
            await().atMost(WAIT_TIMEOUT, TimeUnit.SECONDS).until(() -> isVisible(element));
        }catch(ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento: %s", element));
        }
    }

    public void waitUntilElementIsVisibleNonThrow(WebElement element, int WAIT_TIMEOUT){
        try{
            await().atMost(WAIT_TIMEOUT, TimeUnit.SECONDS).until(() -> isVisible(element));
        }catch(ConditionTimeoutException e){
        }
    }

    public void waitUntilElementIsVisibleNonThrow(By element, int WAIT_TIMEOUT){
        try{
            await().atMost(WAIT_TIMEOUT, TimeUnit.SECONDS).until(() -> isVisible(element));
        }catch(ConditionTimeoutException e){
        }
    }

    protected boolean isVisible(By element){
        try{
            return getDriver().findElement(element).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    protected boolean isVisible(WebElement webElement){
        try{
            return webElement.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveToElementAndClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }

    public void scrollDownToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }
}
