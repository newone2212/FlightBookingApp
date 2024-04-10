package net.javaguides.flightapp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor

@Table(name="Seats")
@Entity
public class seat {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long SeatID;

    @Column(name="seatNo")
    private long SeatNo;

    @Column(name="flightNo")
    private long flightNo;
}