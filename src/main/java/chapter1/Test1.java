package chapter1;

import org.junit.Test;

/**
 * @author kate
 * @create 2019/5/31
 * @since 1.0.0
 */
public class Test1 {
  @Test
  public void test() {
    Runnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();
    System.out.println("main over");
  }

}

class MyRunnable implements Runnable {

  public void run() {
    System.out.println("线程运行中！");
  }
}