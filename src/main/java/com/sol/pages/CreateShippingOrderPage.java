package com.sol.pages;

import com.sol.pages.BasePage;
import com.sol.utilities.DropdownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateShippingOrderPage extends BasePage {

    private final DropdownUtils dropdownUtils;
    private final String transportMode;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public CreateShippingOrderPage(WebDriver driver, String transportMode) {
        super(driver);

        dropdownUtils = new DropdownUtils(driver);
        this.transportMode = transportMode;
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // BASIC INFORMATION

    private final By cfsDropdown =
            By.id("select2-cfsId-container");

    // Booking search field
    private final By bookingNoField =
            By.id("txtBookingNo");

    // Search button
    private final By searchButton =
            By.id("btnSearchSo");

    // =========================================================
    // SEARCH BOOKING & OPEN CREATE SO
    // =========================================================

    public void searchBookingAndOpenCreateSO(String bookingNumber) {

        if (bookingNumber == null || bookingNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Booking number is empty."
            );
        }

        // Enter Booking Number
        WebElement bookingField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                bookingNoField
                        )
                );

        bookingField.clear();
        bookingField.sendKeys(bookingNumber);

        System.out.println(
                "Searching Booking Number: " + bookingNumber
        );

        // Click Search
        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();

        // Wait for the row containing the requested booking number
        By bookingRow =
                By.xpath(
                        "//table//tbody/tr[.//td[normalize-space()='" +
                                bookingNumber +
                                "']]"
                );

        WebElement resultRow =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                bookingRow
                        )
                );

        System.out.println(
                "Booking found: " + bookingNumber
        );

        // Click Action dropdown in the matching row
        WebElement actionDropdown =
                resultRow.findElement(
                        By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) div:nth-child(1) select:nth-child(1)")
                );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        actionDropdown
                )
        ).click();

        // Click Create SO option
        By createSOOption =
                By.cssSelector("option[value='createShippingOrder?id=51385934']");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        createSOOption
                )
        ).click();

        System.out.println(
                "Create SO selected for booking: " + bookingNumber
        );
    }


    // =========================================================
    // METHODS
    // =========================================================

    public void selectRandomCFS() {

        // If Transport Mode is Air, select CCL
        if (transportMode != null &&
                transportMode.equalsIgnoreCase("Air")) {

            // Select2 container is not a normal HTML <select>
            WebElement cfsField =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    cfsDropdown
                            )
                    );

            cfsField.click();

            By cclOption =
                    By.xpath(
                            "//li[contains(@class,'select2-results__option')" +
                                    " and normalize-space(.)='CCL']"
                    );

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            cclOption
                    )
            ).click();

            System.out.println("Transport Mode : Air");

            System.out.println("Selected CFS : CCL");

        } else {

            // For other Transport Modes, select random CFS
            dropdownUtils.selectRandomDropdown(
                    cfsDropdown
            );
        }
    }
}