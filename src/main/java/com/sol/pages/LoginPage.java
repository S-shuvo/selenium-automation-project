package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String username, String Password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@value='login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='page-title-bar']")));

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
