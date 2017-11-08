package org.wjh.common;

import org.springframework.stereotype.Component;

@Component
public class HelloNotifier {
    
    public HelloNotifier() {
        System.out.println("HelloNotifier 构造方法");
        // TODO Auto-generated constructor stub
    }

    public void send(){
        System.out.println("===============execute HelloNotifier.send()");
    }
}
