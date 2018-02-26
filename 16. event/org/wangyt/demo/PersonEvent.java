package org.wangyt.demo;

public class PersonEvent extends java.util.EventObject {

    private static final long serialVersionUID = -8586072863010334352L;
    
    /**
     * The event type this instance represents. (当前实例PersonEvent所代表的事件类型)
     */
    private String type = null;
    
    /**
     * The Person on which this event occurred. (触发当前时间的Person对象)
     */
    private Person person = null;
    
    public PersonEvent(Person source, String type, Person person) {
        super(source);
        this.type = type;
        this.person = source;
    }
    
    /**
     * 返回事件源.
     * @return
     */
    public Person getPerson() {
        return this.person;
    }
    
    /**
     * 返回事件源.
     * @return
     */
    public Person getSource() {
        return (Person) super.getSource();
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
        return ("PersonEvent['" + getPerson() + "','" + getType() + "']");
    }

}
