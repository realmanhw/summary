package tech.summary.demotest.testblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BQ{
  public static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);
}

class TestBlockingQueue {
  public static void main(String[] args){
    ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    threadPool.execute(new Producer());
    threadPool.execute(new Consumer());
  }
}

class Producer implements Runnable{
  @Override
  public void run(){
    int i=0;
    while (true){
      try {
        Thread.sleep(5000);
        BQ.bq.offer(i);
        System.out.println("put "+i);
        i++;
      }catch (Exception e){
        System.out.println("time sleep interrupted");
      }
    }
  }
}

class Consumer implements Runnable{
  @Override
  public void run(){
    while (true){
      try{
        Integer i = BQ.bq.poll(1,TimeUnit.SECONDS);
        System.out.println("get bq "+i);
      }catch (Exception e){
        System.out.println("get interrupted");
      }
    }
  }
}
