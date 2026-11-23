package com.sol.tests;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class BookingContext {
    private static Path getFile(String server) {

        return Path.of(
                "target",
                "test-data",
                server + "-booking-context.properties"
        );
    }

    // Save Booking Information
    public static void save(
            String server,
            String bookingNumber,
            String transportMode
    ) {

        if (bookingNumber == null || bookingNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Booking number cannot be empty."
            );
        }

        Properties properties = new Properties();

        properties.setProperty("booking.number", bookingNumber);
        properties.setProperty("transport.mode", transportMode);

        try {

            Path file = getFile(server);

            Files.createDirectories(file.getParent());

            try (var output = Files.newOutputStream(file)) {

                properties.store(
                        output,
                        "SOL Booking Context"
                );
            }

            System.out.println(
                    "Booking Context Saved: " + bookingNumber
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to save Booking Context.",
                    e
            );
        }
    }

    // Load Booking Information
    public static Properties load(String server) {

        Path file = getFile(server);

        if (!Files.exists(file)) {

            throw new RuntimeException(
                    "No saved booking context found for " + server
            );
        }

        Properties properties = new Properties();

        try (var input = Files.newInputStream(file)) {

            properties.load(input);

            return properties;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read Booking Context.",
                    e
            );
        }
    }

    // Get Booking Number
    public static String getBookingNumber(String server) {

        String bookingNumber =
                load(server).getProperty("booking.number");

        if (bookingNumber == null || bookingNumber.isBlank()) {

            throw new RuntimeException(
                    "Saved booking number is empty for " + server
            );
        }

        return bookingNumber;
    }

    // Get Transport Mode
    public static String getTransportMode(String server) {

        String transportMode =
                load(server).getProperty("transport.mode");

        if (transportMode == null || transportMode.isBlank()) {

            throw new RuntimeException(
                    "Saved transport mode is empty for " + server
            );
        }

        return transportMode;
    }

}
