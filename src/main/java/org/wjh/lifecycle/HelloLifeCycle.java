package org.wjh.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class HelloLifeCycle implements SmartLifecycle {

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

    public int getPhase() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isAutoStartup() {
        // TODO Auto-generated method stub
        return true;
    }

    public void stop(Runnable callback) {
        // TODO Auto-generated method stub
        
    }

}
