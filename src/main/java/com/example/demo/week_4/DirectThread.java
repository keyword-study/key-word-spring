package com.example.demo.week_4;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class DirectThread{
    public DirectThread() {
    }

    public void makeThread(int index){
        MyThread myThread = new MyThread(index);
        myThread.run();
    }
    public void executorThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread().getName());

    }
}

class MyThread extends Thread {
    private int index;               // 1.Thread 클래스 상속한 클래스 정의
    public void run() {				// 2.run()메소드 오버라이드 및 스레드 코드 작성
        System.out.println(this.getIndex() +  " : " + this.getName());
    }

    public MyThread(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
