package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {

    // =====================================================
    // DATE FORMATTER
    // =====================================================

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm:ss");

    // =====================================================
    // LOG INFO
    // =====================================================

    public void logInfo(String message) {

        System.out.println(
                "[INFO] "
                        + getCurrentTime()
                        + " : "
                        + message);

    }

    // =====================================================
    // LOG WARNING
    // =====================================================

    public void logWarning(String message) {

        System.out.println(
                "[WARNING] "
                        + getCurrentTime()
                        + " : "
                        + message);

    }

    // =====================================================
    // LOG ERROR
    // =====================================================

    public void logError(String message) {

        System.out.println(
                "[ERROR] "
                        + getCurrentTime()
                        + " : "
                        + message);

    }

    // =====================================================
    // LOG EXCEPTION
    // =====================================================

    public void logException(Exception exception) {

        if (exception == null) {

            return;

        }

        System.out.println(
                "\n========================================");
        System.out.println(
                "EXCEPTION LOG");
        System.out.println(
                "========================================");

        System.out.println(
                "Time      : "
                        + getCurrentTime());

        System.out.println(
                "Exception : "
                        + exception.getClass()
                        .getSimpleName());

        System.out.println(
                "Message   : "
                        + exception.getMessage());

        System.out.println(
                "========================================");

    }

    // =====================================================
    // LOG STACK TRACE
    // =====================================================

    public void logStackTrace(Exception exception) {

        if (exception == null) {

            return;

        }

        System.out.println(
                "\n========== STACK TRACE ==========");

        exception.printStackTrace();

        System.out.println(
                "=================================");

    }

    // =====================================================
    // LOG CUSTOM MESSAGE WITH EXCEPTION
    // =====================================================

    public void logException(
            String message,
            Exception exception) {

        System.out.println(
                "\n========================================");

        System.out.println(
                "CUSTOM EXCEPTION LOG");

        System.out.println(
                "========================================");

        System.out.println(
                "Time      : "
                        + getCurrentTime());

        System.out.println(
                "Message   : "
                        + message);

        if (exception != null) {

            System.out.println(
                    "Exception : "
                            + exception.getClass()
                            .getSimpleName());

            System.out.println(
                    "Details   : "
                            + exception.getMessage());

        }

        System.out.println(
                "========================================");

    }

    // =====================================================
    // CURRENT TIME
    // =====================================================

    private String getCurrentTime() {

        return LocalDateTime.now()
                .format(FORMATTER);

    }

}