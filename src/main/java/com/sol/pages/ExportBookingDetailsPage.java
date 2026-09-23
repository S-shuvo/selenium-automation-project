package com.sol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportBookingDetailsPage extends BasePage {

    public ExportBookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // =========================================================
    // BOOKING DETAILS LOCATORS
    // =========================================================

    private By poField =
            By.xpath("//input[contains(@name,'po') or contains(@id,'po')]");

    private By styleField =
            By.xpath("//input[contains(@name,'style') or contains(@id,'style')]");

    private By colorField =
            By.xpath("//input[contains(@name,'color') or contains(@id,'color')]");

    private By soField =
            By.xpath("//input[contains(@name,'so') or contains(@id,'so')]");

    private By cartonField =
            By.xpath("//input[contains(@name,'packageQty') or contains(@id,'packageQty')]");

    private By packageDropdown =
            By.xpath("//select[contains(@name,'uom') or contains(@id,'uom')]");

    private By pcsField =
            By.xpath("//input[contains(@name,'pcs') or contains(@id,'pcs')]");

    private By dimensionLField =
            By.xpath("//input[contains(@name,'dimensionL') or contains(@id,'dimensionL')]");

    private By dimensionWField =
            By.xpath("//input[contains(@name,'dimensionW') or contains(@id,'dimensionW')]");

    private By dimensionHField =
            By.xpath("//input[contains(@name,'dimensionH') or contains(@id,'dimensionH')]");

    private By cbmField =
            By.xpath("//input[contains(@name,'cbm') or contains(@id,'cbm')]");

    private By gwtField =
            By.xpath("//input[contains(@name,'gwt') or contains(@id,'gwt')]");

    private By vwtField =
            By.xpath("//input[contains(@name,'vwt') or contains(@id,'vwt')]");

    private By netWtField =
            By.xpath("//input[contains(@name,'netWt') or contains(@id,'netWt')]");

    private By hsCodeField =
            By.xpath("//input[contains(@name,'hsCode') or contains(@id,'hsCode')]");

//    private By itemClrSkuSoLmpoField =
//            By.xpath("//input[contains(@name,'itemClrSkuSoLmpo') or contains(@id,'itemClrSkuSoLmpo')]");

    private By serialNoField =
            By.xpath("//input[contains(@name,'serialNo') or contains(@id,'serialNo')]");

    private By deptField =
            By.xpath("//input[contains(@name,'dept') or contains(@id,'dept')]");

    private By refSizeField =
            By.xpath("//input[contains(@name,'refSize') or contains(@id,'refSize')]");

    private By rmsStyleField =
            By.xpath("//input[contains(@name,'rmsStyle') or contains(@id,'rmsStyle')]");

    private By catField =
            By.xpath("//input[contains(@name,'cat') or contains(@id,'cat')]");


    // =========================================================
    // ROW CHECKBOX
    // =========================================================

    private By rowCheckbox =
            By.xpath("//input[contains(@name,'bookingList[0].poNo')]" +
                    "/ancestor::tr[1]//input[@type='checkbox']");


    // =========================================================
    // COPY BUTTON
    // =========================================================

    private By copyButton =
            By.xpath("//input[contains(@value,'Copy')] | //button[contains(normalize-space(),'Copy')]");

    // =========================================================
    // PO SAVE BUTTON
    // =========================================================

    private By poSaveButton =
            By.xpath("//input[@value='Save'] | //button[normalize-space()='Save']");


    // =========================================================
    // BOOKING SUCCESS MESSAGE
    // =========================================================

    private By bookingNumberMessage =
            By.xpath("//*[contains(normalize-space(),'Booking No.')]");


    // =========================================================
    // ENTER PO
    // =========================================================

    /**
     * Enter PO
     */
    public void enterPO(String poNumber) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(poField)
        ).sendKeys(poNumber);
    }


    // =========================================================
    // ENTER STYLE
    // =========================================================

    /**
     * Enter Style
     */
    public void enterStyle(String style) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(styleField)
        ).sendKeys(style);
    }


    // =========================================================
    // ENTER COLOR
    // =========================================================

    /**
     * Enter Color
     */
    public void enterColor(String color) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(colorField)
        ).sendKeys(color);
    }


    // =========================================================
    // ENTER SO
    // =========================================================

    /**
     * Enter SO
     */
    public void enterSO(String so) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(soField)
        ).sendKeys(so);
    }


    // =========================================================
    // ENTER PACKAGE QUANTITY
    // =========================================================

    /**
     * Enter Package Quantity
     */
    public void enterPackageQty(String quantity) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartonField)
        ).sendKeys(quantity);
    }


    // =========================================================
    // SELECT PACKAGE TYPE
    // =========================================================

    /**
     * Select Package Type
     */
    public void selectPackageType(String packageType) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(packageDropdown)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(packageType);
    }


    // =========================================================
    // ENTER PCS
    // =========================================================

    /**
     * Enter PCS
     */
    public void enterPcs(String pcs) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pcsField)
        ).sendKeys(pcs);
    }


    // =========================================================
    // ENTER DIMENSION L
    // =========================================================

    /**
     * Enter Dimension L
     */
    public void enterDimensionL(String dimensionL) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(dimensionLField)
        ).sendKeys(dimensionL);
    }


    // =========================================================
    // ENTER DIMENSION W
    // =========================================================

    /**
     * Enter Dimension W
     */
    public void enterDimensionW(String dimensionW) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(dimensionWField)
        ).sendKeys(dimensionW);
    }


    // =========================================================
    // ENTER DIMENSION H
    // =========================================================

    /**
     * Enter Dimension H
     */
    public void enterDimensionH(String dimensionH) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(dimensionHField)
        ).sendKeys(dimensionH);
    }


    // =========================================================
    // ENTER CBM
    // =========================================================

    /**
     * Enter CBM
     */
    public void enterCBM(String cbm) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cbmField)
        ).sendKeys(cbm);
    }


    // =========================================================
    // ENTER GWT
    // =========================================================

    /**
     * Enter GWT
     */
    public void enterGWT(String gwt) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(gwtField)
        ).sendKeys(gwt);
    }


    // =========================================================
    // ENTER VWT
    // =========================================================

    /**
     * Enter VWT
     */
    public void enterVWT(String vwt) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(vwtField)
        ).sendKeys(vwt);
    }


    // =========================================================
    // ENTER NET WEIGHT
    // =========================================================

    /**
     * Enter Net Weight
     */
    public void enterNetWt(String netWt) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(netWtField)
        ).sendKeys(netWt);
    }


    // =========================================================
    // ENTER HS CODE
    // =========================================================

    /**
     * Enter HS Code
     */
    public void enterHSCode(String hsCode) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(hsCodeField)
        ).sendKeys(hsCode);
    }


    // =========================================================
    // ENTER ITEM COLOR / SKU / SO / LMPO
    // =========================================================

