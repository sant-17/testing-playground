package com.testingplayground;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;

    private static final String START_MAXIMIZED = "--start-maximized";
    private static final String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(START_MAXIMIZED);
        options.addArguments(IGNORE_CERTIFICATE_ERRORS);
        driver = new ChromeDriver(options);
        driver.get("https://www.uitestingplayground.com/home");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }

}
