package com.sol.tests;

import com.sol.pages.LoginPage;
import com.sol.utilities.BrowserFactory;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // 1. Open browser
        driver = BrowserFactory.createDriver();

        // 2. Open application login page
        driver.get(ConfigReader.get("app.url"));

        System.out.println("Application Title: " + driver.getTitle());

        // 3. Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("app.username"),
                ConfigReader.get("app.password")
        );

        System.out.println("Login successful.");
    }

//    @AfterMethod
//    public void tearDown() {
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}