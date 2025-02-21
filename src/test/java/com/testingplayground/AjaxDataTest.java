package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.testingplayground.Utils.clickElement;
import static com.testingplayground.Utils.waitElementClickable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AjaxDataTest extends BaseTest{

    @Test
    public void testAjaxData() {
        By btnAjaxData = By.xpath("//a[text()='AJAX Data']");
        By btnAjaxRequest = By.xpath("//button[@id='ajaxButton']");
        By txtAjaxText = By.xpath("//div[@id='content']/p");

        clickElement(btnAjaxData);
        clickElement(btnAjaxRequest);
        waitElementClickable(txtAjaxText, Duration.ofSeconds(20));

        assertEquals("Data loaded with AJAX get request.", Utils.getElementText(txtAjaxText));
    }
}
