package com.sol.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    // Existing method
    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser");

        return createDriver(browser);
    }

    // New method
    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new RuntimeException(
                    "Invalid browser: " + browser
            );
        }

        driver.manage().window().maximize();

        return driver;
    }
}