//    /**
//     * Enter Item Color / SKU / SO / LMPO
//     */
//    public void enterItemClrSkuSoLmpo(String value) {
//
//        wait.until(
//                ExpectedConditions.visibilityOfElementLocated(itemClrSkuSoLmpoField)
//        ).sendKeys(value);
//    }


    // =========================================================
    // ENTER SERIAL NO
    // =========================================================

    /**
     * Enter Serial No
     */
    public void enterSerialNo(String serialNo) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(serialNoField)
        ).sendKeys(serialNo);
    }


    // =========================================================
    // ENTER DEPARTMENT
    // =========================================================

    /**
     * Enter Department
     */
    public void enterDept(String dept) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(deptField)
        ).sendKeys(dept);
    }


    // =========================================================
    // ENTER REFERENCE SIZE
    // =========================================================

    /**
     * Enter Reference Size
     */
    public void enterRefSize(String refSize) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(refSizeField)
        ).sendKeys(refSize);
    }


    // =========================================================
    // ENTER RMS STYLE
    // =========================================================

    /**
     * Enter RMS Style
     */
    public void enterRmsStyle(String rmsStyle) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(rmsStyleField)
        ).sendKeys(rmsStyle);
    }


    // =========================================================
    // ENTER CATEGORY
    // =========================================================

    /**
     * Enter Category
     */
    public void enterCat(String cat) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(catField)
        ).sendKeys(cat);
    }


    // =========================================================
    // SELECT BOOKING ROW
    // =========================================================

    /**
     * Select Booking Row
     */
    public void selectBookingRow() {

        wait.until(
                ExpectedConditions.elementToBeClickable(rowCheckbox)
        ).click();
    }


    // =========================================================
    // CLICK COPY
    // =========================================================

    /**
     * Click Copy
     */
    public void clickCopy() {

        wait.until(
                ExpectedConditions.elementToBeClickable(copyButton)
        ).click();
    }


    // =========================================================
    // GET BOOKING SUCCESS MESSAGE
    // =========================================================

    /**
     * Get complete booking success message
     */
    public String getBookingNumberMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(bookingNumberMessage)
        ).getText();
    }


    // =========================================================
    // GET BOOKING NUMBER
    // =========================================================

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


    // =========================================================
    // SAVE PO
    // =========================================================

    /**
     * Save PO
     */
    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(poSaveButton)
        ).click();
    }
}