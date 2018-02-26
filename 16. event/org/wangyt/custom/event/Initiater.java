package org.wangyt.custom.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Someone who says "Hello"
 * 
 * @author  WANG YONG TAO
 *
 */
class Initiater {
    
    private List<HelloListener> listeners = new ArrayList<HelloListener>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners) {
            hl.someoneSaidHello();
        }
    }
}
