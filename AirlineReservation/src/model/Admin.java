package model;

public class Admin extends User {

    public Admin() {
    }

    public Admin(int userId,
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
        return "Admin";
    }

    @Override
    public void displayPermissions() {

        System.out.println("Admin Permissions");
        System.out.println("Manage Users");
        System.out.println("Manage Flights");
        System.out.println("Manage Bookings");
        System.out.println("Generate Reports");
    }

}