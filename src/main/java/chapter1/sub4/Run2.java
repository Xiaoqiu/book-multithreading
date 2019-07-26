package chapter1.sub4;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author kate
 * @create 2019/6/6
 * @since 1.0.0
 */
public class Run2 {
  public static void main(String[] args) {
    MyThread1 myThread1 = new MyThread1();
    System.out.println("begin : " + System.currentTimeMillis());
     //myThread1.run();
    myThread1.start();
    System.out.println("end : " + System.currentTimeMillis());

  }

}

class MyThread1 extends Thread {
  @Override
  public void run() {
    System.out.println("begin : " + System.currentTimeMillis());
    System.out.println("this name: " + this.currentThread().getName());
    System.out.println("Thread name: " + Thread.currentThread().getName());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("end : " + System.currentTimeMillis());

  }
}