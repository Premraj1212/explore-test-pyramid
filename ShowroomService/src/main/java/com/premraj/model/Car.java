package com.premraj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @Column(name = "CARID")
    @JsonIgnore
    Integer carId;
    String make;
    String model;
    String years;
    String type;
    @Column(name = "ZEROTOSIXTY")
    BigDecimal zeroToSixty;
    Integer price;

}
