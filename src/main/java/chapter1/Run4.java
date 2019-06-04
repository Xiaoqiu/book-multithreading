package chapter1;

/**
 * @author kate
 * @create 2019/6/4
 * @since 1.0.0
 */
public class Run4  {

  public static void main(String[] args) {
    MyThread4 run = new MyThread4();
    Thread t1 = new Thread(run);
    Thread t2 = new Thread(run);
    Thread t3 = new Thread(run);
    Thread t4 = new Thread(run);
    Thread t5 = new Thread(run);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }

}

class MyThread4 extends Thread {
  private int i = 5;
  @Override
  public void run() {
    System.out.println("i=" + (i--) + " threadname=" + Thread.currentThread().getName());
  }
}