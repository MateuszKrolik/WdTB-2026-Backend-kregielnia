# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: booking_extra) · kolumny: 38 · relacje: 3 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| booking | Booking | 8 | customer_id, lane_id |
| bowling_lane | BowlingLane | 5 | — |
| customer | Customer | 8 | — |
| extra | Extra | 5 | — |
| payment | Payment | 7 | booking_id, received_by_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    booking {
        Long id PK
        Long customer_id FK
        Integer duration_hours
        Long lane_id FK
        Integer players
        LocalDateTime start_at
        BookingStatus status
        BigDecimal total_price
    }
    bowling_lane {
        Long id PK
        Boolean active
        BigDecimal hourly_price
        Integer lane_number
        Integer max_players
    }
    customer {
        Long id PK
        String city
        String email
        String full_name
        String phone
        String postal_code
        LocalDate registered_on
        String street
    }
    extra {
        Long id PK
        Boolean available
        String description
        String name
        BigDecimal price
    }
    payment {
        Long id PK
        BigDecimal amount
        Long booking_id FK
        PaymentMethod method
        LocalDateTime paid_at
        String receipt_number
        Long received_by_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    booking ||--o| payment : "booking_id"
    booking }o--o{ extra : "booking_extra"
    bowling_lane ||--o{ booking : "lane_id"
    customer ||--o{ booking : "customer_id"
    user_account |o--o{ payment : "received_by_id"
```
