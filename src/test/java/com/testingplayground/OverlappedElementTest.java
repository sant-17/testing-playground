package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverlappedElementTest extends BaseTest {

    @Test
    public void testOverlappedElement() {
        WebElement btnOverlappedElement = driver.findElement(
                By.xpath("//a[text()='Overlapped Element']")
        );
        btnOverlappedElement.click();

        WebElement inputId = driver.findElement(
                By.xpath("//input[@id='id']")
        );
        inputId.sendKeys("12");

        String name = "Juan";

        WebElement inputName = driver.findElement(
                By.xpath("//input[@id='name']")
        );

        JavascriptExecutor jsExecitor = (JavascriptExecutor) driver;
        jsExecitor.executeScript("arguments[0].scrollIntoView();", inputName);

        inputName.sendKeys(name);

        assertEquals(name, inputName.getAttribute("value"));
    }
}
