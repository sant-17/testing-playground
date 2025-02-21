package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingplayground.Utils.clickElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest extends BaseTest {

    @Test
    public void testAlerts() {
        By btnAlerts = By.xpath("//a[text()='Alerts']");
        By btnAlert = By.xpath("//button[@id='alertButton']");
        By btnConfirm = By.xpath("//button[@id='confirmButton']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        clickElement(btnAlerts);
        clickElement(btnAlert);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        clickElement(btnConfirm);

        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("No", alert.getText());
        alert.accept();

        clickElement(btnConfirm);

        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Yes", alert.getText());
        alert.accept();
    }
}
