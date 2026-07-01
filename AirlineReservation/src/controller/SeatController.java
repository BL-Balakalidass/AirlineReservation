package controller;

import service.SeatService;
import model.Seat;

public class SeatController {

    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    public String selectSeat(String seatId, boolean exitEligible) {
        return seatService.selectSeat(seatId, exitEligible);
    }

    public Seat autoAssign() {
        return seatService.autoAssignSeat();
    }

    public double getExtraCharge(String seatId) {
        return seatService.calculateExtraCharge(seatId);
    }
}