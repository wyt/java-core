package org.wangyt.demo;

import java.util.EventListener;

public interface PersonListener extends EventListener {
    
    public void personCreated(PersonEvent pe);
    
    /** 过生日要长一岁; */
    public void onBirthday(PersonEvent pe);
    
    public void personFieldChanged(PersonEvent pe);
    
}
