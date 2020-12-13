package tech.summary.demotest.testblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BQ2{
  public static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);
}

class TestBlockingQueue2 {
  public static void main(String[] args){
    ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    threadPool.execute(new Producer2());
    threadPool.execute(new Consumer2());
  }
}

class Producer2 implements Runnable{
  @Override
  public void run(){
    int i=0;
    while (true){
      try {
        Thread.sleep(1000);
        boolean flag = BQ2.bq.offer(i,1,TimeUnit.SECONDS);
        System.out.println("put "+i+" "+BQ2.bq.size()+flag);
        i++;
      }catch (Exception e){
        System.out.println("time sleep interrupted");
      }
    }
  }
}

class Consumer2 implements Runnable{
  @Override
  public void run(){
    while (true){
      try{
        Thread.sleep(10000);
        Integer i = BQ2.bq.poll(5,TimeUnit.SECONDS);
        System.out.println("get bq "+i);
      }catch (Exception e){
        System.out.println("get interrupted");
      }
    }
  }
}
