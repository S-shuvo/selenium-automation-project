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
    private By transportModeDropdown = By.id("carrierModeId");

    // Key Account - input field
    private By keyAccountField = By.id("select2-keyAccountId-container");

    // key Account - AutoComplete
    private By keyAccountSearchInput =
            By.cssSelector(".select2-container--open .select2-search__field");

    // Key Account - Autocomplete Options
    private By keyAccountOptions =
            By.cssSelector(".select2-container--open li.select2-results__option");

    // Freight Term
    private By freightTermDropdown =
            By.xpath("//select[option[normalize-space()='CIP']]");

    // Shipper
    private By shipperField =
            By.xpath("//input[contains(@name,'shipper') or contains(@id,'shipper')]");

    // Shipper - Autocomplete Options
    private By shipperOptions = By.xpath(
                    "//ul[contains(@class,'ui-menu')]" +
                            "//div[contains(@class,'ui-menu-item-wrapper')]"
            );

    // Shipper Title
    private By shipperTitleField =
            By.xpath("//input[contains(@name,'shipperTitle') or contains(@id,'shipperTitle')]");

    // Shipper Email
    private By emailField =
            By.xpath("//input[@type='shipperEmail' or contains(@name,'shipperEmail')]");

    // Shipper Bank Name
    private By shipperBankNameField =
            By.xpath("//input[contains(@name,'shipperBankName') or contains(@id,'shipperBankName')]");

    // Shipper Bank Address
    private By shipperBankAddress =
            By.xpath("//textarea[contains(@name,'shipperBankAddress') or contains(@id,'shipperBankAddress')]");

    // Consignee
    private By consigneeField =
            By.xpath("//input[contains(@name,'consignee') or contains(@id,'consignee')]");

    private By autocomplete =
            By.xpath("//ul[contains(@class,'ui-menu') and " +
                    "not(contains(@style, 'display: none'))]" +
                    "//div[contains(@class,'ui-menu-item-wrapper')]");

    // Consignee Bank Name
    private By consigneeBankNameField =
            By.xpath("//input[contains(@name,'consigneeBankName') or contains(@id,'consigneeBankName')]");

    // Consignee Bank Address
    private By consigneeBankAddress =
            By.xpath("//textarea[contains(@name,'consigneeBankAddress') or contains(@id,'consigneeBankAddress')]");


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
            By.xpath("//input[contains(@name,'secondNotify') or contains(@id,'secondNotifyName')]");

    // Second Notify Party Address
    private By secondNotifyAddressField =
            By.xpath("//textarea[contains(@name,'secondNotify') or contains(@id,'secondNotifyAddress')]");

    // Agent checkbox
    private By loadAllAgentCheckbox =
            By.id("loadAllAgent");

    // Agent
    private By agentField =
            By.xpath("//input[contains(@name,'agent') or contains(@id,'agentName')]");

    // CNF Agent
    private By cnfAgentDropdown =
            By.xpath("//select[contains(@name,'cnf') or contains(@id,'cnf')]");

    //Commodity Type field
    private By commodityTypeField =
            By.cssSelector("#select2-commodityTypeId-container");

    //Commodity search field
    private By commoditySearchInput =
            By.cssSelector(
                    ".select2-container--open .select2-search__field");

    //commodity options
    private By commodityOptions = By.cssSelector("li.select2-results__option");

    // Commercial Invoice No
    private By commercialInvoiceNoField =
            By.xpath("//input[contains(@name,'commercialInvoice') or contains(@id,'commercialInvoice')]");

    // Agreement Type
    private By agreementTypeDropdown =
            By.xpath("//select[contains(@name,'paymentMode.id') or contains(@id,'paymentModeId')]");

    // Exp Ref No
    private By expRefNoField =
            By.xpath("//input[contains(@name,'expNo') or contains(@id,'expNo')]");

    // Origin Country
    private By originCountryDropdown =
            By.xpath("//select[contains(@name,'originCountry') or contains(@id,'originCountry')]");

