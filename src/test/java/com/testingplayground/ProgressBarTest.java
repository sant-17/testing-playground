package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingplayground.Utils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressBarTest extends BaseTest {

    @Test
    public void testProgressBarTest() {
        String progress = "75";

        By btnProgressBar = By.xpath("//a[text()='Progress Bar']");
        By btnStart = By.xpath("//button[@id='startButton']");
        By lblProgressBar = By.xpath("//div[@id='progressBar']");
        By btnStop = By.xpath("//button[@id='stopButton']");

        clickElement(btnProgressBar);
        clickElement(btnStart);
        waitElementAttributeToBe(lblProgressBar, "aria-valuenow", progress, Duration.ofSeconds(30));
        clickElement(btnStop);

        assertTrue(getElementText(lblProgressBar).contains(progress));
    }
}
