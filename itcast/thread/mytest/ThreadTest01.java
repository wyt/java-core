package mytest;

public class ThreadTest01 {

    public static void main(String[] args) {
        /** 主线程 **/
        new mainThd().start();
    }

    static class subThd extends Thread {
        @Override
        public void run() {
            writeLog();
        }

        public void writeLog() {
            try {
                System.out.println("subThd 开始记录日志...");
                Thread.sleep(5000);
                System.out.println("subThd 完成记录日志...");
                
                /** 回掉mainThd完成方法, 通知其记录日志已经完成. */
                new mainThd().callback("日志记录已完成.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class mainThd extends Thread {
        @Override
        public void run() {
            /** 启动子线程记录日志 */
            new subThd().start();
            
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("mainThd 在执行中...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void callback(String msg) {
            System.out.println("mainThd 接收到子线程消息: " + msg + " 任务完成退出主线程.");
        }
    }

}

