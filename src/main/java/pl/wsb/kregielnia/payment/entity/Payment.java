package pl.wsb.kregielnia.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import pl.wsb.kregielnia.account.domain.UserAccount;
import pl.wsb.kregielnia.booking.entity.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** Płatność za rezerwację: jedna rezerwacja ma najwyżej jedną płatność. */
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false, length = 20)
    private PaymentMethod method;

    @Column(name = "paid_at", nullable = false)
    private LocalDateTime paidAt;

    @Column(name = "receipt_number", nullable = false, unique = true, length = 20)
    private String receiptNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false, unique = true)
    private Booking booking;

    /** Pracownik, który przyjął płatność (konto użytkownika). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "received_by_id")
    private UserAccount receivedBy;

    protected Payment() {
    }

    public Payment(BigDecimal amount, PaymentMethod method, LocalDateTime paidAt, String receiptNumber,
                   Booking booking, UserAccount receivedBy) {
        this.amount = amount;
        this.method = method;
        this.paidAt = paidAt;
        this.receiptNumber = receiptNumber;
        this.booking = booking;
        this.receivedBy = receivedBy;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public Booking getBooking() {
        return booking;
    }

    public UserAccount getReceivedBy() {
        return receivedBy;
    }
}
