package org.wangyt.jdk.event;

import java.lang.Thread;

/**
 * https://my.oschina.net/zchuanzhao/blog/512638
 * 
 * Title: 测试类 Description: 测试了由于改变属性而引起的事件发生
 * 
 * @author WANG YONG TAO
 * @since 2017-01-24
 */
public class TestDemo implements DemoListener {
    
    private DemoSource ds;

    public TestDemo() {
        ds = new DemoSource();
        ds.addDemoListener(this);
        
        System.out.println("添加监听器完毕");
        try {
            Thread.sleep(3000);
            // 改变属性,触发事件
            ds.setName("改变属性,触发事件");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        ds.addDemoListener(this);
        System.out.println("添加监听器完毕2");
        try {
            Thread.sleep(3000);
            // 改变属性,触发事件
            ds.setName("改变属性,触发事件2");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        ds.removeDemoListener(this);
        System.out.println("添加监听器完毕3");
        try {
            Thread.sleep(3000);
            // 改变属性,触发事件
            ds.setName("改变属性,触发事件3");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestDemo();
    }

    /**
     * 实现监听器方法.
     */
    public void demoEvent(DemoEvent dm) {
        System.out.println("事件处理方法");
        System.out.println(dm.getName());
        dm.say();
    }

}
