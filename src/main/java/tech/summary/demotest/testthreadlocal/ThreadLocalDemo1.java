//package com.yuepaijie.controller;
//
//public class ThreadLocalDemo1 {
//  public static ThreadLocal t1 = new ThreadLocal();
//}
//
//class ThreadA extends Thread {
//  @Override
//  public void run() {
//    try {
//      for (int i = 0; i < 3; i++) {
//        ThreadLocalDemo1.t1.set("TreadA " + (i + 1));
//        System.out.println("Thread get Value = " + ThreadLocalDemo1.t1.get());
//        Thread.sleep(200);
//      }
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
//}
//class ThreadB extends Thread {
//  @Override
//  public void run() {
//    try {
//      for (int i = 0; i < 3; i++) {
//        ThreadLocalDemo1.t1.set("TreadB " + (i + 1));
//        System.out.println("Thread get Value = " + ThreadLocalDemo1.t1.get());
//        Thread.sleep(200);
//      }
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
//}
//class Test {
//  public static void main(String[] args) {
//    try {
//      ThreadA a = new ThreadA();
//      ThreadB b = new ThreadB();
//      a.start();
//      b.start();
//      for (int i = 0; i < 3; i++) {
//        ThreadLocalDemo1.t1.set("Main " + (i + 1));
//        System.out.println("Main get Value " + ThreadLocalDemo1.t1.get());
//        Thread.sleep(200);
//      }
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
//}
