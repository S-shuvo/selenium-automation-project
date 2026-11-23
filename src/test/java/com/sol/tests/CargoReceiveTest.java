package com.sol.tests;
import com.sol.pages.ExportOperationPage;
import com.sol.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CargoReceiveTest extends BaseTest {

    // =====================================================
// STANDALONE EXECUTION
// =====================================================

    @Test
    public void cargoReceiveTest() {

        String bookingNumber =
                ConfigReader.get("booking.number");

        // Manual Booking Number
        if (bookingNumber == null ||
                bookingNumber.isBlank()) {

            bookingNumber =
                    BookingContext.getBookingNumber(serverName);
        }

        execute(
                driver,
                serverName,
                bookingNumber
        );
    }


// =====================================================
// REUSABLE EXECUTION METHOD
// =====================================================

    public void execute(
            WebDriver driver,
            String server,
            String bookingNumber
    ) {

        if (driver == null) {

            throw new IllegalArgumentException(
                    "WebDriver is null."
            );
        }

        System.out.println("================================");
        System.out.println("CARGO RECEIVE MODULE");
        System.out.println("Server         : " + server);
        System.out.println("Booking Number : " + bookingNumber);
        System.out.println("================================");


        // =====================================================
        // OPEN CARGO RECEIVE MODULE
        // =====================================================

        ExportOperationPage operationPage =
                new ExportOperationPage(driver);

        operationPage.openCargoReceive();


        // =====================================================
        // CARGO RECEIVE OPERATIONS
        // =====================================================

        // Actual Cargo Receive form automation
        // will be added after receiving its locators.

        System.out.println(
                "Cargo Receive module opened successfully."
        );
    }


}
