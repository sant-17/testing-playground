package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testingplayground.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppTest extends BaseTest{

    @Test
    public void testSampleApp() {
        String username = "Juan Perez";
        String pwd = "pwd";
        String message = "Welcome, " + username + "!";

        By btnSampleApp = By.xpath("//a[text()='Sample App']");
        By inputUsername = By.xpath("//input[@name='UserName']");
        By inputPwd = By.xpath("//input[@name='Password']");
        By btnLogin = By.xpath("//button[@id='login']");
        By lblMessage = By.xpath("//label[@class='text-success']");

        clickElement(btnSampleApp);
        sendText(inputUsername, username);
        sendText(inputPwd, pwd);
        clickElement(btnLogin);

        assertEquals(message, getElementText(lblMessage));
    }
}
