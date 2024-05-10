package com.example.demo.week_4;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Stock {
    private String id;
    private Long quantity;

    public Stock(String id, Long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new RuntimeException();
        }
        this.quantity = this.quantity - quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
