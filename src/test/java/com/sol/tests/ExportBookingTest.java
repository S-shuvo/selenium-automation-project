package com.sol.tests;

import com.sol.pages.ExportBookingDetailsPage;
import com.sol.pages.ExportBookingPage;
import com.sol.pages.ExportOperationPage;
import org.testng.annotations.Test;

public class ExportBookingTest extends BaseTest {

    @Test
    public void createExportBooking() {

        // =====================================================
        // EXPORT OPERATION
        // =====================================================

        ExportOperationPage operationPage =
                new ExportOperationPage(driver);

        operationPage.openExportBooking();


        // =====================================================
        // EXPORT BOOKING PAGE
        // =====================================================

        ExportBookingPage exportBookingPage =
                new ExportBookingPage(driver);


        // =====================================================
        // BASIC DETAILS (ExportBooking.java)
        // =====================================================

        // Transport Mode - test data
        exportBookingPage.selectTransportMode("Air");

        // Key Account - random
        exportBookingPage.selectRandomKeyAccount();

        // Freight Term - random
        exportBookingPage.selectRandomFreightTerm();


        // =====================================================
        // SHIPPER (ExportBooking.java)
        // =====================================================

        exportBookingPage.selectRandomShipper();

        // Shipper Address - auto populated

        exportBookingPage.enterShipperTitle();

        exportBookingPage.enterEmail();

        exportBookingPage.enterShipperBankName();

        exportBookingPage.enterShipperBankAddress();

        // =====================================================
        // CONSIGNEE (ExportBooking.java)
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

        // First Notify Address - auto populated

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

        //exportBookingPage.selectRandomOriginCountry();

        exportBookingPage.selectRandomOriginReceive();
        exportBookingPage.selectRandomLoadPort();

        // =====================================================
        // DESTINATION
        // =====================================================

        exportBookingPage.selectRandomDestCountry();
        exportBookingPage.selectRandomDischargePort();

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
        // EXPORT BOOKING DETAILS / PO
        // =====================================================

        ExportBookingDetailsPage detailsPage =
                new ExportBookingDetailsPage(driver);

        System.out.println(
                "Booking Message: " +
                        detailsPage.getBookingNumberMessage()
        );


        // =====================================================
        // PO
        // =====================================================

        detailsPage.enterPO("PO-TEST-001");
        detailsPage.clickSave();
    }
}