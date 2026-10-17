package com.sol.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DropdownUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Random random = new Random();

    public DropdownUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================================================
    // NORMAL HTML DROPDOWN
    // =========================================================

    public void selectRandomDropdown(By locator) {

        Select select = new Select(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                )
        );

        List<WebElement> options = select.getOptions();

        if (options.size() <= 1) {
            throw new RuntimeException(
                    "No selectable options available for: " + locator
            );
        }

        // First option "-- Select One --" বাদ
        int randomIndex =
                1 + random.nextInt(options.size() - 1);

        select.selectByIndex(randomIndex);

        System.out.println(
                "Selected Dropdown : " +
                        options.get(randomIndex).getText()
        );
    }

// =========================================================
// SELECT2 / AUTOCOMPLETE DROPDOWN - OPTIMIZED
// =========================================================

    public void selectRandomAutocomplete(
            By fieldLocator,
            By searchInputLocator,
            By optionsLocator,
            String searchText
    ) {
// Open dropdown
        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(fieldLocator)
                );

        field.click();

// Search input
        WebElement searchInput =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                searchInputLocator
                        )
                );

// Search character
        searchInput.sendKeys(searchText);

// Wait until actual valid results are available
        List<WebElement> validOptions =
                wait.until(driver -> {

                    List<WebElement> options =
                            driver.findElements(optionsLocator);

                    List<WebElement> valid =
                            options.stream()
                                    .filter(WebElement::isDisplayed)
                                    .filter(option ->
                                            isValidOption(
                                                    option.getText().trim()
                                            )
                                    )
                                    .toList();

                    return valid.isEmpty() ? null : valid;
                });

// Random option
        int randomIndex =
                random.nextInt(validOptions.size());

        WebElement selectedOption =
                validOptions.get(randomIndex);

        System.out.println("Search Text:" + searchText);

        System.out.println(
                "Total Loaded Options : " + validOptions.size()
        );

        System.out.println(
                "Selected Option : " + selectedOption.getText()
        );

// Select option
        selectedOption.click();
    }

// =========================================================
// AUTOCOMPLETE VALIDATION
// =========================================================

    private boolean isValidOption(String text) {

        return !text.isEmpty()

                && !text.equalsIgnoreCase("Searching…")

                && !text.equalsIgnoreCase("Searching...")

                && !text.equalsIgnoreCase(
                "Please enter 1 or more characters"
        )

                && !text.equalsIgnoreCase(
                "-- Select One --"
        );
    }

    public void selectByVisibleText(By locator, String text) {

        Select select = new Select(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                )
        );

        select.selectByVisibleText(text);
    }

}