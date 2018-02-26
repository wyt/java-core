package org.wangyt.custom.event;
class Test {
    public static void main(String[] args) {
        Initiater initiater = new Initiater();
        Responder responder = new Responder();
        initiater.addListener(responder);
        initiater.sayHello();  // Prints "Hello!!!" and "Hello there..."
    }
}