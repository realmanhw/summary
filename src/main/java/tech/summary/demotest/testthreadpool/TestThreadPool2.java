package tech.summary.demotest.testthreadpool;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool2 {

  public static void main(String[] args) {
    // 构造一个线程池
    ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(8, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),
            new ThreadPoolExecutor.CallerRunsPolicy());

    for (int i = 1; i <= 11; i++) {
      try {
        // 产生一个任务，并将其加入到线程池
        String task = "task@ " + i;
        //System.out.println("put " + task);
        threadPool.execute(new ThreadPoolTask2(task));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

/**
 * 线程池执行的任务
 */
class ThreadPoolTask2 implements Runnable, Serializable {
  // 保存任务所需要的数据
  private Object threadPoolTaskData;

  ThreadPoolTask2(Object tasks) {
    this.threadPoolTaskData = tasks;
  }

  @Override
  public void run() {
    synchronized (this){
      try {
        System.out.println(Thread.currentThread().getName()+"："+threadPoolTaskData);
        //this.wait();
        // //便于观察，等待一段时间
        Thread.sleep(10000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      threadPoolTaskData = null;
    }
  }
}
