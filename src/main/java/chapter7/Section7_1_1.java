package chapter7;

import org.junit.Test;

import javax.security.sasl.SaslServer;

/**
 * 验证new, runnable, terminated
 * @author kate
 * @create 2019/7/26
 * @since 1.0.0
 */
public class Section7_1_1 {
  class MyThread extends Thread {
    public MyThread() {
      System.out.println("构造方法中的状态 state = " + Thread.currentThread().getState());
      System.out.println("构造方法中的状态 this.state = " + this.getState());
    }
    @Override
    public void run() {
      System.out.println("run中的状态 state = " + Thread.currentThread().getState());
    }
  }

  /**
   * new
   * runnable
   * terminated
   *
   * blocked
   * waiting
   * timed_waiting
   */
  @Test
  public void test() {
    try {
      MyThread t = new MyThread();
      System.out.println("main中的t.state = " + t.getState() );
      Thread.sleep(1000);
      t.start();
      Thread.sleep(1000);
      System.out.println("main中的t.state2 = " + t.getState() );
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  class MyThread2 extends Thread {
    @Override
    public void run() {
      try {
        System.out.println("begin sleep");
        Thread.sleep(10000);
        System.out.println("end sleep");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 验证Timed_waiting
   */
  @Test
  public void test2() throws InterruptedException{
    MyThread2 t = new MyThread2();
    t.start();
    Thread.sleep(1000);
    System.out.println("main中的状态t.state = " + t.getState());
  }

  class MyService {
    synchronized public void serviceMethod() {
      try {
        System.out.println(Thread.currentThread().getName() + "进入业务方法");
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  class MyThread3 extends Thread {
    private MyService myService;

    public MyThread3(MyService myService) {
      this.myService = myService;
    }

    @Override
    public void run() {
      myService.serviceMethod();
    }
  }
  class MyThread3_2 extends Thread {
    private MyService myService;

    public MyThread3_2(MyService myService) {
      this.myService = myService;
    }
    @Override
    public void run() {
      myService.serviceMethod();
    }
  }

  // 验证blocked
  @Test
  public void test3() throws InterruptedException{
    MyService myService = new MyService();
    MyThread3 t1 = new MyThread3(myService);
    t1.setName("a");
    t1.start();
    Thread.sleep(1000);
    MyThread3_2 t2 = new MyThread3_2(myService);
    t2.setName("b");
    t2.start();
    System.out.println("main t1.state = " + t1.getState());
    System.out.println("main t2.state = " + t2.getState());

  }

  // 验证waiting，
  static class MyLock {
    public static final Byte lock = new Byte("0");
  }
  class MyThread4 extends Thread {
    @Override
    public void run() {
      try {
        synchronized (MyLock.lock){
          MyLock.lock.wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void test4 () {
    try {
      MyThread4 t = new MyThread4();
      t.start();
      Thread.sleep(1000);
      System.out.println("main t.state = " + t.getState());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}