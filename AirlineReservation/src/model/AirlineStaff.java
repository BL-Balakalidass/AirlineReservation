package model;

public class AirlineStaff extends User {

    private String role;
    private String staffId;

    public AirlineStaff(int userId,
                        String fullName,
                        String email,
                        String phone,
                        String dob,
                        String staffId,
                        String username,
                        String password,
                        String role) {

        super(userId,
                fullName,
                email,
                phone,
                dob,
                staffId,      // passportNumber field stores staffId
                username,
                password);

        this.staffId = staffId;
        this.role = role;
    }

    @Override
    public String getRole() {
        return "Airline Staff";
    }

    @Override
    public void displayPermissions() {

        System.out.println("Airline Staff Permissions");
        System.out.println("View Flights");
        System.out.println("Manage Bookings");
        System.out.println("Update Seat Status");
        System.out.println("Handle Check-in");
        System.out.println("Department : " + role);
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return role;
    }

    public void setDepartment(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nStaff ID : " + staffId +
                "\nDepartment : " + role;
    }
}