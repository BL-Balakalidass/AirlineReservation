package model;

import static java.lang.Character.getName;
//import static sun.security.pkcs11.wrapper.Functions.getId;

public class AirlineStaff extends User {

    private String role;        // e.g., Operations, Ground Staff
    private String staffId;
    private String username;
    private String password;

    public AirlineStaff(int id,
                        String name,
                        String email,
                        String phone,
                        String dob,
                        String staffId,
                        String username,
                        String password,
                        String role) {

        super(id, name, email, phone, dob);

        this.staffId = staffId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getStaffId() {
        return staffId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Permissions (used in Main.java)
    public void displayPermissions() {
        System.out.println("\n--- Airline Staff Permissions ---");
        System.out.println("✔ View Flights");
        System.out.println("✔ Manage Bookings");
        System.out.println("✔ Update Seat Status");
        System.out.println("✔ Handle Check-in");
        System.out.println("Role: " + role);
    }

    @Override
    public String toString() {
        return "AirlineStaff{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", staffId='" + staffId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    private String getName() {
        return "";
    }

    private String getId() {
        return "";
    }
}