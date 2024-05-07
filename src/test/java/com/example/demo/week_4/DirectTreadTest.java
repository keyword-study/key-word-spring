package com.example.demo.week_4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DirectTreadTest {

    @Autowired
    private DirectThread directThread;

    @Test
    public void maxTest(){
        Exception exception = null;
        try {
            for (int i = 0; i < 10; i++) {
                directThread.makeThread(i);
            }
        }catch (Exception e){
            e.printStackTrace();
            exception = e;
        }
        Assertions.assertThat(exception).isNotNull();
    }
 // 왜 에러가 발생을 안 할까..?
}