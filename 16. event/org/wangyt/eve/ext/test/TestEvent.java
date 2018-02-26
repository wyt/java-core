package org.wangyt.eve.ext.test;

import org.wangyt.eve.ext.Event;
import org.wangyt.eve.ext.EventSource;
import org.wangyt.eve.ext.EventSourcePattern;
import org.wangyt.eve.ext.Listener;

@SuppressWarnings("all")
public class TestEvent {

    public void fooBar(String[] args) {
        
        EventSource esp = new EventSourcePattern();
        
        esp.setListener(new Listener() {
            @Override
            public void callback(Event e) {
                doBusiness(e);
            }
        }, new Event<TestEvent>(this, "Test_Event"));

        // 或
        
        new EventSourcePattern(new Event<TestEvent>(this, "Test_Event"))
            .setListener(new Listener() {
                @Override
                public void callback(Event e) {
                    doBusiness(e);
                }
            }
        );
    }
    
    public void doBusiness(Event e) {
        System.out.println("我被回掉了." + e.toString());
        System.out.println("执行业务逻辑.");
    }

}
