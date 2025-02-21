package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingplayground.Utils.clickElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassAttributeTest extends BaseTest {

    @Test
    public void testClassAttribute() {
        By btnClassAttribute = By.xpath("//a[text()='Class Attribute']");
        By btnBlueButton = By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        clickElement(btnClassAttribute);
        clickElement(btnBlueButton);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();

        assertEquals("Primary button pressed", alertMessage);
    }
}
