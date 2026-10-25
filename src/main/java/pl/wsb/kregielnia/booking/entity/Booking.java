package pl.wsb.kregielnia.booking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** Rezerwacja toru. Powiązania z torem i klientem dojdą na kolejnych laboratoriach. */
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "duration_hours", nullable = false)
    private Integer durationHours;

    @Column(name = "players", nullable = false)
    private Integer players;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private BookingStatus status;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    protected Booking() {
    }

    public Booking(LocalDateTime startAt, Integer durationHours, Integer players,
                   BookingStatus status, BigDecimal totalPrice) {
        this.startAt = startAt;
        this.durationHours = durationHours;
        this.players = players;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public Integer getDurationHours() {
        return durationHours;
    }

    public Integer getPlayers() {
        return players;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
