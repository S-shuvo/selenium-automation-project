package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    private By usernameField =
            By.name("username");

    private By passwordField =
            By.name("password");

    private By loginButton =
            By.xpath("//input[@value='Login']");

    // Dashboard / logged-in page indicator
    private By dashboardElement =
            By.xpath("//div[@class='page-title-bar']");


    // =========================================================
    // LOGIN
    // =========================================================

    public void login(String username, String password) {

        // Username
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        ).sendKeys(username);


        // Password
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);


        // Login
        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();


        // Wait until dashboard/home page is loaded
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardElement)
        );

        System.out.println("Dashboard loaded successfully.");
    }
}