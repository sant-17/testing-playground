package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertPromptTest extends BaseTest {
    @Test
    public void testAlertPrompt() {
        String message = "Jirafa";

        By btnAlerts = By.xpath("//a[text()='Alerts']");
        By btnPromt = By.xpath("//button[@id='promptButton']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Utils.clickElement(btnAlerts);
        Utils.clickElement(btnPromt);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(message);
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains(message));

        alert.accept();

        Utils.clickElement(btnPromt);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("no answer"));
    }
}
