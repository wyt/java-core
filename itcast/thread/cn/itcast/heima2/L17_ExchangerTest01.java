package cn.itcast.heima2;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger用于进行线程间的数据交换。它提供一个同步点，
 * 
 * 在这个同步点两个线程可以交换彼此的数据。这两个线程通过exchange方法交换数据，
 * 
 * 如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange，
 * 
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
 * 
 * 示例：银行AB岗两人数据校对
 * 
 * @author wangyt
 *
 */
public class L17_ExchangerTest01 {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // A录入银行流水数据
                    String A = "$4123.0234";
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // B录入银行流水数据
                    String B = "$4123.0234";
                    String A = exgr.exchange(B);

                    System.out.println("A和B数据是否一致：" + A.equals(B));
                    System.out.println("A录入的是：" + A + ",B录入是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
