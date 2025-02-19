package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ClickTest extends BaseTest{

    @Test
    public void testClickTest() {
        WebElement btnClick = driver.findElement(
                By.xpath("//a[text()='Click']")
        );
        btnClick.click();

        WebElement btnClickEvent = driver.findElement(
                By.xpath("//button[@id='badButton']")
        );

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", btnClickEvent);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        btnClickEvent.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
