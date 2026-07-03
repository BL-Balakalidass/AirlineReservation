package service;

import model.Booking;
import model.BookingPriority;

import java.util.PriorityQueue;

public class PriorityBookingService {

    private PriorityQueue<Booking> bookingQueue;

    public PriorityBookingService() {

        bookingQueue = new PriorityQueue<>();

    }

    // ---------------------------------------
    // Add Booking
    // ---------------------------------------

    public void addBooking(Booking booking,
                           BookingPriority priority) {

        if (booking == null) {

            System.out.println("Invalid Booking.");

            return;

        }

        booking.setPriority(priority);

        booking.setBookingTime(
                System.currentTimeMillis());

        bookingQueue.offer(booking);

        System.out.println();

        System.out.println("Booking Added To Queue");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Priority : "
                + priority);

    }

    // ---------------------------------------
    // Process Next Booking
    // ---------------------------------------

    public Booking processNextBooking() {

        if (bookingQueue.isEmpty()) {

            System.out.println("No Bookings In Queue.");

            return null;

        }

        Booking booking = bookingQueue.poll();

        System.out.println();

        System.out.println("Processing Booking");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Priority : "
                + booking.getPriority());

        return booking;

    }

    // ---------------------------------------
    // Peek Next Booking
    // ---------------------------------------

    public Booking peekBooking() {

        return bookingQueue.peek();

    }

    // ---------------------------------------
    // Queue Size
    // ---------------------------------------

    public int getQueueSize() {

        return bookingQueue.size();

    }

    // ---------------------------------------
    // Queue Empty
    // ---------------------------------------

    public boolean isEmpty() {

        return bookingQueue.isEmpty();

    }

    // ---------------------------------------
    // Display Queue
    // ---------------------------------------

    public void displayQueue() {

        System.out.println();

        System.out.println("========== BOOKING QUEUE ==========");

        if (bookingQueue.isEmpty()) {

            System.out.println("Queue Empty.");

            return;

        }

        for (Booking booking : bookingQueue) {

            System.out.println("--------------------------------");

            System.out.println("PNR : "
                    + booking.getPnr());

            System.out.println("Priority : "
                    + booking.getPriority());

            System.out.println("Booking Time : "
                    + booking.getBookingTime());

        }

    }

    // ---------------------------------------
    // Generate Report
    // ---------------------------------------

    public void generateReport() {

        int express = 0;

        int regular = 0;

        for (Booking booking : bookingQueue) {

            if (booking.getPriority()
                    == BookingPriority.EXPRESS) {

                express++;

            } else {

                regular++;

            }

        }

        System.out.println();

        System.out.println("========== PRIORITY REPORT ==========");

        System.out.println("Queue Size : "
                + bookingQueue.size());

        System.out.println("Express Bookings : "
                + express);

        System.out.println("Regular Bookings : "
                + regular);

    }

}