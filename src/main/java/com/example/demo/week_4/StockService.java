package com.example.demo.week_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    //현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막는다. 이렇게 사용하면 스레드간 동기화를 시켜 data의 thread-safe를 가능하도록함.
    public synchronized void decrease(Long quantity){
        Stock stock = stockRepository.findById();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }
}
