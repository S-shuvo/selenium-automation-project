package com.sol.tests;
import com.sol.pages.ExportBookingDetailsPage;
import com.sol.pages.ExportBookingPage;
import com.sol.pages.ExportOperationPage;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExportBookingTest extends BaseTest {

    private ExportBookingPage exportBookingPage;
    private String bookingNumber;
    private String transportMode;


// =====================================================
// STANDALONE EXECUTION
// =====================================================

    @Test
    public void createExportBooking() {

        createExportBookingWorkflow(
                driver,
                serverName
        );
    }


// =====================================================
// REUSABLE EXPORT BOOKING EXECUTION
// =====================================================

    public String createExportBookingWorkflow(
            WebDriver driver,
            String server
    ) {

        if (driver == null) {

            throw new IllegalArgumentException(
                    "WebDriver is null."
            );
        }

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


        // Store Transport Mode

        transportMode =
                exportBookingPage.getSelectedTransportMode();


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

        System.out.println(
                "Booking Message: " + bookingMessage
        );

        // Extract Booking Number

        bookingNumber = detailsPage.getBookingNumber();

        System.out.println(
                "Generated Booking Number: " + bookingNumber
        );


        // =====================================================
        // BOOKING DETAILS
        // =====================================================

        detailsPage.enterPO("PO-TEST-001");

        detailsPage.enterStyle("TEST-STYLE");

        detailsPage.enterColor("BLACK");

        detailsPage.enterSO("SO-TEST-001");

        detailsPage.enterCarton("10");

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
        // SAVE BOOKING DETAILS
        // =====================================================

        detailsPage.clickSave();


        // =====================================================
        // SAVE BOOKING CONTEXT
        // =====================================================

        BookingContext.save(
                server,
                bookingNumber,
                transportMode
        );


        System.out.println("================================");
        System.out.println("EXPORT BOOKING COMPLETED");
        System.out.println("Server         : " + server);
        System.out.println("Booking Number : " + bookingNumber);
        System.out.println("Transport Mode : " + transportMode);
        System.out.println("================================");


        // Return Booking Number for Next Module

        return bookingNumber;
    }

}