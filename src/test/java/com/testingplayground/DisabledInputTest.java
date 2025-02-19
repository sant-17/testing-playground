package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisabledInputTest extends BaseTest {

    @Test
    public void testDisabledInput() {
        WebElement btnDisabledInput = driver.findElement(
                By.xpath("//a[text()='Disabled Input']")
        );
        btnDisabledInput.click();

        WebElement btnEnableDelay = driver.findElement(
                By.xpath("//button[@id='enableButton']")
        );
        btnEnableDelay.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@id='inputField']")
                )
        );

        WebElement lblInputStatus = driver.findElement(
                By.xpath("//div[@id='opstatus']")
        );

        Assertions.assertEquals("Input Enabled...", lblInputStatus.getText());
    }
}
