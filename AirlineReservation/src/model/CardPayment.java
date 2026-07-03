package model;

public class CardPayment implements Payment {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private boolean emiEnabled;

    public CardPayment(String cardNumber,
                       String cardHolderName,
                       String expiryDate,
                       String cvv,
                       boolean emiEnabled) {

        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.emiEnabled = emiEnabled;
    }

    @Override
    public boolean validatePayment() {

        if (cardNumber == null || cardNumber.length() != 16)
            return false;

        if (cvv == null || cvv.length() != 3)
            return false;

        return true;
    }

    @Override
    public boolean processPayment(double amount) {

        if (!validatePayment()) {
            System.out.println("Invalid Card Details.");
            return false;
        }

        System.out.println("Processing Card Payment...");
        System.out.println("Card Holder : " + cardHolderName);
        System.out.println("Amount      : ₹" + amount);

        if (emiEnabled) {
            System.out.println("EMI Selected.");
        }

        System.out.println("Payment Successful.");

        return true;
    }

    @Override
    public boolean refundPayment(double amount) {

        System.out.println("Refund Initiated.");
        System.out.println("Refund Amount : ₹" + amount);
        System.out.println("Refunding to Card ending with "
                + cardNumber.substring(cardNumber.length() - 4));

        return true;
    }

    public boolean isEmiEnabled() {
        return emiEnabled;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}