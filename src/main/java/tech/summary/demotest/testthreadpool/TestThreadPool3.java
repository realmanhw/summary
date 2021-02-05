package tech.summary.demotest.testthreadpool;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool3 {

  public static void main(String[] args) throws InterruptedException {
    // 构造一个线程池
    ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(2, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2),
            new ThreadPoolExecutor.CallerRunsPolicy());

    for (int i = 1; i <= 5; i++) {
      try {
        // 产生一个任务，并将其加入到线程池
        String task = "task@ " + i;
        //System.out.println("put " + task);
        threadPool.execute(new ThreadPoolTask3(task));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Thread.sleep(3000);
    for (int i = 6; i <= 10; i++) {
      try {
        // 产生一个任务，并将其加入到线程池
        String task = "task@ " + i;
        //System.out.println("put " + task);
        threadPool.execute(new ThreadPoolTask3(task));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

/**
 * 线程池执行的任务
 */
class ThreadPoolTask3 implements Runnable, Serializable {
  // 保存任务所需要的数据
  private Object threadPoolTaskData;

  ThreadPoolTask3(Object tasks) {
    this.threadPoolTaskData = tasks;
  }

  @Override
  public void run() {
    synchronized (this){
      try {
        System.out.println(Thread.currentThread().getName()+"："+threadPoolTaskData);
        //this.wait();
        // //便于观察，等待一段时间
        //Thread.sleep(2000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      threadPoolTaskData = null;
    }
  }
}
