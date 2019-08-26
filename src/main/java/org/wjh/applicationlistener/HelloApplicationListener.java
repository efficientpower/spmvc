package org.wjh.applicationlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelloApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
        System.out.println("HelloApplicationListener.onApplicationEvent()");
    }

}
