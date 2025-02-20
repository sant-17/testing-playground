package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressBarTest extends BaseTest {

    @Test
    public void testProgressBarTest() {
        WebElement btnProgressBar = driver.findElement(
                By.xpath("//a[text()='Progress Bar']")
        );
        btnProgressBar.click();

        WebElement btnStart = driver.findElement(
                By.xpath("//button[@id='startButton']")
        );
        btnStart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String progress = "75";

        WebElement lblProgressBar = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                String.format("//div[@id='progressBar' and @aria-valuenow='%s']", progress)
                                )
                )
        );

        WebElement btnStop = driver.findElement(
                By.xpath("//button[@id='stopButton']")
        );
        btnStop.click();

        assertTrue(lblProgressBar.getText().contains(progress));
    }
}
