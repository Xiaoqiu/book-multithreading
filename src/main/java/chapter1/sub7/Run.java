package chapter1.sub7;

/**
 * @author kate
 * @create 2019/6/6
 * @since 1.0.0
 */
public class Run{
  public static void main(String[] args) throws InterruptedException {
    MyThread myThread = new MyThread();
    myThread.start();
    Thread.sleep(2000);
    myThread.interrupt();
  }
}
class MyThread extends Thread {
  @Override
  public void run() {
    super.run();
    for (int i = 0; i < 500000; i++) {
      System.out.println("i:" + i);
    }
  }
}