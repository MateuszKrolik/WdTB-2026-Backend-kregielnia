package pl.wsb.kregielnia.lane.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/** Tor kręgielni. */
@Entity
@Table(name = "bowling_lane")
public class BowlingLane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lane_number", nullable = false, unique = true)
    private Integer laneNumber;

    @Column(name = "max_players", nullable = false)
    private Integer maxPlayers;

    @Column(name = "hourly_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal hourlyPrice;

    @Column(name = "active", nullable = false)
    private Boolean active;

    protected BowlingLane() {
    }

    public BowlingLane(Integer laneNumber, Integer maxPlayers, BigDecimal hourlyPrice, Boolean active) {
        this.laneNumber = laneNumber;
        this.maxPlayers = maxPlayers;
        this.hourlyPrice = hourlyPrice;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public Integer getLaneNumber() {
        return laneNumber;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public BigDecimal getHourlyPrice() {
        return hourlyPrice;
    }

    public Boolean getActive() {
        return active;
    }
}
