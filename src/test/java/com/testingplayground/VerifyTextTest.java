package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyTextTest extends BaseTest{

    @Test
    public void testVerifyText() {
        WebElement btnVerifyText = driver.findElement(
                By.xpath("//a[text()='Verify Text']")
        );
        btnVerifyText.click();

        String message = "Welcome UserName!";

        WebElement lblWelcome = driver.findElement(
                By.xpath(
                        String.format("//span[normalize-space(.)='%s']", message)
                )
        );

        assertEquals(message, lblWelcome.getText());
    }
}
