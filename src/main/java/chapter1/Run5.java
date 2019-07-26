package chapter1;

/**
 * 1.3 currentThread()方法
 * @author kate
 * @create 2019/6/4
 * @since 1.0.0
 */
public class Run5 {
  public static void main(String[] args){
    System.out.println(Thread.currentThread().getName());
    MyThread5 myThread5 = new MyThread5();
    // 调用start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行。
    // myThread5.start();
    myThread5.run();

  }
}

class MyThread5 extends Thread {
  public MyThread5() {
    System.out.println("构造方法的打印： " + Thread.currentThread().getName());
  }

  @Override
  public void run() {
    System.out.println("run方法的打印： " + Thread.currentThread().getName());
  }

}