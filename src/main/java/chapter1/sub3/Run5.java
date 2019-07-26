package chapter1.sub3;

/**
 * @author kate
 * @create 2019/6/5
 * @since 1.0.0
 */
public class Run5 {
  public static void main(String[] args) {
    CountOperate c = new CountOperate();
    Thread t1 = new Thread(c);
    t1.setName("A");
    t1.start();
  }
}

class CountOperate extends Thread {
  public CountOperate() {
    System.out.println("CountOperate begin:");
    System.out.println("CountOperate name:" + Thread.currentThread().getName());
    System.out.println("CountOperate this:" + this.getName());
    System.out.println("CountOperate end:");
  }

  @Override
  public void run() {
    System.out.println("run begin:");
    System.out.println("name:" + Thread.currentThread().getName());
    System.out.println("this:" + this.getName());
    System.out.println("run end:");
  }
}