package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.testingplayground.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisabledInputTest extends BaseTest {

    @Test
    public void testDisabledInput() {
        By btnDisabledInput = By.xpath("//a[text()='Disabled Input']");
        By btnEnableDelay = By.xpath("//button[@id='enableButton']");
        By inputField = By.xpath("//input[@id='inputField']");
        By lblInputStatus = By.xpath("//div[@id='opstatus']");

        clickElement(btnDisabledInput);
        clickElement(btnEnableDelay);
        waitElementClickable(inputField, Duration.ofSeconds(5));
        sendText(inputField, "Hola mundo");

        assertEquals("Input Enabled...", getElementText(lblInputStatus));
    }
}
