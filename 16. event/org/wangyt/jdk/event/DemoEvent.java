package org.wangyt.jdk.event;

import java.util.EventObject;

/**
 * 事件类,封装了事件源.
 * 
 * @author WANG YONG TAO
 *
 */
public class DemoEvent extends EventObject {
    
    private static final long serialVersionUID = -7927049255144403043L;
    
    /** 事件源对象. */
    private Object obj;
    private String sName;

    public DemoEvent(Object source, String sName) {
        super(source);
        obj = source;
        this.sName = sName;
    }

    @Override
    public Object getSource() {
        return obj;
    }

    public void say() {
        System.out.println("这个是 say 方法...");
    }

    public String getName() {
        return sName;
    }
}
