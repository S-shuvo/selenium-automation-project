package com.sol.tests;

import com.sol.pages.LoginPage;
import com.sol.utilities.ConfigReader;
//import com.sol.utilities.BrowserFactory;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login
                (ConfigReader.get("app.username"),
                ConfigReader.get("app.password")
        );

    }
}
