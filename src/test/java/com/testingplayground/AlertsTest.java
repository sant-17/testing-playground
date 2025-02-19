package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTest extends BaseTest {

    @Test
    public void testAlerts() {
        WebElement btnAlerts = driver.findElement(
                By.xpath("//a[text()='Alerts']")
        );
        btnAlerts.click();

        WebElement btnAlert = driver.findElement(
                By.xpath("//button[@id='alertButton']")
        );
        btnAlert.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        WebElement btnConfirm = driver.findElement(
                By.xpath("//button[@id='confirmButton']")
        );
        btnConfirm.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("No", alert.getText());
        alert.accept();

        btnConfirm.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Yes", alert.getText());
        alert.accept();

    }
}
