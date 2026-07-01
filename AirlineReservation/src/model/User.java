package model;

public abstract class User {

    protected int userId;
    protected String fullName;
    protected String email;
    protected String phone;
    protected String dateOfBirth;
    protected String passportNumber;
    protected String username;
    protected String password;
    protected boolean emailVerified;
    protected boolean phoneVerified;

    public User() {
    }

    public User(int userId,
                String fullName,
                String email,
                String phone,
                String dateOfBirth,
                String passportNumber,
                String username,
                String password) {

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.username = username;
        this.password = password;
    }

    public abstract String getRole();

    public abstract void displayPermissions();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    @Override
    public String toString() {

        return "User ID : " + userId +
                "\nName : " + fullName +
                "\nEmail : " + email +
                "\nPhone : " + phone +
                "\nDOB : " + dateOfBirth +
                "\nPassport : " + passportNumber;
    }

}