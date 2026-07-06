package model;

public class Passenger extends User {

    private String preferredMeal;
    private String preferredSeat;
    private String specialAssistance;

    public Passenger() {
    }

    public Passenger(int userId,
                     String fullName,
                     String email,
                     String phone,
                     String dob,
                     String passport,
                     String username,
                     String password) {

        super(userId, fullName, email, phone, dob, passport,
                username, password);
    }

    @Override
    public String getRole() {
        return "Passenger";
    }

    @Override
    public void displayPermissions() {

        System.out.println("Passenger Permissions");
        System.out.println("Book Flight");
        System.out.println("Cancel Booking");
        System.out.println("View Booking");
        System.out.println("Update Own Profile");
    }

    public String getPreferredMeal() {
        return preferredMeal;
    }

    public void setPreferredMeal(String preferredMeal) {
        this.preferredMeal = preferredMeal;
    }

    public String getPreferredSeat() {
        return preferredSeat;
    }

    public void setPreferredSeat(String preferredSeat) {
        this.preferredSeat = preferredSeat;
    }

    public String getSpecialAssistance() {
        return specialAssistance;
    }

    public void setSpecialAssistance(String specialAssistance) {
        this.specialAssistance = specialAssistance;
    }

    public void setEmail(String email) {

        this.email = email;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    // =====================================================
// DOCUMENT VALIDATION
// =====================================================

    public boolean hasValidDocuments() {

        return getPassport() != null &&
                !getPassport().isBlank();

    }


    public String getPassport() {
        return "";


    }
}