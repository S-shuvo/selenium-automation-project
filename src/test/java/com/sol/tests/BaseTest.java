package com.sol.tests;

import com.sol.pages.LoginPage;
import com.sol.utilities.BrowserFactory;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"server", "browser"})
    public void setUp(
            @Optional("server1") String server,
            @Optional("chrome") String browser
    ) {

        // 1. Open browser
        driver = BrowserFactory.createDriver(browser);

        System.out.println("Server : " + server);
        System.out.println("URL : " + ConfigReader.getServerUrl(server));

        // 2. Open application login page
        driver.get(
                ConfigReader.getServerUrl(server)
        );

        System.out.println("Server : " + server);
        System.out.println("Browser : " + browser);
        System.out.println("Application Title : " + driver.getTitle());

        // 3. Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getServerUsername(server),
                ConfigReader.getServerPassword(server)
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
