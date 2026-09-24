package com.sol.pages;

import com.sol.utilities.DropdownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ExportBookingPage extends BasePage {

    private final DropdownUtils dropdownUtils;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ExportBookingPage(WebDriver driver) {
        super(driver);
        dropdownUtils = new DropdownUtils(driver);
    }


    // =========================================================
    // LOCATORS
    // =========================================================

    // ---------------------------------------------------------
    // BASIC INFORMATION
    // ---------------------------------------------------------

    private final By transportModeDropdown =
            By.id("carrierModeId");

    private final By freightTermDropdown =
            By.xpath("//select[option[normalize-space()='CIP']]");

    private final By cnfAgentDropdown =
            By.xpath("//select[contains(@name,'cnf') or contains(@id,'cnf')]");

    private final By commodityTypeField =
            By.cssSelector("#select2-commodityTypeId-container");

    private final By commoditySearchInput =
            By.cssSelector(
                    ".select2-container--open .select2-search__field"
            );

    private final By commodityOptions =
            By.cssSelector(
                    ".select2-container--open li.select2-results__option"
            );

    private final By commercialInvoiceNoField =
            By.xpath(
                    "//input[contains(@name,'commercialInvoice') " +
                            "or contains(@id,'commercialInvoice')]"
            );

    private final By agreementTypeDropdown =
            By.xpath(
                    "//select[contains(@name,'paymentMode.id') " +
                            "or contains(@id,'paymentModeId')]"
            );

    private final By expRefNoField =
            By.xpath(
                    "//input[contains(@name,'expNo') " +
                            "or contains(@id,'expNo')]"
            );

    private final By nriDropdown =
            By.xpath(
                    "//select[contains(@name,'nonResident') " +
                            "or contains(@id,'nonResidentId')]"
            );

    private final By nriCodeField =
            By.xpath(
                    "//input[contains(@name,'nonResidentName') " +
                            "or contains(@id,'nonResidentName')]"
            );



    // ---------------------------------------------------------
    // KEY ACCOUNT
    // ---------------------------------------------------------

    private final By keyAccountField =
            By.id("select2-keyAccountId-container");

    private final By keyAccountSearchInput =
            By.cssSelector(
                    ".select2-container--open .select2-search__field"
            );

    private final By keyAccountOptions =
            By.cssSelector(
                    ".select2-container--open li.select2-results__option"
            );


    // ---------------------------------------------------------
    // SHIPPER
    // ---------------------------------------------------------

    private final By shipperField =
            By.xpath(
                    "//input[contains(@name,'shipper') " +
                            "or contains(@id,'shipper')]"
            );

    private final By shipperOptions =
            By.xpath(
                    "//ul[contains(@class,'ui-menu')]" +
                            "//div[contains(@class,'ui-menu-item-wrapper')]"
            );

    private final By shipperTitleField =
            By.xpath(
                    "//input[contains(@name,'shipperTitle') " +
                            "or contains(@id,'shipperTitle')]"
            );

    private final By emailField =
            By.xpath(
                    "//input[@type='shipperEmail' " +
                            "or contains(@name,'shipperEmail')]"
            );

    private final By shipperBankNameField =
            By.xpath(
                    "//input[contains(@name,'shipperBankName') " +
                            "or contains(@id,'shipperBankName')]"
            );

    private final By shipperBankAddress =
            By.xpath(
                    "//textarea[contains(@name,'shipperBankAddress') " +
                            "or contains(@id,'shipperBankAddress')]"
            );


    // ---------------------------------------------------------
    // CONSIGNEE
    // ---------------------------------------------------------

    private final By consigneeField =
            By.xpath(
                    "//input[contains(@name,'consignee') " +
                            "or contains(@id,'consignee')]"
            );

    private final By autocomplete =
            By.xpath(
                    "//ul[contains(@class,'ui-menu') " +
                            "and not(contains(@style, 'display: none'))]" +
                            "//div[contains(@class,'ui-menu-item-wrapper')]"
            );

    private final By consigneeBankNameField =
            By.xpath(
                    "//input[contains(@name,'consigneeBankName') " +
                            "or contains(@id,'consigneeBankName')]"
            );

    private final By consigneeBankAddress =
            By.xpath(
                    "//textarea[contains(@name,'consigneeBankAddress') " +
                            "or contains(@id,'consigneeBankAddress')]"
            );


    // ---------------------------------------------------------
    // BUYING HOUSE
    // ---------------------------------------------------------

    private final By buyingHouseField =
            By.xpath(
                    "//input[contains(@name,'buying') " +
                            "or contains(@id,'buying')]"
            );

    private final By buyingHouseTitleField =
            By.xpath(
                    "//input[contains(@name,'buyingHouseTitle') " +
                            "or contains(@id,'buyingHouseTitle')]"
            );


    // ---------------------------------------------------------
    // NOTIFY PARTY
    // ---------------------------------------------------------

    private final By sameAsConsigneeCheckbox =
            By.xpath(
                    "//input[@type='checkbox' " +
                            "and following-sibling::text()" +
                            "[contains(.,'Same as Consignee')]]"
            );

    private final By secondNotifyPartyField =
            By.xpath(
                    "//input[contains(@name,'secondNotify') " +
                            "or contains(@id,'secondNotifyName')]"
            );

    private final By secondNotifyAddressField =
            By.xpath(
                    "//textarea[contains(@name,'secondNotify') " +
                            "or contains(@id,'secondNotifyAddress')]"
            );


    // ---------------------------------------------------------
    // AGENT
    // ---------------------------------------------------------

    private final By loadAllAgentCheckbox =
            By.id("loadAllAgent");

    private final By agentField =
            By.xpath(
                    "//input[contains(@name,'agent') " +
                            "or contains(@id,'agentName')]"
            );


    // ---------------------------------------------------------
    // ORIGIN / ROUTING
    // ---------------------------------------------------------

    private final By originCountryDropdown =
            By.xpath(
                    "//select[contains(@name,'originCountry') " +
                            "or contains(@id,'originCountry')]"
            );

    private final By originReceive =
            By.xpath(
                    "//input[contains(@name,'receiveCity.name') " +
                            "or contains(@id,'receiveCityName')]"
            );

    private final By originReceiveOptions =
            By.xpath(
                    "//ul[contains(@class,'ui-menu') " +
                            "and not(contains(@style,'display: none'))]" +
                            "//div[contains(@class,'ui-menu-item-wrapper')]"
            );

    private final By loadPortField =
            By.xpath(
                    "//input[contains(@name,'loadPort') " +
                            "or contains(@id,'loadPort')]"
            );


    // ---------------------------------------------------------
    // DESTINATION / ROUTING
    // ---------------------------------------------------------

    private final By destCountryField =
            By.id("select2-destinationCountryId-container");

    private final By destCountrySearchInput =
            By.cssSelector(
                    ".select2-container--open .select2-search__field"
            );

    private final By destCountryOptions =
            By.cssSelector(
                    ".select2-container--open li.select2-results__option"
            );

    private final By destCityField =
            By.id("dischargeCityName");

    private final By loadAllPortCheckbox =
            By.xpath(
                    "//input[@type='checkbox' " +
                            "and following-sibling::text()" +
                            "[contains(.,'Load All Port')]]"
            );

    private final By dischargePortField =
            By.xpath(
                    "//input[contains(@name,'dischargePort.codeNameTxt') " +
                            "or contains(@id,'txtDischargePortCodeName')]"
            );

    private final By finalDestinationField =
            By.xpath(
                    "//input[contains(@name,'finalDestinationCity.name') " +
                            "or contains(@id,'finalDestinationCityName')]"
            );


    // ---------------------------------------------------------
    // DESCRIPTION
    // ---------------------------------------------------------

    private final By marksNosField =
            By.xpath(
                    "//textarea[contains(@name,'marks') " +
                            "or contains(@id,'marks')]"
            );

    private final By descriptionGoodsField =
            By.xpath(
                    "//textarea[contains(@name,'descriptionOfGoodsId') " +
                            "or contains(@id,'descriptionOfGoodsId')]"
            );

    private final By remarksField =
            By.xpath(
                    "//textarea[contains(@name,'remarksId') " +
                            "or contains(@id,'remarksId')]"
            );

    private final By referenceNoField =
            By.xpath(
                    "//input[contains(@name,'reffNoId') " +
                            "or contains(@id,'reffNoId')]"
            );


    // ---------------------------------------------------------
    // SAVE
    // ---------------------------------------------------------

    private final By saveButton =
            By.id("btnSave");


    // =========================================================
    // METHODS
    // =========================================================

    // ---------------------------------------------------------
    // BASIC INFORMATION
    // ---------------------------------------------------------

    public void selectTransportMode(String mode) {

        Select select = new Select(
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                transportModeDropdown
                        )
                )
        );

        select.selectByVisibleText(mode);

        System.out.println(
                "Selected TransportMode : " + mode
        );
    }


    public void selectRandomFreightTerm() {

        dropdownUtils.selectRandomDropdown(
                freightTermDropdown
        );
    }


    public void selectRandomCnfAgent() {

        dropdownUtils.selectRandomDropdown(
                cnfAgentDropdown
        );
    }


    public void selectRandomCommodityType() {

        dropdownUtils.selectRandomAutocomplete(
                commodityTypeField,
                commoditySearchInput,
                commodityOptions
        );
    }


    public void enterCommercialInvoiceNo() {

        String invoiceNo = generateRandomLetters(6);

        driver.findElement(commercialInvoiceNoField)
                .sendKeys(invoiceNo);

        System.out.println(
                "Commercial Invoice No : " + invoiceNo
        );
    }

    private String generateRandomLetters(int length) {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder result = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < length; i++) {

            int index =
                    random.nextInt(letters.length());

            result.append(
                    letters.charAt(index)
            );
        }

        return result.toString();
    }




    public void selectRandomAgreementType() {

        dropdownUtils.selectRandomDropdown(
                agreementTypeDropdown
        );
    }


    public void enterExpRefNo() {

        driver.findElement(expRefNoField)
                .sendKeys("EXPRF55");
    }


    public void selectRandomNri() {

        dropdownUtils.selectRandomDropdown(nriDropdown);
    }


    public void enterNriCode() {

        driver.findElement(nriCodeField)
                .sendKeys("55T66");
    }


    // ---------------------------------------------------------
    // KEY ACCOUNT
    // ---------------------------------------------------------

    public void selectRandomKeyAccount() {

        dropdownUtils.selectRandomAutocomplete(
                keyAccountField,
                keyAccountSearchInput,
                keyAccountOptions
        );
    }


    // ---------------------------------------------------------
    // SHIPPER
    // ---------------------------------------------------------

    public void selectRandomShipper() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                shipperField
                        )
                );

        field.click();
        field.sendKeys(" ");

        // এখানে পুরনো autocomplete method নয়
        // কারণ এটি jQuery UI autocomplete
        selectRandomAutocomplete(
                shipperOptions
        );
    }


    public void enterShipperTitle() {

        driver.findElement(shipperTitleField)
                .sendKeys("Test Shipper Title");
    }


    public void enterEmail() {

        driver.findElement(emailField)
                .sendKeys("test@jmail.com");
    }


    public void enterShipperBankName() {

        driver.findElement(shipperBankNameField)
                .sendKeys("Test HSBC");
    }


    public void enterShipperBankAddress() {

        driver.findElement(shipperBankAddress)
                .sendKeys("HSBC Gulshan");
    }


    // ---------------------------------------------------------
    // CONSIGNEE
    // ---------------------------------------------------------

    public void selectRandomConsignee() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                consigneeField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    public void enterConsigneeBankName() {

        driver.findElement(consigneeBankNameField)
                .sendKeys("Test SCB");
    }


    public void enterConsigneeBankAddress() {

        driver.findElement(consigneeBankAddress)
                .sendKeys("SCB Gulshan");
    }


    // ---------------------------------------------------------
    // BUYING HOUSE
    // ---------------------------------------------------------

    public void selectRandomBuyingHouse() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                buyingHouseField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    public void enterBuyingHouseTitle() {

        driver.findElement(buyingHouseTitleField)
                .sendKeys("Test Buying House Title");
    }


    // ---------------------------------------------------------
    // NOTIFY PARTY
    // ---------------------------------------------------------

    public void selectRandomFirstNotifyParty() {

        WebElement checkbox =
                driver.findElement(
                        sameAsConsigneeCheckbox
                );

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


    public void enterSecondNotifyParty() {

        driver.findElement(secondNotifyPartyField)
                .sendKeys("Test Second Notify party");
    }


    public void enterSecondNotifyPartyAddress() {

        driver.findElement(secondNotifyAddressField)
                .sendKeys(
                        "Test Second Notify Party Address"
                );
    }


    // ---------------------------------------------------------
    // AGENT
    // ---------------------------------------------------------

    public void selectRandomAgent() {

        WebElement checkbox =
                driver.findElement(
                        loadAllAgentCheckbox
                );

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                agentField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    // ---------------------------------------------------------
    // ORIGIN
    // ---------------------------------------------------------

    public void selectRandomOriginReceive() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                originReceive
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                originReceiveOptions
        );
    }


    public void selectRandomLoadPort() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                loadPortField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    // ---------------------------------------------------------
    // DESTINATION
    // ---------------------------------------------------------

    public void selectRandomDestCountry() {

        dropdownUtils.selectRandomAutocomplete(
                destCountryField,
                destCountrySearchInput,
                destCountryOptions
        );
    }


    public void selectRandomDestinationCity() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                destCityField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    public void selectRandomDischargePort() {

        WebElement checkbox =
                driver.findElement(
                        loadAllPortCheckbox
                );

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                dischargePortField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    public void selectRandomFinalDestination() {

        WebElement field =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                finalDestinationField
                        )
                );

        field.click();
        field.sendKeys(" ");

        selectRandomAutocomplete(
                autocomplete
        );
    }


    // ---------------------------------------------------------
    // DESCRIPTION
    // ---------------------------------------------------------

    public void enterMarksAndNos() {

        driver.findElement(marksNosField)
                .sendKeys("As per invoice");
    }


    public void enterDescriptionOfGoods() {

        driver.findElement(descriptionGoodsField)
                .sendKeys("Ready made garments");
    }


    public void enterRemarks() {

        driver.findElement(remarksField)
                .sendKeys("For test purpose");
    }


    public void enterReferenceNo() {

        driver.findElement(referenceNoField)
                .sendKeys("Reference Test");
    }


    // ---------------------------------------------------------
    // SAVE
    // ---------------------------------------------------------

    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButton
                )
        ).click();
    }


    // =========================================================
    // JQUERY UI AUTOCOMPLETE
    // =========================================================

    private void selectRandomAutocomplete(By optionsLocator) {

        wait.until(driver ->
                driver.findElements(optionsLocator)
                        .stream()
                        .anyMatch(option ->
                                !option.getText()
                                        .trim()
                                        .isEmpty()
                        )
        );

        var options =
                driver.findElements(optionsLocator);

        if (options.isEmpty()) {
            throw new RuntimeException(
                    "No autocomplete options found!"
            );
        }

        int randomIndex =
                new java.util.Random()
                        .nextInt(options.size());

        WebElement selectedOption =
                options.get(randomIndex);

        System.out.println(
                "Selected Autocomplete : " +
                        selectedOption.getText()
        );

        selectedOption.click();
    }
}
