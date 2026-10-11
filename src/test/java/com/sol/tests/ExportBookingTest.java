package com.sol.tests;

import com.sol.pages.CreateShippingOrderPage;
import com.sol.pages.ExportBookingDetailsPage;
import com.sol.pages.ExportBookingPage;
import com.sol.pages.ExportOperationPage;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportBookingTest extends BaseTest {

    private ExportBookingPage exportBookingPage;

    // Store generated booking number
    private String bookingNumber;

    @Test
    public void createExportBooking() {

        exportBookingPage = new ExportBookingPage(driver);

        // =====================================================
        // EXPORT OPERATION
        // =====================================================

        ExportOperationPage operationPage =
                new ExportOperationPage(driver);

        operationPage.openExportBooking();


        // =====================================================
        // EXPORT BOOKING PAGE
        // =====================================================

        // BASIC DETAILS

        exportBookingPage.selectTransportMode("Air");

        exportBookingPage.selectRandomKeyAccount();

        exportBookingPage.selectRandomFreightTerm();


        // =====================================================
        // SHIPPER
        // =====================================================

        exportBookingPage.selectRandomShipper();

        exportBookingPage.enterShipperTitle();

        exportBookingPage.enterEmail();

        exportBookingPage.enterShipperBankName();

        exportBookingPage.enterShipperBankAddress();


        // =====================================================
        // CONSIGNEE
        // =====================================================

        exportBookingPage.selectRandomConsignee();

        exportBookingPage.enterConsigneeBankName();

        exportBookingPage.enterConsigneeBankAddress();


        // =====================================================
        // BUYING HOUSE
        // =====================================================

        exportBookingPage.selectRandomBuyingHouse();

        exportBookingPage.enterBuyingHouseTitle();


        // =====================================================
        // FIRST NOTIFY PARTY
        // =====================================================

        exportBookingPage.selectRandomFirstNotifyParty();


        // =====================================================
        // SECOND NOTIFY PARTY
        // =====================================================

        exportBookingPage.enterSecondNotifyParty();

        exportBookingPage.enterSecondNotifyPartyAddress();


        // =====================================================
        // AGENT
        // =====================================================

        exportBookingPage.selectRandomAgent();


        // =====================================================
        // CNF AGENT / COMMODITY
        // =====================================================

        exportBookingPage.selectRandomCnfAgent();

        exportBookingPage.selectRandomCommodityType();


        // =====================================================
        // COMMERCIAL INVOICE
        // =====================================================

        exportBookingPage.enterCommercialInvoiceNo();


        // =====================================================
        // AGREEMENT / EXP REF
        // =====================================================

        exportBookingPage.selectRandomAgreementType();

        exportBookingPage.enterExpRefNo();


        // =====================================================
        // ORIGIN
        // =====================================================

        exportBookingPage.selectOriginReceive();

        exportBookingPage.selectLoadPort();


        // =====================================================
        // DESTINATION
        // =====================================================

        exportBookingPage.selectRandomDestCountry();

        exportBookingPage.selectRandomDestinationCity();

        exportBookingPage.selectRandomDischargePort();

        exportBookingPage.selectRandomFinalDestination();


        // =====================================================
        // GOODS DETAILS
        // =====================================================

        exportBookingPage.enterMarksAndNos();

        exportBookingPage.enterDescriptionOfGoods();

        exportBookingPage.enterRemarks();

        exportBookingPage.enterReferenceNo();


        // =====================================================
        // NRI
        // =====================================================

        exportBookingPage.selectRandomNri();

        exportBookingPage.enterNriCode();


        // =====================================================
        // SAVE EXPORT BOOKING
        // =====================================================

        exportBookingPage.clickSave();


        // =====================================================
        // EXPORT BOOKING DETAILS / BOOKING NUMBER
        // =====================================================

        ExportBookingDetailsPage detailsPage =
                new ExportBookingDetailsPage(driver);

        String bookingMessage =
                detailsPage.getBookingNumberMessage();

        System.out.println("Booking Message: " + bookingMessage);

        // Extract and store only the booking number
        Matcher matcher = Pattern
                .compile("Booking No\\.\\s*:\\s*(\\S+)")
                .matcher(bookingMessage);

        if (matcher.find()) {

            bookingNumber = matcher.group(1);

            System.out.println(
                    "Stored Booking Number: " + bookingNumber
            );

        } else {

            throw new RuntimeException(
                    "Booking number not found: " + bookingMessage
            );
        }


        // =====================================================
        // BOOKING DETAILS
        // =====================================================

        detailsPage.enterPO("PO-TEST-001");

        detailsPage.enterStyle("TEST-STYLE");

        detailsPage.enterColor("BLACK");

        detailsPage.enterSO("SO-TEST-001");

        detailsPage.enterCarton("10");

        // For Package Dropdown
        detailsPage.selectPackageType("CARTON");

        detailsPage.enterPCS("100");

        detailsPage.enterDimensionL("10");

        detailsPage.enterDimensionW("20");

        detailsPage.enterDimensionH("30");

        detailsPage.enterCBM("6");

        detailsPage.enterGWT("100");

        detailsPage.enterVWT("110");

        detailsPage.enterNetWt("95");

        detailsPage.enterHSCode("62034200");

        // detailsPage.enterItemClrSkuSoLmpo("TEST-ITEM");

        detailsPage.enterSerialNo("SN-001");

        detailsPage.enterDept("TEST");

        detailsPage.enterRefSize("L");

        detailsPage.enterRmsStyle("TEST-RMS");

        detailsPage.enterCategory("TEST");


        // =====================================================
        // SELECT ROW & COPY
        // =====================================================

        detailsPage.selectBookingRow();

        detailsPage.clickCopy();

        detailsPage.selectBookingStatus();


        // =====================================================
        // SAVE
        // =====================================================

        detailsPage.clickSave();

        createShippingOrder();
    }


    public void createShippingOrder() {

        // =====================================================
        // EXPORT OPERATION
        // =====================================================

        ExportOperationPage operationPage =
                new ExportOperationPage(driver);

        operationPage.openShippingOrder();


        // =====================================================
        // CREATE SHIPPING ORDER PAGE
        // =====================================================

        String transportMode =
                exportBookingPage.getSelectedTransportMode();

        CreateShippingOrderPage shippingOrderPage =
                new CreateShippingOrderPage(
                        driver,
                        transportMode
                );


        // =====================================================
        // SEARCH BOOKING & CREATE SO
        // =====================================================

        shippingOrderPage.searchBookingAndOpenCreateSO(
                bookingNumber
        );


        // =====================================================
        // BASIC DETAILS
        // =====================================================

        shippingOrderPage.selectRandomCFS();
    }
}