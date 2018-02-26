package org.wangyt.javase.multithread07.app;

/**
 * 消費者线程 -- 负责移除货物(调用Store的remove方法)
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午01:48:39
 * 
 */
public class Consumer extends Thread
{
    private Store store;

    public Consumer(Store store)
    {
        this.store = store;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                store.remove();
                Thread.sleep(1300);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}