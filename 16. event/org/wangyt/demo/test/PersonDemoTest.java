package org.wangyt.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.wangyt.demo.Person;
import org.wangyt.demo.PersonEvent;
import org.wangyt.demo.PersonFactory;
import org.wangyt.demo.PersonListener;
import org.wangyt.demo.PersonSource;



/**
 * 
 * 對象初始化的時候添加listener
 * 
 * @author wangyongtao
 *
 */
@SuppressWarnings("all")
public class PersonDemoTest {
    
    public static void main(String[] args) throws ParseException {
        
        PersonSource ps = new PersonSource();
        ps.addPersonListener(new PersonListener() {
            @Override
            public void personCreated(PersonEvent pe) {
                System.out.println("发生了创建对象事件: " + pe.toString());
            }
            @Override
            public void onBirthday(PersonEvent pe) {
                // TODO 过生日事件如何触发呢, 启动一个定时任务线程处理.
            }
            @Override
            public void personFieldChanged(PersonEvent pe) {
                System.out.println("对象属性被改变: " + pe.toString());
            }
        });
        
        ps.addPersonListener(new PersonListener() {
            @Override
            public void personCreated(PersonEvent pe) {
                System.out.println("发生了创建对象事件2: " + pe.toString());
            }
            @Override
            public void onBirthday(PersonEvent pe) {
                // TODO 过生日事件如何触发呢, 启动一个定时任务线程处理.
            }
            @Override
            public void personFieldChanged(PersonEvent pe) {
                System.out.println("对象属性被改变2: " + pe.toString());
            }
        });
        
        Person person = PersonFactory.getInstance();
        Person person2 = PersonFactory.getInstance();
        
        person2.setName("wangyongtao");
        
    }
}
