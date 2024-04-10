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

@Table(name="passenger")
@Entity
public class passanger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @Column(name = "name")
    private String name;
    
    @Column(name = "IdentityType")
    private String identityType;

    @Column(name = "IdentityInformation")
    private String identityInformation;
    
    @Column(name="Remarks")
    private String remarks;
}