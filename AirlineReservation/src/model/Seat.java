package model;

public class Seat {

    private String seatId;     // e.g., 12A
    private String seatType;   // WINDOW / MIDDLE / AISLE
    private boolean available;
    private boolean premium;
    private double extraCharge;
    private boolean emergencyExit;
    private String status;     // AVAILABLE / BOOKED / BLOCKED
    private boolean powerOutlet;

    public Seat(String seatId, String seatType,
                boolean premium, double extraCharge,
                boolean emergencyExit, boolean powerOutlet) {

        this.seatId = seatId;
        this.seatType = seatType;
        this.premium = premium;
        this.extraCharge = extraCharge;
        this.emergencyExit = emergencyExit;
        this.powerOutlet = powerOutlet;
        this.available = true;
        this.status = "AVAILABLE";
    }

    public String getSeatId() { return seatId; }
    public String getSeatType() { return seatType; }
    public boolean isAvailable() { return available; }
    public boolean isPremium() { return premium; }
    public double getExtraCharge() { return extraCharge; }
    public boolean isEmergencyExit() { return emergencyExit; }
    public String getStatus() { return status; }

    public void setAvailable(boolean available) { this.available = available; }
    public void setStatus(String status) { this.status = status; }
}