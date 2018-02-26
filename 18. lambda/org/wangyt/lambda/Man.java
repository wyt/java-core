package org.wangyt.lambda;

public class Man {

  public void say(People p) {
    p.say();
  }

  public static void main(String[] args) {
    Man m = new Man();
    m.say(new People() {
      public void say() {
        System.out.println("say something");
      }
    });
    main2(args);
  }

  public static void main2(String[] args) {
    Man m = new Man();
    m.say(() -> System.out.println("Hello Lambda Expressions"));
  }

}
