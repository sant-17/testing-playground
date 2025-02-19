package com.testingplayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicTableTest extends BaseTest {

    @Test
    public void testDynamicTable() {
        WebElement btnDynamicTable = driver.findElement(
                By.xpath("//a[text()='Dynamic Table']")
        );
        btnDynamicTable.click();

        WebElement lblChromeCPU = driver.findElement(
                By.xpath("//div[@role='row'][span[text()='Chrome']]/span[contains(text(), '%')]")
        );

        WebElement lblExpectedChromeCPU = driver.findElement(
                By.xpath("//p[@class='bg-warning']")
        );

        Assertions.assertTrue(lblExpectedChromeCPU.getText().contains(lblChromeCPU.getText()));
    }
}
