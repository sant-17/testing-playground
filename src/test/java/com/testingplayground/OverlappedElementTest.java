package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.testingplayground.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverlappedElementTest extends BaseTest {

    @Test
    public void testOverlappedElement() {
        By btnOverlappedElement = By.xpath("//a[text()='Overlapped Element']");
        By inputId = By.xpath("//input[@id='id']");
        By inputName = By.xpath("//input[@id='name']");

        String id = "12";
        String name = "Juan";

        clickElement(btnOverlappedElement);
        sendText(inputId, id);
        scrollIntoElement(inputName);
        sendText(inputName, name);

        assertEquals(id, getElementAttribute(inputId, "value"));
        assertEquals(name, getElementAttribute(inputName, "value"));
    }
}
