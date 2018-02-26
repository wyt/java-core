package org.wangyt.eve.ext;

import java.util.EventListener;

@SuppressWarnings("all")
public interface Listener extends EventListener {
    
    void callback(Event e);
    
}
