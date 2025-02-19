package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxDataTest extends BaseTest{

    @Test
    public void testAjaxData() {
        WebElement btnAjaxData = driver.findElement(
                By.xpath("//a[text()='AJAX Data']")
        );
        btnAjaxData.click();

        WebElement btnAjaxRequest = driver.findElement(
                By.xpath("//button[@id='ajaxButton']")
        );
        btnAjaxRequest.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement txtAjaxText = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@id='content']/p")
                )
        );

        Assertions.assertEquals("Data loaded with AJAX get request.", txtAjaxText.getText());
    }
}
