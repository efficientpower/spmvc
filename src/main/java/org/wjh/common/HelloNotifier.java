package org.wjh.common;

import org.springframework.stereotype.Component;

@Component
public class HelloNotifier {
    public void send(){
        System.out.println("HelloNotifier");
    }
}
