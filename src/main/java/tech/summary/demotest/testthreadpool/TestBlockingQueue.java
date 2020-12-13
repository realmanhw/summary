package tech.summary.demotest.testthreadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestBlockingQueue {
  public static void main(String[] args){

    BlockingQueue<Integer> queue = new ArrayBlockingQueue(3);
    for (int i=0;i<8;i++){
      queue.add(i);
    }
    //queue.poll(3, TimeUnit.SECONDS);
  }


}
