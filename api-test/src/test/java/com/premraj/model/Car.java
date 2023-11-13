package com.premraj.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    String make;
    String model;
    String years;
    String type;
    BigDecimal zeroToSixty;
    Integer price;

}
