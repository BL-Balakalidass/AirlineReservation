import model.Admin;
import model.AirlineStaff;
import model.Passenger;
import service.AuthenticationService;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        Passenger passenger = new Passenger(
                1,
                "Bala",
                "bala@gmail.com",
                "1234567890",
                "01-01-1999",
                "P123456",
                "bala",
                "1234");

        Admin admin = new Admin(
                2,
                "System Admin",
                "admin@gmail.com",
                "9999999999",
                "10-02-1980",
                "A1001",
                "admin",
                "admin123");

        AirlineStaff staff = new AirlineStaff(
                3,
                "staff",
                "staff@gmail.com",
                "8888888888",
                "20-05-1990",
                "S1234",
                "staff",
                "staff123",
                "Operations");

        service.register(passenger);
        service.register(admin);
        service.register(staff);

        service.displayAllUsers();

        passenger.displayPermissions();
        admin.displayPermissions();
        staff.displayPermissions();

        AuthenticationService auth = new AuthenticationService();

        boolean login =
                auth.login(passenger, "john", "1234");

        System.out.println("Login Success : " + login);
    }

}