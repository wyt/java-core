package org.wangyt.eve.ext;

@SuppressWarnings("all")
public interface EventSource {
    
    void setListener(Listener listener);
    
    void setListener(Listener listener, Event event);
    
}
