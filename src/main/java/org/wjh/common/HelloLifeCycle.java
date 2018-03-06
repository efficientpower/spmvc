package org.wjh.common;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class HelloLifeCycle implements Lifecycle {

    public void start() {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle.start()");
    }

    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle.stop()");
    }

    public boolean isRunning() {
        // TODO Auto-generated method stub
        return false;
    }

}
