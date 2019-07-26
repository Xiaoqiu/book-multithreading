package chapter1.sub4;

/**
 * @author kate
 * @create 2019/6/5
 * @since 1.0.0
 */
public class Run {
  public static void main(String[] args) {
    CountOperate c = new CountOperate();
    Thread t = new Thread(c);
    System.out.println("main begin t alive:" + t.isAlive());
    t.setName("A");
    t.start();
    System.out.println("main end t alive:" + t.isAlive());
  }
  
}

class CountOperate extends Thread {
  public CountOperate() {
    System.out.println("构造方法begin");
    System.out.println("current Thread name : " + Thread.currentThread().getName());
    System.out.println("current Thread alive : " + Thread.currentThread().isAlive());

    System.out.println("this name : " + this.getName());
    System.out.println("this alive : " + this.isAlive());
    System.out.println("构造方法end");
  }

  @Override
  public void run() {
    System.out.println("run begin");
    System.out.println("current Thread name : " + Thread.currentThread().getName());
    System.out.println("current Thread alive : " + Thread.currentThread().isAlive());
    System.out.println("this name : " + this.getName());
    System.out.println("this alive : " + this.isAlive());
    System.out.println("run end");
  }
}