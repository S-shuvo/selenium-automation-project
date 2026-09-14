package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExportOperationPage extends BasePage {

    public ExportOperationPage(WebDriver driver){
        super(driver);
    }

    //Export Operation Menu
    private By exportOperationMenu = By.xpath("//h3[@id='menu_18']");


    //Export Booking SubMenu
    private By exportBookingMenu = By.xpath("//a[normalize-space()='Export Booking']");

    public void openExportBooking(){
        //Click Export Operation
        wait.until(ExpectedConditions.elementToBeClickable(exportOperationMenu)).click();
        System.out.println("Opening Export Booking module...");

        //Click Export Booking
        wait.until(ExpectedConditions.elementToBeClickable(exportBookingMenu)).click();
        System.out.println("Opening Export Booking page...");
    }


}
