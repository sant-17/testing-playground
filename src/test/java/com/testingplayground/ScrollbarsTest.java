package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollbarsTest extends BaseTest {

    @Test
    public void testScrollbars() {
        WebElement btnScrollbars = driver.findElement(
                By.xpath("//a[text()='Scrollbars']")
        );
        btnScrollbars.click();

        WebElement btnHiding = driver.findElement(
                By.xpath("//button[@id='hidingButton']")
        );

        JavascriptExecutor jsExecitor = (JavascriptExecutor) driver;
        jsExecitor.executeScript("arguments[0].scrollIntoView();", btnHiding);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(btnHiding.isDisplayed());
    }
}
