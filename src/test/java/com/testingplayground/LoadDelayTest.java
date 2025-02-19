package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadDelayTest extends BaseTest{

    @Test
    public void testLoadDelay() {
        WebElement btnLoadDelay = driver.findElement(By.xpath("//a[text()='Load Delay']"));
        btnLoadDelay.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnAfterDelay = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@class='btn btn-primary']")
                )
        );

        btnAfterDelay.click();

        WebElement txtTitle = driver.findElement(By.xpath("//h3"));

        Assertions.assertEquals("Load Delays", txtTitle.getText());
    }
}
