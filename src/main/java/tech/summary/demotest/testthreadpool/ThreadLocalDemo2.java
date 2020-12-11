package com.yuepaijie.controller.demotest.testthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalDemo2 {
  public static ThreadLocal<AtomicInteger> t1 = ThreadLocal.withInitial(()->new AtomicInteger(0));
}

class ThreadA extends Thread {
  @Override
  public void run() {
    try {
      for (int i = 0; i < 3; i++) {
        System.out.println("ThreadA get Value = " + ThreadLocalDemo2.t1.get().getAndIncrement());
        Thread.sleep(200);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ThreadB extends Thread {
  @Override
  public void run() {
    try {
      for (int i = 0; i < 3; i++) {
        System.out.println("ThreadB get Value = " + ThreadLocalDemo2.t1.get().getAndIncrement());
        Thread.sleep(200);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Test {
  public static void main(String[] args) {
    try {
      ExecutorService pool = Executors.newFixedThreadPool(2);
      ThreadA a = new ThreadA();
      ThreadB b = new ThreadB();
      pool.submit(a);
      pool.submit(b);
      pool.shutdown();
      for (int i = 0; i < 3; i++) {
        System.out.println("Main get Value " + ThreadLocalDemo2.t1.get().getAndIncrement());
        Thread.sleep(200);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
