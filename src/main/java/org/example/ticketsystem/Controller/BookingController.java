package org.example.ticketsystem.Controller;

import org.example.ticketsystem.Entity.Booking;
import org.example.ticketsystem.Entity.Login;
import org.example.ticketsystem.Service.BookingService;
import org.example.ticketsystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserveSeat(@RequestBody Map<String, Object> payload) {
        try {

            Long seatId = Long.valueOf(payload.get("seatId").toString());
            String userEmail = payload.get("userEmail").toString();

            Booking booking = bookingService.reserveSeat(seatId, userEmail);

            return ResponseEntity.ok(Map.of(
                    "message", "Seat reservated!",
                    "bookingId", booking.getId(),
                    "seatId", seatId,
                    "user", userEmail
            ));

        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "an intern Servererror."));
        }
    }



}
