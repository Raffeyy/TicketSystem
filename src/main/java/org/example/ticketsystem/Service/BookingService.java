package org.example.ticketsystem.Service;

import org.example.ticketsystem.Entity.Booking;
import org.example.ticketsystem.Entity.Seat;
import org.example.ticketsystem.Repository.BookingRepository;
import org.example.ticketsystem.Repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;


    public BookingService(SeatRepository seatRepository, BookingRepository bookingRepository) {
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking reserveSeat(Long seatId, String userEmail) {

        Seat seat = seatRepository.findByIdWithLock(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat with ID " + seatId + " does not exist."));

        if (seat.isBooked()) {
            throw new IllegalStateException("This Seat is already booked");
        }

        seat.setBooked(true);
        seatRepository.save(seat);

        Booking booking = new Booking();
        booking.setSeat(seat);
        booking.setUserEmail(userEmail);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }
}
