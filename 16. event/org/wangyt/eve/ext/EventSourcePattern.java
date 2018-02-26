package org.wangyt.eve.ext;

@SuppressWarnings("all")
public class EventSourcePattern implements EventSource {
    
    private Listener listener;
    private Event event;
    
    public EventSourcePattern() {}
    
    public EventSourcePattern(Event event) {
        this.event = event;
    }
    
    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
        trigger();
    }

    @Override
    public void setListener(Listener listener, Event event) {
        this.listener = listener;
        this.event = event;
        trigger();
    }
    
    public void trigger() {
        listener.callback(event);
    }

}
