
package tech.summary.demotest.testthreadlocal;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalDemo2 {

  //static AtomicInteger a = new AtomicInteger(0);
  public static ThreadLocal<AtomicInteger> t1 = ThreadLocal.withInitial(() -> new AtomicInteger(0));
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
      ThreadA a = new ThreadA();
      ThreadB b = new ThreadB();
      a.start();
      b.start();
      for (int i = 0; i < 3; i++) {
        System.out.println("Main get Value " + ThreadLocalDemo2.t1.get().getAndIncrement());
        Thread.sleep(200);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

