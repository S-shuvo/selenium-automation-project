package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExportBookingDetailsPage extends BasePage {

    public ExportBookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // Export Booking Number / success message
    private By bookingNumberMessage =
            By.xpath("//*[contains(text(),'Export Booking') or contains(text(),'Booking No')]");

    // PO field
    // TODO: Inspect করে actual id/name বসাতে হবে
    private By poField =
            By.xpath("//input[contains(@name,'po') or contains(@id,'po')]");

    // PO Save
    // TODO: যদি আলাদা Save button থাকে actual locator বসাতে হবে
    private By poSaveButton =
            By.xpath("//input[@value='Save'] | //button[normalize-space()='Save']");


    // =========================================================
    // METHODS
    // =========================================================

    /**
     * Booking number message wait
     */
    public String getBookingNumberMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(bookingNumberMessage)
        ).getText();
    }


    /**
     * Enter PO
     */
    public void enterPO(String poNumber) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(poField)
        ).sendKeys(poNumber);
    }


    /**
     * Save PO
     */
    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(poSaveButton)
        ).click();
    }
}