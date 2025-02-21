package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.testingplayground.Utils.getElementAttribute;

public class ClickTest extends BaseTest{

    @Test
    public void testClickTest() {
        By btnClick = By.xpath("//a[text()='Click']");
        By btnClickEvent = By.xpath("//button[@id='badButton']");

        Utils.clickElement(btnClick);

        String buttonClass = getElementAttribute(btnClickEvent, "class");

        Utils.clickJavaScriptElement(btnClickEvent);
        Assertions.assertEquals(buttonClass, getElementAttribute(btnClickEvent, "class"));

        Utils.clickElement(btnClickEvent);
        Assertions.assertNotEquals(buttonClass, getElementAttribute(btnClickEvent, "class"));
    }
}
