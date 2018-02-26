package org.wangyt.eve.ext;

import java.util.Enumeration;
import java.util.Vector;

import org.wangyt.eve.ext.test.Person;


public class Source {
    
    /** 监听器集合 */
    private static Vector<Listener> listeners = new Vector<Listener>();
    
    /** 注册监听器 */
    public static void addListener(Listener l) {
        listeners.addElement(l);
    }
    
    /** 移除监听器 */
    public static void removeListener(Listener l) {
        listeners.remove(l);
    }
    
    public static void fireEvent(Event e) {
        if(listeners.size() < 1)
            return;
        
        if(Person.Event.PERSON_FIELDCHANGED_ENENT.equals(e.getType())) {
            Enumeration<Listener> enu = listeners.elements();
            Listener pl;
            while (enu.hasMoreElements()) {
                pl = enu.nextElement();
                pl.callback(e);
            }
        }
    }
    
}
