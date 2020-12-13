//package tech.summary.demotest.testthreadlocal;
//
///**
// * volatile在i++的情况下失效，因为这不是原子操作
// */
//
//public class ThreadLocalDemo4 {
//
//  public volatile static Integer t1 = 0;
//}
//
//class ThreadA extends Thread {
//
//  @Override
//  public void run() {
//    for (int i = 0; i < 3; i++) {
//      System.out.println("ThreadA get Value = " + ThreadLocalDemo4.t1++);
//    }
//  }
//}
//
//class ThreadB extends Thread {
//
//  @Override
//  public void run() {
//    for (int i = 0; i < 3; i++) {
//      System.out.println("ThreadB get Value = " + ThreadLocalDemo4.t1++);
//    }
//  }
//}
//
//class Test {
//
//  public static void main(String[] args) {
//    ThreadA a = new ThreadA();
//    ThreadB b = new ThreadB();
//    a.start();
//    b.start();
//    for (int i = 0; i < 3; i++) {
//      System.out.println("Main get Value " + ThreadLocalDemo4.t1++);
//    }
//  }
//}
