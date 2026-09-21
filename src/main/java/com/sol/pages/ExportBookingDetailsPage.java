package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportBookingDetailsPage extends BasePage {

    public ExportBookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // Export Booking success message
    private By bookingNumberMessage =
            By.xpath("//p[contains(.,'Export booking saved successfully') and contains(.,'Booking No')]");


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
     * Get complete booking success message
     */
    public String getBookingNumberMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(bookingNumberMessage)
        ).getText();
    }


    /**
     * Extract Booking Number from success message
     */
    public String getBookingNumber() {

        String message = getBookingNumberMessage();

        System.out.println("Booking Message: " + message);

        Pattern pattern =
                Pattern.compile("Booking No\\.\\s*:\\s*([A-Z0-9]+)");

        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {

            String bookingNumber = matcher.group(1);

            System.out.println("Booking Number: " + bookingNumber);

            return bookingNumber;
        }

        throw new RuntimeException(
                "Booking number not found in message: " + message
        );
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
