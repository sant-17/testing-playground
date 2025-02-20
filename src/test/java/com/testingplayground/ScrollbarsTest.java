package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(btnHiding.isDisplayed());
    }
}
