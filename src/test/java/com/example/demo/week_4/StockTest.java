package com.example.demo.week_4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockTest {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before(){
        String id = "product";
        Stock stock =new Stock(id,100L);
        stockRepository.save(stock);
    }

    @Test
    public void 단일_요청(){
        stockService.decrease(1L);
        Stock byId = stockRepository.findById();
        Assertions.assertThat(byId.getQuantity()).isEqualTo(99L);
    }

    @Test
    public void 동시요청() throws InterruptedException {
        int threadCount = 100;
        String id = "product";
        ExecutorService executorService = Executors.newFixedThreadPool(50);//32개 스레드 생성
        CountDownLatch latch = new CountDownLatch(threadCount); //스레드 완료 대기

        for(int i=0; i<threadCount; i++){
            executorService.submit(()->{
                try{
                    stockService.decrease(1L);
                } finally {
                    latch.countDown(); //완료
                }
            });
        }
        latch.await();
        Stock byId = stockRepository.findById();
        Assertions.assertThat(byId.getQuantity()).isEqualTo(0L);
    }



}
