package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testingplayground.Utils.clickElement;
import static com.testingplayground.Utils.getElementText;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyTextTest extends BaseTest{

    @Test
    public void testVerifyText() {
        String message = "Welcome UserName!";

        By btnVerifyText = By.xpath("//a[text()='Verify Text']");
        By lblWelcome = By.xpath(String.format("//span[normalize-space(.)='%s']", message));

        clickElement(btnVerifyText);

        assertEquals(message, getElementText(lblWelcome));
    }
}
