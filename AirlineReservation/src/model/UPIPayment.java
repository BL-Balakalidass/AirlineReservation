package model;

public class UPIPayment implements Payment {

    private String upiId;
    private String provider;   // Google Pay, PhonePe, Paytm, BHIM

    public UPIPayment(String upiId, String provider) {
        this.upiId = upiId;
        this.provider = provider;
    }

    @Override
    public boolean validatePayment() {

        if (upiId == null || upiId.isEmpty()) {
            return false;
        }

        return upiId.contains("@");
    }

    @Override
    public boolean processPayment(double amount) {

        if (!validatePayment()) {
            System.out.println("Invalid UPI ID.");
            return false;
        }

        System.out.println("Processing UPI Payment...");
        System.out.println("Provider : " + provider);
        System.out.println("UPI ID   : " + upiId);
        System.out.println("Amount   : ₹" + amount);

        System.out.println("Payment Successful.");

        return true;
    }

    @Override
    public boolean refundPayment(double amount) {

        System.out.println("Refund Initiated.");
        System.out.println("Refund Amount : ₹" + amount);
        System.out.println("Refunding to UPI : " + upiId);

        return true;
    }

    @Override
    public String getTransactionId() {
        return "";
    }

    @Override
    public String getAmount() {
        return "";
    }

    @Override
    public String getStatus() {
        return "";
    }

    public String getProvider() {
        return provider;
    }

    public String getUpiId() {
        return upiId;
    }
}