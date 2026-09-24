package com.sol.pages;

import com.sol.utilities.DropdownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportBookingDetailsPage extends BasePage {

    private final DropdownUtils dropdownUtils;

    public ExportBookingDetailsPage(WebDriver driver) {
        super(driver);
        dropdownUtils = new DropdownUtils(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // Booking Information

    private final By poField =
            By.xpath("//input[contains(@name,'po') or contains(@id,'po')]");

    private final By styleField =
            By.xpath("//input[contains(@name,'style') or contains(@id,'style')]");

    private final By colorField =
            By.xpath("//input[contains(@name,'color') or contains(@id,'color')]");

    private final By soField =
            By.xpath("//input[contains(@name,'so') or contains(@id,'so')]");

    private final By cartonField =
            By.xpath("//input[contains(@name,'packageQty') or contains(@id,'packageQty')]");

    private final By packageDropdown =
            By.xpath("//select[contains(@name,'uom') or contains(@id,'uom')]");

    private final By pcsField =
            By.xpath("//input[contains(@name,'pcs') or contains(@id,'pcs')]");


    // =========================================================
    // DIMENSION & WEIGHT
    // =========================================================

    private final By dimensionLField =
            By.xpath("//input[contains(@name,'dimensionL') or contains(@id,'dimensionL')]");

    private final By dimensionWField =
            By.xpath("//input[contains(@name,'dimensionW') or contains(@id,'dimensionW')]");

    private final By dimensionHField =
            By.xpath("//input[contains(@name,'dimensionH') or contains(@id,'dimensionH')]");

    private final By cbmField =
            By.xpath("//input[contains(@name,'cbm') or contains(@id,'cbm')]");

    private final By gwtField =
            By.xpath("//input[contains(@name,'gwt') or contains(@id,'gwt')]");

    private final By vwtField =
            By.xpath("//input[contains(@name,'vwt') or contains(@id,'vwt')]");

    private final By netWtField =
            By.xpath("//input[contains(@name,'netWt') or contains(@id,'netWt')]");


    // =========================================================
    // PRODUCT / ITEM INFORMATION
    // =========================================================

    private final By hsCodeField =
            By.xpath("//input[contains(@name,'hsCode') or contains(@id,'hsCode')]");

    private final By serialNoField =
            By.xpath("//input[contains(@name,'serialNo') or contains(@id,'serialNo')]");

    private final By deptField =
            By.xpath("//input[contains(@name,'dept') or contains(@id,'dept')]");

    private final By refSizeField =
            By.xpath("//input[contains(@name,'refSize') or contains(@id,'refSize')]");

    private final By rmsStyleField =
            By.xpath("//input[contains(@name,'rmsStyle') or contains(@id,'rmsStyle')]");

    private final By catField =
            By.xpath("//input[contains(@name,'cat') or contains(@id,'cat')]");


    // =========================================================
    // BOOKING ROW
    // =========================================================

    private final By rowCheckbox =
            By.xpath(
                    "//input[contains(@name,'bookingList[0].poNo')]" +
                            "/ancestor::tr[1]//input[@type='checkbox']"
            );


    // =========================================================
    // COPY BUTTON
    // =========================================================

    private final By copyButton =
            By.xpath(
                    "//input[contains(@value,'Copy')]" +
                            " | //button[contains(normalize-space(),'Copy')]"
            );

    //======================================================
    // Booking Status
    // =====================================================

    private final By bookingStatus = By.xpath("//select[contains(@name,'bookingStatusId') " +
            "or contains(@id,'bookingStatusId')]");


    // =========================================================
    // SAVE BUTTON
    // =========================================================

    private final By poSaveButton =
            By.xpath(
                    "//input[@value='Save']" +
                            " | //button[normalize-space()='Save']"
            );


    // =========================================================
    // BOOKING NUMBER MESSAGE
    // =========================================================

    private final By bookingNumberMessage =
            By.xpath("//*[contains(normalize-space(),'Booking No.')]");


    // =========================================================
    // COMMON TEXT FIELD METHOD
    // =========================================================

    private void enterText(By locator, String value) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

        element.clear();
        element.sendKeys(value);
    }


    // =========================================================
    // BOOKING INFORMATION METHODS
    // =========================================================

    public void enterPO(String po) {
        enterText(poField, po);
    }

    public void enterStyle(String style) {
        enterText(styleField, style);
    }

    public void enterColor(String color) {
        enterText(colorField, color);
    }

    public void enterSO(String so) {
        enterText(soField, so);
    }

    public void enterCarton(String carton) {
        enterText(cartonField, carton);
    }

    public void selectPackageType(String packageType) {

        dropdownUtils.selectByVisibleText(
                packageDropdown,
                packageType
        );
    }

    public void enterPCS(String pcs) {
        enterText(pcsField, pcs);
    }


    // =========================================================
    // DIMENSION & WEIGHT METHODS
    // =========================================================

    public void enterDimensionL(String value) {
        enterText(dimensionLField, value);
    }

    public void enterDimensionW(String value) {
        enterText(dimensionWField, value);
    }

    public void enterDimensionH(String value) {
        enterText(dimensionHField, value);
    }

    public void enterCBM(String value) {
        enterText(cbmField, value);
    }

    public void enterGWT(String value) {
        enterText(gwtField, value);
    }

    public void enterVWT(String value) {
        enterText(vwtField, value);
    }

    public void enterNetWt(String value) {
        enterText(netWtField, value);
    }


    // =========================================================
    // PRODUCT / ITEM METHODS
    // =========================================================

    public void enterHSCode(String value) {
        enterText(hsCodeField, value);
    }

    public void enterSerialNo(String value) {
        enterText(serialNoField, value);
    }

    public void enterDept(String value) {
        enterText(deptField, value);
    }

    public void enterRefSize(String value) {
        enterText(refSizeField, value);
    }

    public void enterRmsStyle(String value) {
        enterText(rmsStyleField, value);
    }

    public void enterCategory(String value) {
        enterText(catField, value);
    }


    // =========================================================
    // BOOKING ROW
    // =========================================================

    public void selectBookingRow() {

        wait.until(
                ExpectedConditions.elementToBeClickable(rowCheckbox)
        ).click();
    }


    // =========================================================
    // COPY
    // =========================================================

    public void clickCopy() {

        wait.until(
                ExpectedConditions.elementToBeClickable(copyButton)
        ).click();
    }


    // =========================================================
    // BOOKING MESSAGE
    // =========================================================

    public String getBookingNumberMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bookingNumberMessage
                )
        ).getText();
    }


    // =========================================================
    // EXTRACT BOOKING NUMBER
    // =========================================================

    public String getBookingNumber() {

        String message = getBookingNumberMessage();

        Pattern pattern =
                Pattern.compile(
                        "Booking No\\.\\s*:\\s*([A-Z0-9]+)"
                );

        Matcher matcher =
                pattern.matcher(message);

        if (matcher.find()) {

            return matcher.group(1);
        }

        throw new RuntimeException(
                "Booking number not found in message: " + message
        );
    }


    // =========================================================
    // SAVE
    // =========================================================

    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(poSaveButton)
        ).click();
    }


    // =========================================================
    // BOOKING STATUS
    // =========================================================

    public void selectBookingStatus() {

        dropdownUtils.selectByVisibleText(bookingStatus, "Submitted to CRM");
    }
}
