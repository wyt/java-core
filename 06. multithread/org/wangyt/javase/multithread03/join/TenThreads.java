package org.wangyt.javase.multithread03.join;

/**
 * 求二位数组最大值.
 * 
 * @author WANG YONG TAO
 */
public class TenThreads {
  
  public static int[][] bigMatrix = {{1, 10, 100}, {2, 20, 200}, {3, 33, 333}, 
                                     {4, 40, 444}, {5, 50, 500}, {6, 66, 666}, 
                                     {7, 77, 777}, {8, 88, 888}, {9, 99, 999}};

  public static void main(String[] args) throws InterruptedException {
    
    WorkerThread[] threads = new WorkerThread[9];
    
    int max = Integer.MIN_VALUE;
    
    for (int i = 0; i < 9; i++) {
      threads[i] = new WorkerThread(bigMatrix[i]);
      threads[i].start();
    }

    for (int i = 0; i < 9; i++) {
      threads[i].join();
      max = Math.max(max, threads[i].getMax());
    }
    
    System.out.println("Maximum value is:" + max);
  }

  /**
   * Work thread.
   */
  private static class WorkerThread extends Thread {

    int max = Integer.MIN_VALUE;

    int[] ourArray;

    public int getMax() {
      return max;
    }

    public WorkerThread(int[] ourArray) {
      this.ourArray = ourArray;
      for (int i = 0; i < ourArray.length; i++) {
        System.out.print(ourArray[i] + "    ");
      }
      System.out.println();
    }

    public void run() {
      for (int i = 0; i < ourArray.length; i++) {
        max = Math.max(max, ourArray[i]);
      }
    }
  }
}
