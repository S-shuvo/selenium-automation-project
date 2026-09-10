package com.sol.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver createDriver(){
        String browser = ConfigReader.get("browser");
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else{
            throw new RuntimeException("Browser not supported" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
