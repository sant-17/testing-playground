package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDomTest extends BaseTest {

    @Test
    public void testShadowDom() {
        WebElement btnShadowDom = driver.findElement(
                By.xpath("//a[text()='Shadow DOM']")
        );
        btnShadowDom.click();

        WebElement shadowHost = driver.findElement(
                By.tagName("guid-generator")
        );

        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement btnGenerate = shadowRoot.findElement(
                By.id("buttonGenerate")
        );
        btnGenerate.click();

        WebElement btnCopy = shadowRoot.findElement(
                By.id("buttonCopy")
        );
        btnCopy.click();

        WebElement inputGUID = shadowRoot.findElement(
                By.id("editField")
        );

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String clipboardText = (String) jsExecutor.executeScript("return navigator.clipboard.readText();");
        assertEquals(inputGUID.getAttribute("value"), clipboardText);
    }
}
