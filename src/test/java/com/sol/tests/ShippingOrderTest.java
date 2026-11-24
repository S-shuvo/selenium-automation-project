package com.sol.tests;
import com.sol.pages.CreateShippingOrderPage;
import com.sol.pages.ExportOperationPage;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ShippingOrderTest extends BaseTest {
// =====================================================
// MAIN TEST EXECUTION
// =====================================================

    @Test
    public void createShippingOrderTest() {

        System.out.println("================================");
        System.out.println("STARTING COMPLETE WORKFLOW");
        System.out.println("================================");


        // =====================================================
        // STEP 1: EXPORT BOOKING
        // =====================================================

        System.out.println(
                "Starting Export Booking Module..."
        );

        ExportBookingTest exportBookingTest =
                new ExportBookingTest();

        String bookingNumber =
                exportBookingTest.createExportBookingWorkflow(
                        driver,
                        serverName
                );


        // Retrieve Transport Mode

        String transportMode =
                BookingContext.getTransportMode(serverName);


        System.out.println("================================");
        System.out.println("EXPORT BOOKING COMPLETED");
        System.out.println("Booking Number : " + bookingNumber);
        System.out.println("Transport Mode : " + transportMode);
        System.out.println("================================");


        // =====================================================
        // STEP 2: SHIPPING ORDER
        // =====================================================

        execute(
                driver,
                serverName,
                bookingNumber,
                transportMode
        );
    }


// =====================================================
// REUSABLE EXECUTION METHOD
// =====================================================

    public void execute(
            WebDriver driver,
            String server,
            String bookingNumber,
            String transportMode
    ) {

        if (driver == null) {

            throw new IllegalArgumentException(
                    "WebDriver is null."
            );
        }

        if (bookingNumber == null ||
                bookingNumber.isBlank()) {

            throw new IllegalArgumentException(
                    "Booking Number is empty."
            );
        }

        if (transportMode == null ||
                transportMode.isBlank()) {

            throw new IllegalArgumentException(
                    "Transport Mode is empty."
            );
        }


        System.out.println("================================");
        System.out.println("SHIPPING ORDER MODULE");
        System.out.println("Server         : " + server);
        System.out.println("Booking Number : " + bookingNumber);
        System.out.println("Transport Mode : " + transportMode);
        System.out.println("================================");


        // =====================================================
        // EXPORT OPERATION
        // =====================================================

        ExportOperationPage operationPage =
                new ExportOperationPage(driver);

        operationPage.openShippingOrder();


        // =====================================================
        // CREATE SHIPPING ORDER PAGE
        // =====================================================

        CreateShippingOrderPage shippingOrderPage =
                new CreateShippingOrderPage(
                        driver,
                        transportMode
                );


        // =====================================================
        // SEARCH BOOKING & OPEN CREATE SO
        // =====================================================

        shippingOrderPage.searchBookingAndOpenCreateSO(
                bookingNumber
        );


        // =====================================================
        // SELECT CFS & SAVE
        // =====================================================

        shippingOrderPage.selectRandomCFS();


        System.out.println(
                "Shipping Order process completed."
        );


        // =====================================================
        // NEXT MODULE: CARGO RECEIVE
        // =====================================================

        if (Boolean.parseBoolean(
                ConfigReader.get("workflow.cargoReceive")
        )) {

            System.out.println(
                    "Starting Cargo Receive Module..."
            );

            new CargoReceiveTest().execute(
                    driver,
                    server,
                    bookingNumber
            );

        } else {

            System.out.println(
                    "Cargo Receive Module skipped."
            );
        }


        System.out.println("================================");
        System.out.println("COMPLETE WORKFLOW FINISHED");
        System.out.println("================================");
    }

}
