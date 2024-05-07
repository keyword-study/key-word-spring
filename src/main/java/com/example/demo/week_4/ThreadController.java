package com.example.demo.week_4;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @Autowired
    DirectThread directThread;

    @GetMapping("/thread")
    public void get(){
        for (int i = 0; i < 10; i++) {
            directThread.makeThread(i);
        }
    }
}
