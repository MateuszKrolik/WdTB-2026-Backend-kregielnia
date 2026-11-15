package pl.wsb.kregielnia.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.kregielnia.booking.entity.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer_FullName(String fullName);
}