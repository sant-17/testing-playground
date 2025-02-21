package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInputTest extends BaseTest {

    @Test
    public void testTextInput() {
        String message = "Hola mundo";

        By btnTextInput = By.xpath("//a[text()='Text Input']");
        By inputText = By.xpath("//input[@id='newButtonName']");
        By btnChangeValue = By.xpath("//button[@id='updatingButton']");

        Utils.clickElement(btnTextInput);
        Utils.sendText(inputText, message);
        Utils.clickElement(btnChangeValue);

        assertEquals(message, Utils.getElementText(btnChangeValue));
    }
}
