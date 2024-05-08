package com.example.demo.week_4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

@SpringBootTest
class DirectTreadTest {

    @Autowired
    private DirectThread directThread;

    @Autowired
    private Executor executor;

    @Test
    public void directThread(){
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

    @Test
    public void executorThread(){
        Exception exception = null;
        try {
            Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread().getName());
            // 현재 쓰레드 개수는 1 대기에 개수는 1개
            executor.execute(runnable);
            executor.execute(runnable);
            executor.execute(runnable);
        }catch (RejectedExecutionException e){
            exception = e;
        }
        Assertions.assertThat(exception).isInstanceOf(RejectedExecutionException.class);
        Assertions.assertThat(exception).isNotNull();
    }

}