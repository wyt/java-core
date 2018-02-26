package org.wangyt.demo;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

@SuppressWarnings("all")
public class Person {
    
    public static class Event {
        
        /** Person被创建事件类型. */
        public static final String PERSON_CREATED_EVENT = "person.created.event";
        /** Person属性被改变事件. */
        public static final String PERSON_FIELDCHANGED_ENENT = "person.fieldChanged.enent";
        /** Person过生日事件类型. */
        public static final String PERSON_ONBIRTHDAY_EVENT = "person.onBirthday.event";
    }
    
    private String name;
    private String sex;
    private int age;
    private Date born;
    
    private Person() {}
    
    private Person(String name, String sex, int age, Date born) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.born = born;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        PersonSource.firePersonEvent(new PersonEvent(this, Person.Event.PERSON_FIELDCHANGED_ENENT, this));
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        PersonSource.firePersonEvent(new PersonEvent(this, Person.Event.PERSON_FIELDCHANGED_ENENT, this));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        PersonSource.firePersonEvent(new PersonEvent(this, Person.Event.PERSON_FIELDCHANGED_ENENT, this));
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
        PersonSource.firePersonEvent(new PersonEvent(this, Person.Event.PERSON_FIELDCHANGED_ENENT, this));
    }

}
