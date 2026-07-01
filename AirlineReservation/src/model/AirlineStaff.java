package model;

public class AirlineStaff extends User {

    private String department;

    public AirlineStaff() {
    }

    public AirlineStaff(int userId,
                        String fullName,
                        String email,
                        String phone,
                        String dob,
                        String passport,
                        String username,
                        String password,
                        String department) {

        super(userId, fullName, email, phone, dob,
                passport, username, password);

        this.department = department;
    }

    @Override
    public String getRole() {
        return "Airline Staff";
    }

    @Override
    public void displayPermissions() {

        System.out.println("Airline Staff Permissions");
        System.out.println("Manage Flights");
        System.out.println("View Passenger Bookings");
        System.out.println("Check-In Passenger");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}