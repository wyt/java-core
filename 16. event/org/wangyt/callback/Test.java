package org.wangyt.callback;

public class Test {
    public static void main(String[] args) {
        
        FooBar foo = new FooBar();

        /** setCallBack(ICallBackcallBack)方法回调了匿名类的postExec()方法. */
        foo.setCallBack(new ICallBack() {
            public void postExec() {
                System.out.println("在Test类中实现但不能被Test的对象引用,而由FooBar对象调用");
            }
        });
    }
}
