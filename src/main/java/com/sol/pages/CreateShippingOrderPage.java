package com.sol.pages;

import com.sol.utilities.DropdownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

// CFS SELECT2 AUTOCOMPLETE

    private final By cfsDropdown =
            By.cssSelector("#select2-cfsId-container");

    private final By cfsSearchInput =
            By.cssSelector("input[role='searchbox']");

    private final By cfsOptions =
            By.cssSelector("#select2-cfsId-result-e6wt-6669265");

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
                        ExpectedConditions.elementToBeClickable(
                                bookingNoField
                        )
                );

        System.out.println(
                "Displayed: " + bookingField.isDisplayed()
        );

        System.out.println(
                "Enabled: " + bookingField.isEnabled()
        );

        System.out.println(
                "Readonly: " +
                        bookingField.getAttribute("readonly")
        );

        bookingField.clear();
        bookingField.sendKeys(bookingNumber);

        // Click Search
        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();

// Wait for the exact booking row to appear
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

// Find Action dropdown in the matching row
        By actionDropdownLocator =
                By.xpath(
                        "//table//tbody/tr[.//td[normalize-space()='" +
                                bookingNumber +
                                "']]//select"
                );

// Wait for the current dropdown element
        WebElement actionDropdown =
                wait.until(
                        ExpectedConditions.refreshed(
                                ExpectedConditions.elementToBeClickable(
                                        actionDropdownLocator
                                )
                        )
                );

// Select Create SO
        Select actionSelect = new Select(actionDropdown);

        actionSelect.selectByVisibleText("Create SO");

        System.out.println(
                "Create SO selected for booking: " + bookingNumber
        );
    }

// =========================================================
// SELECT RANDOM CFS
// =========================================================

    public void selectRandomCFS() {

        List<WebElement> elements = driver.findElements(cfsDropdown);

        System.out.println("CFS elements found: " + elements.size());

        for (WebElement element : elements) {
            System.out.println("Displayed: " + element.isDisplayed());
            System.out.println("Enabled: " + element.isEnabled());
            System.out.println("HTML: " + element.getAttribute("outerHTML"));
        }

// If Transport Mode is Air, select CCL
        if (transportMode != null &&
                transportMode.equalsIgnoreCase("Air")) {

            // Open CFS dropdown
            wait.until(
                    ExpectedConditions.elementToBeClickable(cfsDropdown)
            ).click();

            // Find Select2 search input
            WebElement searchInput =
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    cfsSearchInput
                            )
                    );

            // Search for CCL
            searchInput.sendKeys("CCL");

            // Find matching CCL option
            By cclOption =
                    By.xpath(
                            "//li[contains(@class,'select2-results__option')" +
                                    " and contains(normalize-space(.),'CCL')" +
                                    " and not(contains(@class,'select2-results__message'))]"
                    );

            WebElement option =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    cclOption
                            )
                    );

            option.click();

            System.out.println("Transport Mode : Air");
            System.out.println("Selected CFS : CCL");

        } else {

            // For other Transport Modes, select random CFS
            dropdownUtils.selectRandomAutocomplete(
                    cfsDropdown,
                    cfsSearchInput,
                    cfsOptions
            );

            System.out.println(
                    "Transport Mode : " + transportMode
            );
        }
    }
}