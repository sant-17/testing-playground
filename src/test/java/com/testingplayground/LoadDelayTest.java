package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.testingplayground.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadDelayTest extends BaseTest{

    @Test
    public void testLoadDelay() {
        By btnLoadDelay = By.xpath("//a[text()='Load Delay']");
        By btnAfterDelay = By.xpath("//button[@class='btn btn-primary']");
        By txtTitle = By.xpath("//h3");

        clickElement(btnLoadDelay);
        waitElementVisible(btnAfterDelay, Duration.ofSeconds(10));
        clickElement(btnAfterDelay);

        assertEquals("Load Delays", getElementText(txtTitle));
    }
}
