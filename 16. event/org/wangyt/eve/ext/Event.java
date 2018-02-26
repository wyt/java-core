package org.wangyt.eve.ext;

/**
 * @since 2017-03-14 23:36:11
 * 
 * @author WANG YONG TAO
 *
 * @param <T>
 */
public class Event<T> extends java.util.EventObject {

    private static final long serialVersionUID = -8586072863010334352L;

    /**
     * The event type this instance represents. (当前实例Event所代表的事件类型)
     */
    private String type = null;

    /**
     * The Person on which this event occurred. (触发当前事件的T对象)
     */
    private T source = null;

    public Event(T source, String type) {
        super(source);
        this.type = type;
        this.source = source;
    }

    /**
     * 返回事件源.
     * 
     * @return
     */
    public T getSource() {
        // return (T) super.getSource();
        return this.source;
    }

    /**
     * Return the event type of this event. (返回事件类型)
     */
    public String getType() {
        return (this.type);
    }

    /**
     * Return a string representation of this event.
     */
    @Override
    public String toString() {
        return ("Winc Event['" + getSource() + "','" + getType() + "']");
    }

}
