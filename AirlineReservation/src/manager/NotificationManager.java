package manager;

import model.Booking;
import service.EmailGatewayService;
import service.SMSGatewayService;

public class NotificationManager {

    // =====================================================
    // SINGLETON INSTANCE
    // =====================================================

    private static volatile NotificationManager instance;

    // =====================================================
    // SERVICES
    // =====================================================

    private final EmailGatewayService emailService;

    private final SMSGatewayService smsService;

    // =====================================================
    // PRIVATE CONSTRUCTOR
    // =====================================================

    private NotificationManager() {

        emailService =
                new EmailGatewayService();

        smsService =
                new SMSGatewayService();

    }

    // =====================================================
    // GET INSTANCE
    // =====================================================

    public static NotificationManager getInstance() {

        if (instance == null) {

            synchronized (NotificationManager.class) {

                if (instance == null) {

                    instance =
                            new NotificationManager();

                }

            }

        }

        return instance;

    }

    // =====================================================
    // SEND ALL NOTIFICATIONS
    // =====================================================

    public void sendNotification(
            Booking booking,
            String subject,
            String message) {

        if (booking == null) {

            System.out.println(
                    "Booking not available.");

            return;

        }

        sendEmail(
                booking,
                subject,
                message);

        sendSMS(
                booking,
                message);

    }

    // =====================================================
    // SEND EMAIL
    // =====================================================

    public void sendEmail(
            Booking booking,
            String subject,
            String message) {

        if (booking == null) {

            return;

        }

        emailService.sendEmail(
                booking.getPassenger()
                        .getEmail(),
                subject,
                message);

    }

    // =====================================================
    // SEND SMS
    // =====================================================

    public void sendSMS(
            Booking booking,
            String message) {

        if (booking == null) {

            return;

        }

        smsService.sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                message);

    }

    // =====================================================
    // SEND WHATSAPP
    // =====================================================

    public void sendWhatsApp(
            Booking booking,
            String message) {

        if (booking == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "WHATSAPP NOTIFICATION");

        System.out.println(
                "====================================");

        System.out.println(
                "To : "
                        + booking.getPassenger()
                        .getPhoneNumber());

        System.out.println(
                "Message : "
                        + message);

        System.out.println(
                "Status : SENT");

    }

    // =====================================================
    // BOOKING CONFIRMATION
    // =====================================================

    public void sendBookingConfirmation(
            Booking booking) {

        if (booking == null) {

            return;

        }

        emailService.sendBookingEmail(
                booking);

        smsService.sendBookingSMS(
                booking);

    }

    // =====================================================
    // PAYMENT RECEIPT
    // =====================================================

    public void sendPaymentReceipt(
            Booking booking,
            double amount) {

        if (booking == null) {

            return;

        }

        emailService.sendPaymentReceipt(
                booking,
                amount);

    }

    // =====================================================
    // BOARDING PASS
    // =====================================================

    public void sendBoardingPass(
            Booking booking) {

        if (booking == null) {

            return;

        }

        emailService.sendBoardingPass(
                booking);

    }

    // =====================================================
    // CANCELLATION
    // =====================================================

    public void sendCancellation(
            Booking booking) {

        if (booking == null) {

            return;

        }

        emailService.sendCancellationEmail(
                booking);

        smsService.sendCancellationSMS(
                booking);

    }

    // =====================================================
    // REFUND
    // =====================================================

    public void sendRefundNotification(
            Booking booking,
            double refundAmount) {

        if (booking == null) {

            return;

        }

        emailService.sendRefundEmail(
                booking,
                refundAmount);

        smsService.sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                "Refund of ₹"
                        + refundAmount
                        + " has been initiated.");

    }

    // =====================================================
    // FLIGHT DELAY
    // =====================================================

    public void sendFlightDelayNotification(
            Booking booking,
            String delayTime) {

        if (booking == null) {

            return;

        }

        emailService.sendDelayNotification(
                booking,
                delayTime);

        smsService.sendDelayAlert(
                booking,
                delayTime);

    }

    // =====================================================
    // CHECK-IN REMINDER
    // =====================================================

    public void sendCheckInReminder(
            Booking booking) {

        if (booking == null) {

            return;

        }

        smsService.sendCheckInReminder(
                booking);

    }

    // =====================================================
    // BOARDING REMINDER
    // =====================================================

    public void sendBoardingReminder(
            Booking booking) {

        if (booking == null) {

            return;

        }

        smsService.sendBoardingReminder(
                booking);

    }

    // =====================================================
    // DISPLAY STATUS
    // =====================================================

    public void displayStatus() {

        System.out.println(
                "\n====================================");

        System.out.println(
                "NOTIFICATION MANAGER");

        System.out.println(
                "====================================");

        System.out.println(
                "Singleton Instance : ACTIVE");

        System.out.println(
                "Email Service : READY");

        System.out.println(
                "SMS Service : READY");

        System.out.println(
                "WhatsApp Service : READY");

    }

}