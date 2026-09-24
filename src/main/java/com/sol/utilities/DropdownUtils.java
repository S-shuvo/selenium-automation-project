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
    // SELECT2 / AUTOCOMPLETE DROPDOWN
    // =========================================================

    public void selectRandomAutocomplete(
            By fieldLocator,
            By searchInputLocator,
            By optionsLocator
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

        searchInput.clear();

        // Search character
        searchInput.sendKeys("t");


        // Confirm search text entered
        wait.until(driver ->
                "t".equalsIgnoreCase(
                        searchInput.getAttribute("value")
                )
        );


        // Wait for actual database result
        wait.until(driver -> {

            List<WebElement> options =
                    driver.findElements(optionsLocator);

            return options.stream()
                    .anyMatch(option ->
                            isValidOption(
                                    option.getText().trim()
                            )
                    );
        });


        // Get actual valid options
        List<WebElement> validOptions =
                driver.findElements(optionsLocator)
                        .stream()
                        .filter(option ->
                                isValidOption(
                                        option.getText().trim()
                                )
                        )
                        .toList();


        if (validOptions.isEmpty()) {
            throw new RuntimeException(
                    "No autocomplete data loaded from database!"
            );
        }


        // Random option
        int randomIndex =
                random.nextInt(validOptions.size());

        WebElement selectedOption =
                validOptions.get(randomIndex);


        System.out.println(
                "Total Loaded Options : " +
                        validOptions.size()
        );

        System.out.println(
                "Selected Option : " +
                        selectedOption.getText()
        );


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

