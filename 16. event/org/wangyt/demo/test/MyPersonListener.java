package org.wangyt.demo.test;

import org.wangyt.demo.PersonEvent;
import org.wangyt.demo.PersonListener;

public class MyPersonListener implements PersonListener {

    @Override
    public void onBirthday(PersonEvent pe) {
        System.out.println("Hi, today is my birthday. happy birthday to me!");
    }

    @Override
    public void personCreated(PersonEvent pe) {
        
    }

    @Override
    public void personFieldChanged(PersonEvent pe) {
        
    }

}
