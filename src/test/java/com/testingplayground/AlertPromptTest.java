package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertPromptTest extends BaseTest {
    @Test
    public void testAlertPrompt() {
        WebElement btnAlerts = driver.findElement(
                By.xpath("//a[text()='Alerts']")
        );
        btnAlerts.click();

        WebElement btnPromt = driver.findElement(
                By.xpath("//button[@id='promptButton']")
        );
        btnPromt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        wait.until(ExpectedConditions.alertIsPresent());

        String input = "Jirafa";

        alert.sendKeys(input);
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains(input));

        alert.accept();

        btnPromt.click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("no answer"));
    }
}
