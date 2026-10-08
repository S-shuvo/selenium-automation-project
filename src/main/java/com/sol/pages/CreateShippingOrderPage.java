package com.sol.pages;

import com.sol.utilities.DropdownUtils;
import org.openqa.selenium.By;
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

    // ---------------------------------------------------------
    // BASIC INFORMATION
    // ---------------------------------------------------------

    private final By cfsDropdown =
            By.id("select2-cfsId-container");


    // =========================================================
    // METHODS
    // =========================================================

    public void selectRandomCFS() {

        // If Transport Mode is Air, select CCL
        if (transportMode != null &&
                transportMode.equalsIgnoreCase("Air")) {

            Select select = new Select(
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    cfsDropdown
                            )
                    )
            );

            select.selectByVisibleText("CCL");

            System.out.println(
                    "Transport Mode : Air"
            );

            System.out.println(
                    "Selected CFS : CCL"
            );

        } else {

            // For other Transport Modes, select random CFS
            dropdownUtils.selectRandomDropdown(
                    cfsDropdown
            );
        }
    }
}