package org.example.ticketsystem.Repository;

import org.example.ticketsystem.Entity.Booking;
import org.example.ticketsystem.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);

}
