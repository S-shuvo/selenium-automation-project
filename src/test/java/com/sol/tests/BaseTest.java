package com.sol.tests;

import com.sol.utilities.BrowserFactory;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void Setup()
    {
        driver = BrowserFactory.createDriver();
        driver.get(ConfigReader.get("appUrl"));
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
