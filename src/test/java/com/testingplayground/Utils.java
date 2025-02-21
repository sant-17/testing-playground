package com.testingplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingplayground.BaseTest.driver;

public class Utils {

    public static void clickElement(By element) {
        driver.findElement(element).click();
    }

    public static void sendText(By element, String text){
        driver.findElement(element).sendKeys(text);
    }

    public static void waitElementClickable(By element, Duration timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementVisible(By element, Duration timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitElementAttributeToBe(By element, String attribute, String value, Duration timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public static String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    public static void clickJavaScriptElement(By element){
        WebElement jsElement = driver.findElement(element);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].click();", jsElement);
    }

    public static void scrollIntoElement(By element) {
        WebElement jsElement = driver.findElement(element);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", jsElement);
    }

    public static String getElementAttribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    public static SearchContext getShadowRoot(By element) {
        return driver.findElement(element).getShadowRoot();
    }

    public static void clickShadowElement(By element, SearchContext shadow) {
        shadow.findElement(element).click();
    }
}
