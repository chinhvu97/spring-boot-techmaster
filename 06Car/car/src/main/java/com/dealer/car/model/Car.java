package com.dealer.car.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private int id;
    private String manufacturer, model;
    private long price, sales;
    private String imgUrl;
}
