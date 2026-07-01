import model.Admin;
import model.Passenger;
import model.AirlineStaff;

import service.AuthenticationService;
import service.UserService;

// UC3 imports
import model.Seat;
import model.SeatMap;
import repo.SeatRepo;
import service.SeatService;
import service.SeatDisplayService;
import controller.SeatController;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        // ---------------- USERS ----------------
        Passenger passenger = new Passenger(
                1,
                "John",
                "john@gmail.com",
                "9876543210",
                "15-08-1998",
                "P1001",
                "john",
                "1234"
        );

        Admin admin = new Admin(
                2,
                "System Admin",
                "admin@gmail.com",
                "9999999999",
                "10-02-1980",
                "A1001",
                "admin",
                "admin123"
        );

        AirlineStaff staff = new AirlineStaff(
                3,
                "Staff User",
                "staff@gmail.com",
                "8888888888",
                "20-05-1990",
                "S1234",
                "staff",
                "staff123",
                "Operations"
        );

        service.register(passenger);
        service.register(admin);
        service.register(staff);

        service.displayAllUsers();

        passenger.displayPermissions();
        admin.displayPermissions();
        staff.displayPermissions();

        // ---------------- AUTH ----------------
        AuthenticationService auth = new AuthenticationService();

        boolean login = auth.login(passenger, "john", "1234");
        System.out.println("Login Success: " + login);

        // ---------------- UC3 SEAT MODULE ----------------

        SeatMap seatMap = new SeatMap();

        // Creating sample seats
        seatMap.addSeat(new Seat("1A", "WINDOW", true, 500, true, true));
        seatMap.addSeat(new Seat("1B", "MIDDLE", false, 0, false, false));
        seatMap.addSeat(new Seat("1C", "AISLE", true, 300, false, true));
        seatMap.addSeat(new Seat("2A", "WINDOW", false, 0, false, false));
        seatMap.addSeat(new Seat("2B", "MIDDLE", false, 0, false, false));

        // Repo + Service setup
        SeatRepo repo = new SeatRepo(seatMap);
        SeatService seatService = new SeatService(repo, seatMap);
        SeatDisplayService display = new SeatDisplayService(seatMap);
        SeatController controller = new SeatController(seatService);

        // Display seat map
        display.displaySeatMap();

        // Seat selection test
        System.out.println("\n--- Seat Booking ---");
        System.out.println(controller.selectSeat("1A", true));

        // Display after booking
        display.displaySeatMap();
    }
}