//    private By originCountryField = ...;
//
//    private By originCountrySearchInput =
//            By.cssSelector(".select2-container--open .select2-search__field");
//
//    private By originCountryOptions =
//            By.cssSelector(
//                    ".select2-container--open li.select2-results__option"
//            );


    // Origin Receive
    private By originReceive =
            By.xpath("//input[contains(@name,'receiveCity.name') or contains(@id,'receiveCityName')]");

    // Origin Receive - Autocomplete Options
    private By originReceiveOptions =
            By.xpath(
                    "//ul[contains(@class,'ui-menu') and not(contains(@style,'display: none'))]" +
                            "//div[contains(@class,'ui-menu-item-wrapper')]");
    // Load Port
    private By loadPortField =
            By.xpath("//input[contains(@name,'loadPort') or contains(@id,'loadPort')]");

    // Destination Country - input field
    private By destCountryField =
            By.id("select2-destinationCountryId-container");

    // Destination Country - Search Input
    private By destCountrySearchInput =
            By.cssSelector(".select2-container--open .select2-search__field");

    // Destination Country - Autocomplete Options
    private By destCountryOptions =
            By.cssSelector(
                    ".select2-container--open li.select2-results__option");

    //Destination City
    private By destCityField =
            By.id("dischargeCityName");

    // Load All Port checkbox
    private By loadAllPortCheckbox =
            By.xpath("//input[@type='checkbox' and following-sibling::text()[contains(.,'Load All Port')]]");

    // Discharge Port
    private By dischargePortField =
            By.xpath("//input[contains(@name,'dischargePort.codeNameTxt') or contains(@id,'txtDischargePortCodeName')]");

    //Final Destination
    private By FinalDestinationField =
            By.xpath("//input[contains(@name,'finalDestinationCity.name') or contains(@id,'finalDestinationCityName')]");

    // Marks & Nos
    private By marksNosField =
            By.xpath("//textarea[contains(@name,'marks') or contains(@id,'marks')]");

    // Description of Goods
    private By descriptionGoodsField =
            By.xpath("//textarea[contains(@name,'descriptionOfGoodsId') or contains(@id,'descriptionOfGoodsId')]");

    // Remarks
    private By remarksField =
            By.xpath("//textarea[contains(@name,'remarksId') or contains(@id,'remarksId')]");

    // Reference No
    private By referenceNoField =
            By.xpath("//input[contains(@name,'reffNoId') or contains(@id,'reffNoId')]");

    // NRI
    private By nriDropdown =
            By.xpath("//select[contains(@name,'nonResident') or contains(@id,'nonResidentId')]");

    // NRI Code
    private By nriCodeField =
            By.xpath("//input[contains(@name,'nonResidentName') or contains(@id,'nonResidentName')]");

    // Save
    private By saveButton =
            By.id("btnSave");


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

        selectRandomAutocompleteOption(keyAccountOptions);

        System.out.println(
                "Selected KeyAccount : " +
                        field.getText()
        );
    }


    private void selectRandomAutocompleteOption(By optionsLocator) {

        // Actual database result আসা পর্যন্ত wait
        wait.until(driver -> {

            List<WebElement> options =
                    driver.findElements(optionsLocator);

            return options.stream()
                    .anyMatch(option -> {

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
                    });
        });

        // Actual valid options collect
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

        // যদি কোনো valid data না আসে
        if (validOptions.isEmpty()) {
            throw new RuntimeException(
                    "No autocomplete data loaded from database!"
            );
        }

        // Random option select
        int randomIndex =
                new Random().nextInt(validOptions.size());

        WebElement selectedOption =
                validOptions.get(randomIndex);

        // Console output
        System.out.println(
                "Total Loaded Options : " +
                        validOptions.size()
        );

        System.out.println(
                "Selected Option : " +
                        selectedOption.getText()
        );

        // Select random option
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

        selectRandomAutocompleteOption(shipperOptions);
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
     * Shipper Bank Address
     */
    public void enterShipperBankAddress() {

        driver.findElement(shipperBankAddress)
                .sendKeys("HSBC Gulshan");
    }


    /**
     * Consignee
     */
    public void selectRandomConsignee() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(consigneeField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption(autocomplete);
    }

    /**
     * Consignee Bank Name
     */
    public void enterConsigneeBankName() {

        driver.findElement(consigneeBankNameField)
                .sendKeys("Test SCB");
    }

    /**
     * Consignee Bank Address
     */
    public void enterConsigneeBankAddress() {

        driver.findElement(consigneeBankAddress)
                .sendKeys("SCB Gulshan");

    }
        /**
         * Buying House
         */
        public void selectRandomBuyingHouse () {

            WebElement field =
                    wait.until(ExpectedConditions.elementToBeClickable(buyingHouseField));

            field.click();
            field.sendKeys(" ");

            selectRandomAutocompleteOption(autocomplete);
        }


        /**
         * Buying House Title
         */
        public void enterBuyingHouseTitle () {

            driver.findElement(buyingHouseTitleField)
                    .sendKeys("Test Buying House Title");
        }


        /**
         * First Notify Party
         */
        public void selectRandomFirstNotifyParty () {

            WebElement checkbox =
                    driver.findElement(sameAsConsigneeCheckbox);

            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }


        /**
         * Second Notify Party
         */
        public void enterSecondNotifyParty () {

            driver.findElement(secondNotifyPartyField)
                    .sendKeys("Test Second Notify party");
        }

        /**
         * Second Notify Party Address
         */
        public void enterSecondNotifyPartyAddress () {

            driver.findElement(secondNotifyAddressField)
                    .sendKeys("Test Second Notify Party Address");
        }

        /**
         * Agent
         */
        public void selectRandomAgent () {

            WebElement checkbox =
                    driver.findElement(loadAllAgentCheckbox);

            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement field =
                    wait.until(ExpectedConditions.elementToBeClickable(agentField));

            field.click();
            field.sendKeys(" ");

            selectRandomAutocompleteOption(autocomplete);
        }

        /**
         * CNF Agent
         */
        public void selectRandomCnfAgent () {

            selectRandomDropdown(cnfAgentDropdown);
        }

        /**
         * Commodity Type
         */
        public void selectRandomCommodityType() {

            // Commodity Type dropdown open
            WebElement field =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            commodityTypeField
                    ));

            field.click();

            // Select2 search input
            WebElement searchInput =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            commoditySearchInput
                    ));

            // Search text
            searchInput.clear();
            searchInput.sendKeys("A");


            // Database/autocomplete result থেকে random select
            selectRandomAutocompleteOption(commodityOptions);
        }

        /**
         * Commercial Invoice No
         */
        public void enterCommercialInvoiceNo () {

            driver.findElement(commercialInvoiceNoField)
                    .sendKeys("CMCLTSTCCVV");
        }

        /**
         * Agreement Type
         */
        public void selectRandomAgreementType () {

            selectRandomDropdown(agreementTypeDropdown);
        }

        /**
         * Exp Ref No
         */
        public void enterExpRefNo () {

            driver.findElement(expRefNoField)
                    .sendKeys("EXPRF55");
        }

