package org.wangyt.demo;

import java.lang.reflect.Constructor;

@SuppressWarnings("all")
public class PersonFactory {
    
    public static Person getInstance() {
        Person person = null;
        
        try {
            Class clazz = Person.class;
            Constructor c0 = clazz.getDeclaredConstructor();
            c0.setAccessible(true);
            person = (Person) c0.newInstance();
            
            // 触发person.created.event
            PersonSource.firePersonEvent(new PersonEvent(person, Person.Event.PERSON_CREATED_EVENT, person));
        
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return person;
        }
    }

}
