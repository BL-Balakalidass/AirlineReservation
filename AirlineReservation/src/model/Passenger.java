package model;
import java.time.LocalDate;

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

// =====================================================
// BUSINESS RULE VALIDATION
// =====================================================

    private int age;

    private boolean infant;

    private boolean child;

    private boolean adult;

    private String passport;

    private LocalDate passportExpiryDate;

    // =====================================================
// AGE
// =====================================================

    public int getAge() {

        return age;

    }

    public void setAge(int age) {

        this.age = age;

    }

// =====================================================
// INFANT
// =====================================================

    public boolean isInfant() {

        return infant;

    }

    public void setInfant(boolean infant) {

        this.infant = infant;

    }

// =====================================================
// CHILD
// =====================================================

    public boolean isChild() {

        return child;

    }

    public void setChild(boolean child) {

        this.child = child;

    }

// =====================================================
// ADULT
// =====================================================

    public boolean isAdult() {

        return adult;

    }

    public void setAdult(boolean adult) {

        this.adult = adult;

    }

// =====================================================
// PASSPORT
// =====================================================



    public void setPassport(String passport) {

        this.passport = passport;

    }

// =====================================================
// PASSPORT EXPIRY
// =====================================================

    public LocalDate getPassportExpiryDate() {

        return passportExpiryDate;

    }

    public void setPassportExpiryDate(
            LocalDate passportExpiryDate) {

        this.passportExpiryDate =
                passportExpiryDate;

    }
}