package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.testingplayground.Utils.clickElement;
import static com.testingplayground.Utils.scrollIntoElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrollbarsTest extends BaseTest {

    @Test
    public void testScrollbars() {
        By btnScrollbars = By.xpath("//a[text()='Scrollbars']");
        By btnHiding = By.xpath("//button[@id='hidingButton']");

        clickElement(btnScrollbars);
        scrollIntoElement(btnHiding);

        assertTrue(driver.findElement(btnHiding).isDisplayed());
    }
}
