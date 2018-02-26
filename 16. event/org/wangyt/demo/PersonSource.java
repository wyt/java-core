package org.wangyt.demo;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("all")
public class PersonSource {
    
    // private Map<PersonSource, PersonListener> m = new ConcurrentHashMap<PersonSource, PersonListener>();
    
    /** 监听器集合 */
    private static Vector<PersonListener> listeners = new Vector<PersonListener>();
    
    /** 注册监听器 */
    public static void addPersonListener(PersonListener pl) {
        listeners.addElement(pl);
    }
    
    /** 移除监听器 */
    public static void removePersonListener(PersonListener pl) {
        listeners.remove(pl);
    }
    
    public static void firePersonEvent(PersonEvent pe) {
        
        if(listeners.size() < 1)
            return;
        
        if(Person.Event.PERSON_CREATED_EVENT.equals(pe.getType())) {
            Enumeration<PersonListener> enu = listeners.elements();
            PersonListener pl;
            while (enu.hasMoreElements()) {
                pl = enu.nextElement();
                pl.personCreated(pe);
            }
        }
        
        if(Person.Event.PERSON_FIELDCHANGED_ENENT.equals(pe.getType())) {
            Enumeration<PersonListener> enu = listeners.elements();
            PersonListener pl;
            while (enu.hasMoreElements()) {
                pl = enu.nextElement();
                pl.personFieldChanged(pe);
            }
        }
        
    }
    
}
