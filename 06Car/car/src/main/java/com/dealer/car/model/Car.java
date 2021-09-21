package com.dealer.car.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@ToString
public class Car {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String manufacturer, model;
    private long price, sales;
    private String imgUrl;
    public Car(String manufacturer, String model, long price, long sales, String imgUrl) {
        this.id = count.incrementAndGet();
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.sales = sales;
        this.imgUrl = imgUrl;
    }
}
