package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppTest extends BaseTest{

    @Test
    public void testSampleApp() {
        WebElement btnSampleApp = driver.findElement(
                By.xpath("//a[text()='Sample App']")
        );
        btnSampleApp.click();

        String username = "Juan Perez";
        String pwd = "pwd";
        String message = "Welcome, " + username + "!";

        WebElement inputUsername = driver.findElement(
                By.xpath("//input[@name='UserName']")
        );
        inputUsername.sendKeys(username);

        WebElement inputPwd = driver.findElement(
                By.xpath("//input[@name='Password']")
        );
        inputPwd.sendKeys(pwd);

        WebElement btnLogin = driver.findElement(
                By.xpath("//button[@id='login']")
        );
        btnLogin.click();

        WebElement lblMessage = driver.findElement(
                By.xpath("//label[@class='text-success']")
        );

        assertEquals(message, lblMessage.getText());
    }
}
