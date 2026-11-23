package com.sol.tests;
import com.sol.pages.CreateShippingOrderPage;
import com.sol.pages.ExportOperationPage;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ShippingOrderTest extends BaseTest {
    // =====================================================
// STANDALONE EXECUTION
// =====================================================

    @Test
    public void createShippingOrderTest() {

        String bookingNumber =
                ConfigReader.get("booking.number");

        String transportMode;

        // Manual Booking Number
        if (bookingNumber != null &&
                !bookingNumber.isBlank()) {

            transportMode =
                    ConfigReader.get("booking.transportMode");

            System.out.println(
                    "Using Manual Booking Number: " + bookingNumber
            );

        } else {

            // Load Latest Saved Booking Context

            bookingNumber =
                    BookingContext.getBookingNumber(serverName);

            transportMode =
                    BookingContext.getTransportMode(serverName);

            System.out.println(
                    "Using Saved Booking Number: " + bookingNumber
            );
        }

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
    }

}
