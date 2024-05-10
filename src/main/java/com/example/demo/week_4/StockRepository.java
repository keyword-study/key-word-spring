package com.example.demo.week_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class StockRepository {
    private static Stock stock;

    public Stock findById(){
        return stock;
    }
    public void save(Stock saveStock){
        stock = saveStock;
    }
}
