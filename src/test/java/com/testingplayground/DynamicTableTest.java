package com.testingplayground;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.testingplayground.Utils.clickElement;
import static com.testingplayground.Utils.getElementText;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicTableTest extends BaseTest {

    @Test
    public void testDynamicTable() {
        By btnDynamicTable = By.xpath("//a[text()='Dynamic Table']");
        By lblChromeCPU = By.xpath("//div[@role='row'][span[text()='Chrome']]/span[contains(text(), '%')]");
        By lblExpectedChromeCPU = By.xpath("//p[@class='bg-warning']");

        clickElement(btnDynamicTable);

        assertTrue(getElementText(lblExpectedChromeCPU).contains(getElementText(lblChromeCPU)));
    }
}
