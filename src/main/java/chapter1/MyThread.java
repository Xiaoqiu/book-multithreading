package chapter1;

import org.junit.Test;

/**
 * @author kate
 * @create 2019/6/4
 * @since 1.0.0
 */
public class MyThread extends Thread {
  private int count = 5;

  @Override
  synchronized public void run() {
    super.run();
    count--;
    System.out.println("thread name: " + this.currentThread().getName() + " counter: " + count);
  }
}


class Run {
  public static void main(String[] args){
    MyThread myThread = new MyThread();
    Thread a = new Thread(myThread,"a");
    Thread b = new Thread(myThread,"b");
    Thread c = new Thread(myThread,"c");
    Thread d = new Thread(myThread,"d");
    Thread e = new Thread(myThread,"e");
    a.start();
    b.start();
    c.start();
    d.start();
    e.start();
  }

}