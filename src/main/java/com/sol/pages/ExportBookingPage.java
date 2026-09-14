package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ExportBookingPage extends BasePage {

    public ExportBookingPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // Transport Mode
    private By transportModeDropdown =
            By.id("carrierModeId");

    // Key Account - input field
    private By keyAccountField =
            By.id("select2-keyAccountId-container");

    // key Account - AutoComplete
    private By keyAccountSearchInput =
            By.cssSelector(".select2-container--open .select2-search__field");

    // Freight Term
    private By freightTermDropdown =
            By.xpath("//select[option[normalize-space()='CIP']]");

    // Shipper
    private By shipperField =
            By.xpath("//input[contains(@name,'shipper') or contains(@id,'shipper')]");

    // Shipper Title
    private By shipperTitleField =
            By.xpath("//input[contains(@name,'shipperTitle') or contains(@id,'shipperTitle')]");

    // Email
    private By emailField =
            By.xpath("//input[@type='email' or contains(@name,'email')]");

    // Shipper Bank Name
    private By shipperBankNameField =
            By.xpath("//input[contains(@name,'shipperBank') or contains(@id,'shipperBank')]");

    // Consignee
    private By consigneeField =
            By.xpath("//input[contains(@name,'consignee') or contains(@id,'consignee')]");

    // Buying House
    private By buyingHouseField =
            By.xpath("//input[contains(@name,'buying') or contains(@id,'buying')]");

    // Buying House Title
    private By buyingHouseTitleField =
            By.xpath("//input[contains(@name,'buyingHouseTitle') or contains(@id,'buyingHouseTitle')]");

    // First Notify Name
    private By firstNotifyNameField =
            By.xpath("//input[contains(@name,'firstNotify') or contains(@id,'firstNotify')]");

    // Same as Consignee checkbox
    private By sameAsConsigneeCheckbox =
            By.xpath("//input[@type='checkbox' and following-sibling::text()[contains(.,'Same as Consignee')]]");

    // Second Notify Party
    private By secondNotifyPartyField =
            By.xpath("//input[contains(@name,'secondNotify') or contains(@id,'secondNotify')]");

    // Second Notify Party Address
    private By secondNotifyAddressField =
            By.xpath("//textarea[contains(@name,'secondNotify') or contains(@id,'secondNotify')]");

    // Agent checkbox
    private By loadAllAgentCheckbox =
            By.xpath("//input[@type='checkbox' and following-sibling::text()[contains(.,'Load All Agent')]]");

    // Agent
    private By agentField =
            By.xpath("//input[contains(@name,'agent') or contains(@id,'agent')]");

    // CNF Agent
    private By cnfAgentDropdown =
            By.xpath("//select[contains(@name,'cnf') or contains(@id,'cnf')]");

    // Commodity Type
    private By commodityTypeField =
            By.xpath("//input[contains(@name,'commodity') or contains(@id,'commodity')]");

    // Commercial Invoice No
    private By commercialInvoiceNoField =
            By.xpath("//input[contains(@name,'commercialInvoice') or contains(@id,'commercialInvoice')]");

    // Agreement Type
    private By agreementTypeDropdown =
            By.xpath("//select[contains(@name,'agreement') or contains(@id,'agreement')]");

    // Exp Ref No
    private By expRefNoField =
            By.xpath("//input[contains(@name,'expRef') or contains(@id,'expRef')]");

    // Origin Country
    private By originCountryDropdown =
            By.xpath("//select[contains(@name,'originCountry') or contains(@id,'originCountry')]");

    // Origin Receive
    private By originReceiveField =
            By.xpath("//input[contains(@name,'originReceive') or contains(@id,'originReceive')]");

    // Load Port
    private By loadPortField =
            By.xpath("//input[contains(@name,'loadPort') or contains(@id,'loadPort')]");

    // Destination Country
    private By destinationCountryDropdown =
            By.xpath("//select[contains(@name,'destinationCountry') or contains(@id,'destinationCountry')]");

    // Load All Port checkbox
    private By loadAllPortCheckbox =
            By.xpath("//input[@type='checkbox' and following-sibling::text()[contains(.,'Load All Port')]]");

    // Discharge Port
    private By dischargePortField =
            By.xpath("//input[contains(@name,'discharge') or contains(@id,'discharge')]");

    // Marks & Nos
    private By marksNosField =
            By.xpath("//textarea[contains(@name,'marks') or contains(@id,'marks')]");

    // Description of Goods
    private By descriptionGoodsField =
            By.xpath("//textarea[contains(@name,'description') or contains(@id,'description')]");

    // Remarks
    private By remarksField =
            By.xpath("//textarea[contains(@name,'remarks') or contains(@id,'remarks')]");

    // Reference No
    private By referenceNoField =
            By.xpath("//input[contains(@name,'reference') or contains(@id,'reference')]");

    // NRI
    private By nriDropdown =
            By.xpath("//select[contains(@name,'nri') or contains(@id,'nri')]");

    // NRI Code
    private By nriCodeField =
            By.xpath("//input[contains(@name,'nriCode') or contains(@id,'nriCode')]");

    // Save
    private By saveButton =
            By.xpath("//input[@value='Save'] | //button[normalize-space()='Save']");


    // =========================================================
    // METHODS
    // =========================================================

    /**
     * Select Transport Mode from test data
     */
    public void selectTransportMode(String mode) {

        Select select = new Select(
                wait.until(ExpectedConditions.elementToBeClickable(transportModeDropdown))
        );

        select.selectByVisibleText(mode);
        System.out.println("Selected TransportMode : " + mode);
    }


    /**
     * Select random value from normal HTML dropdown
     */
    private void selectRandomDropdown(By locator) {

        Select select = new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
        );

        List<WebElement> options = select.getOptions();

        // First option "-- Select One --" বাদ
        int randomIndex = 1 + new Random().nextInt(options.size() - 1);

        select.selectByIndex(randomIndex);
    }


    /**
     * Freight Term - random
     */
    public void selectRandomFreightTerm() {

        selectRandomDropdown(freightTermDropdown);
    }


    /**
     * Key Account:
     * space press করলে database/autocomplete data load হবে
     * তারপর random option select হবে
     */
    public void selectRandomKeyAccount() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(keyAccountField));

        field.click();

        WebElement searchInput =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        keyAccountSearchInput
                ));

        searchInput.clear();
        searchInput.sendKeys("t");

        // নিশ্চিত করি "t" input-এ গেছে
        wait.until(driver ->
                "t".equalsIgnoreCase(
                        searchInput.getAttribute("value")
                )
        );

        selectRandomAutocompleteOption();

        System.out.println(
                "Selected KeyAccount : " +
                        field.getText()
        );
    }


    private void selectRandomAutocompleteOption() {

        By optionsLocator =
                By.cssSelector(
                        ".select2-container--open li.select2-results__option"
                );

        // Actual database result আসা পর্যন্ত wait
        wait.until(driver -> {

            List<WebElement> options =
                    driver.findElements(optionsLocator);

            return options.stream()
                    .anyMatch(option -> {

                        String text = option.getText().trim();

                        return !text.isEmpty()
                                && !text.equalsIgnoreCase("Searching…")
                                && !text.equalsIgnoreCase("Searching...")
                                && !text.equalsIgnoreCase("Please enter 1 or more characters")
                                && !text.equalsIgnoreCase("-- Select One --");
                    });
        });

        // Actual options collect
        List<WebElement> options =
                driver.findElements(optionsLocator);

        List<WebElement> validOptions =
                options.stream()
                        .filter(option -> {

                            String text =
                                    option.getText().trim();

                            return !text.isEmpty()
                                    && !text.equalsIgnoreCase("Searching…")
                                    && !text.equalsIgnoreCase("Searching...")
                                    && !text.equalsIgnoreCase(
                                    "Please enter 1 or more characters"
                            )
                                    && !text.equalsIgnoreCase(
                                    "-- Select One --"
                            );
                        })
                        .toList();

        if (validOptions.isEmpty()) {
            throw new RuntimeException(
                    "No Key Account data loaded from database!"
            );
        }

        int randomIndex =
                new Random().nextInt(validOptions.size());

        WebElement selectedOption =
                validOptions.get(randomIndex);

        System.out.println(
                "Total Loaded Options : " +
                        validOptions.size()
        );

        System.out.println(
                "Selected Key Account : " +
                        selectedOption.getText()
        );

        selectedOption.click();
    }




    /**
     * Shipper
     */
    public void selectRandomShipper() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(shipperField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Shipper Title
     */
    public void enterShipperTitle() {

        driver.findElement(shipperTitleField)
                .sendKeys("Test Shipper Title");
    }


    /**
     * Email
     */
    public void enterEmail() {

        driver.findElement(emailField)
                .sendKeys("test@jmail.com");
    }


    /**
     * Shipper Bank Name
     */
    public void enterShipperBankName() {

        driver.findElement(shipperBankNameField)
                .sendKeys("Test HSBC");
    }


    /**
     * Consignee
     */
    public void selectRandomConsignee() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(consigneeField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Buying House
     */
    public void selectRandomBuyingHouse() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(buyingHouseField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Buying House Title
     */
    public void enterBuyingHouseTitle() {

        driver.findElement(buyingHouseTitleField)
                .sendKeys("Test Buying House Title");
    }


    /**
     * First Notify Party
     */
    public void selectRandomFirstNotifyParty() {

        WebElement checkbox =
                driver.findElement(sameAsConsigneeCheckbox);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(firstNotifyNameField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Second Notify Party
     */
    public void enterSecondNotifyParty() {

        driver.findElement(secondNotifyPartyField)
                .sendKeys("Test Second Notify party");
    }


    /**
     * Second Notify Party Address
     */
    public void enterSecondNotifyPartyAddress() {

        driver.findElement(secondNotifyAddressField)
                .sendKeys("Test Second Notify Party Address");
    }


    /**
     * Agent
     */
    public void selectRandomAgent() {

        WebElement checkbox =
                driver.findElement(loadAllAgentCheckbox);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(agentField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * CNF Agent
     */
    public void selectRandomCnfAgent() {

        selectRandomDropdown(cnfAgentDropdown);
    }


    /**
     * Commodity Type
     */
    public void selectRandomCommodityType() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(commodityTypeField));

        field.click();
        field.sendKeys("A");

        selectRandomAutocompleteOption();
    }


    /**
     * Commercial Invoice No
     */
    public void enterCommercialInvoiceNo() {

        driver.findElement(commercialInvoiceNoField)
                .sendKeys("CMCLTST009");
    }


    /**
     * Agreement Type
     */
    public void selectRandomAgreementType() {

        selectRandomDropdown(agreementTypeDropdown);
    }


    /**
     * Exp Ref No
     */
    public void enterExpRefNo() {

        driver.findElement(expRefNoField)
                .sendKeys("EXPRF55");
    }


    /**
     * Origin Country
     */
    public void selectRandomOriginCountry() {

        selectRandomDropdown(originCountryDropdown);
    }


    /**
     * Origin Receive
     */
    public void selectRandomOriginReceive() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(originReceiveField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Load Port
     */
    public void selectRandomLoadPort() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(loadPortField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Destination Country
     */
    public void selectRandomDestinationCountry() {

        selectRandomDropdown(destinationCountryDropdown);
    }


    /**
     * Destination / Discharge Port
     */
    public void selectRandomDischargePort() {

        WebElement checkbox =
                driver.findElement(loadAllPortCheckbox);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(dischargePortField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption();
    }


    /**
     * Marks & Nos
     */
    public void enterMarksAndNos() {

        driver.findElement(marksNosField)
                .sendKeys("As per invoice");
    }


    /**
     * Description of Goods
     */
    public void enterDescriptionOfGoods() {

        driver.findElement(descriptionGoodsField)
                .sendKeys("Ready made garments");
    }


    /**
     * Remarks
     */
    public void enterRemarks() {

        driver.findElement(remarksField)
                .sendKeys("For test purpose");
    }


    /**
     * Reference No
     */
    public void enterReferenceNo() {

        driver.findElement(referenceNoField)
                .sendKeys("Reference Test");
    }


    /**
     * NRI
     */
    public void selectRandomNri() {

        selectRandomDropdown(nriDropdown);
    }


    /**
     * NRI Code
     */
    public void enterNriCode() {

        driver.findElement(nriCodeField)
                .sendKeys("55T66");
    }


    /**
     * Save
     */
    public void clickSave() {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }
}