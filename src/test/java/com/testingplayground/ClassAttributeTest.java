package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClassAttributeTest extends BaseTest {

    @Test
    public void testClassAttribute() {
        WebElement btnClassAttribute = driver.findElement(
                By.xpath("//a[text()='Class Attribute']")
        );
        btnClassAttribute.click();
        WebElement btnBlueButton = driver.findElement(
                By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")
        );
        btnBlueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertMessage = alert.getText();

        Assertions.assertEquals("Primary button pressed", alertMessage);
    }
}