//        /**
//         * Origin Country (skipped; By default value selected)
//         */
//        public void selectRandomOriginCountry () {
//
//            selectRandomDropdown(originCountryDropdown);
//        }


    /**
     * origin receive
     */

    public void selectRandomOriginReceive() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(originReceive));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption(originReceiveOptions);
    }

        /**
         * Load Port
         */
        public void selectRandomLoadPort () {

            WebElement field =
                    wait.until(ExpectedConditions.elementToBeClickable(loadPortField));

            field.click();
            field.sendKeys(" ");

            selectRandomAutocompleteOption(autocomplete);
        }

    /**
     * Destination Country:
     * Click field -> Search input load -> type "t"
     * -> wait for options -> select random option
     */
    public void selectRandomDestCountry() {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(
                        destCountryField
                ));

        field.click();

        WebElement searchInput =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        destCountrySearchInput
                ));

        searchInput.clear();
        searchInput.sendKeys("t");

        // Confirm "t" was entered into the search field
        wait.until(driver ->
                "t".equalsIgnoreCase(
                        searchInput.getAttribute("value")
                )
        );

        // Select random Destination Country
        selectRandomAutocompleteOption(destCountryOptions);

        System.out.println(
                "Selected Destination Country : " +
                        field.getText()
        );
    }

    /**
     * Destination city
     */
    public void selectRandomDestinationCity () {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(destCityField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption(autocomplete);
    }

        /**
         * Destination / Discharge Port
         */
        public void selectRandomDischargePort () {

            WebElement checkbox =
                    driver.findElement(loadAllPortCheckbox);

            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement field =
                    wait.until(ExpectedConditions.elementToBeClickable(dischargePortField));

            field.click();
            field.sendKeys(" ");

            selectRandomAutocompleteOption(autocomplete);
        }

    /**
     * Final Destination
     */
    public void selectRandomFinalDestination () {

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(FinalDestinationField));

        field.click();
        field.sendKeys(" ");

        selectRandomAutocompleteOption(autocomplete);
    }

        /**
         * Marks & Nos
         */
        public void enterMarksAndNos () {

            driver.findElement(marksNosField)
                    .sendKeys("As per invoice");
        }

        /**
         * Description of Goods
         */
        public void enterDescriptionOfGoods () {

            driver.findElement(descriptionGoodsField)
                    .sendKeys("Ready made garments");
        }

        /**
         * Remarks
         */
        public void enterRemarks () {

            driver.findElement(remarksField)
                    .sendKeys("For test purpose");
        }

        /**
         * Reference No
         */
        public void enterReferenceNo () {

            driver.findElement(referenceNoField)
                    .sendKeys("Reference Test");
        }

        /**
         * NRI
         */
        public void selectRandomNri () {

            selectRandomDropdown(nriDropdown);
        }

        /**
         * NRI Code
         */
        public void enterNriCode () {

            driver.findElement(nriCodeField)
                    .sendKeys("55T66");
        }

        /**
         * Save
         */
        public void clickSave () {

            wait.until(ExpectedConditions.elementToBeClickable(saveButton))
                    .click();
        }
    }