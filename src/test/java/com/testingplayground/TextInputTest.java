package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInputTest extends BaseTest {

    @Test
    public void testTextInput() {
        WebElement btnTextInput = driver.findElement(
                By.xpath("//a[text()='Text Input']")
        );
        btnTextInput.click();

        String message = "Hola mundo";

        WebElement inputText = driver.findElement(
                By.xpath("//input[@id='newButtonName']")
        );
        inputText.sendKeys(message);

        WebElement btnChangeValue = driver.findElement(
                By.xpath("//button[@id='updatingButton']")
        );
        btnChangeValue.click();

        assertEquals(message, btnChangeValue.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
