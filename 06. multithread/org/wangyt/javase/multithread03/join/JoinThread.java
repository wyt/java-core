package org.wangyt.javase.multithread03.join;

/**
 * 让一个线程等待另一个线程完成的方法: join()
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午04:19:50
 * 
 */
public class JoinThread extends Thread {
	
   public JoinThread(String name) {
      super(name);
   }

   public void run() {
      for (int i = 0; i < 200; i++) {
         System.out.println(getName() + " " + i);
      }
   }

   public static void main(String[] args) throws Exception {
      new JoinThread("新线程").start();

      for (int i = 0; i < 100; i++) {
         if (i == 20) {
            Thread jt = new JoinThread("被join的线程");
            jt.start();
            /**
             * Waits for this thread to die.
             * 
             * 在main线程中调用了jt线程的join方法，此时main线程必须等jt执行结束才会向下执行。
             * 
             * 体现在输出结果上就是："main 20" 及以后的一定在 "被join的线程 199" 之后。
             */
            jt.join();
         }
         System.out.println(Thread.currentThread().getName() + " " + i);
      }
   }
}
