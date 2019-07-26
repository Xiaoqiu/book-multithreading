package chapter7;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kate
 * @create 2019/7/26
 * @since 1.0.0
 */
public class Section7_6_1 {
  class MyThread extends Thread {
    private SimpleDateFormat simpleDateFormat;
    private String dataString;

    public MyThread(SimpleDateFormat simpleDateFormat, String dataString) {
      this.simpleDateFormat = simpleDateFormat;
      this.dataString = dataString;
    }

    @Override
    public void run() {
      try {
        Date date = simpleDateFormat.parse(dataString);
        String newDateString = simpleDateFormat.format(date).toString();
        if (!newDateString.equals(dataString)) {
          System.out.println("TreadName= " + this.getName() +
              " 报错了日期字符串： " + dataString + " 转为 " + newDateString);
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void test() throws InterruptedException{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String[] dataStringArray = new String[] {
        "2000-01-01", "2000-01-02", "2000-01-03", "2000-01-11"
    };
    MyThread[] myThreads = new MyThread[4];
    for (int i = 0; i < 4; i++) {
      myThreads[i] = new MyThread(simpleDateFormat,dataStringArray[i]);
    }
    for (int i = 0; i < 4; i++) {
      myThreads[i].start();
    }

    Thread.sleep(1000);
  }

  // 优化方案1： 通过创建多个SimpleDateFormat实例
  class MyThread2 extends Thread {
    private SimpleDateFormat simpleDateFormat;
    private String dataString;

    public MyThread2(SimpleDateFormat simpleDateFormat, String dataString) {
      this.simpleDateFormat = simpleDateFormat;
      this.dataString = dataString;
    }

    @Override
    public void run() {
      try {
        Date date = DateTools.parse("yyyy-MM-dd",dataString);
        String newDateString = DateTools.format("yyyy-MM-dd",dataString);
        if (!newDateString.equals(dataString)) {
          System.out.println("TreadName= " + this.getName() +
              " 报错了日期字符串： " + dataString + " 转为 " + newDateString);
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }
  static  class DateTools {
    public static Date parse(String formatPattern, String dateString) throws ParseException{
      return new SimpleDateFormat(formatPattern).parse(dateString);
    }
    public static String format(String formatPattern, String dateString) throws ParseException{
      return new SimpleDateFormat(formatPattern).parse(dateString).toString();
    }
  }

  @Test
  public void test2() throws InterruptedException{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String[] dataStringArray = new String[] {
        "2000-01-01", "2000-01-02", "2000-01-03", "2000-01-11"
    };
    MyThread2[] myThreads = new MyThread2[4];
    for (int i = 0; i < 4; i++) {
      myThreads[i] = new MyThread2(simpleDateFormat,dataStringArray[i]);
    }
    for (int i = 0; i < 4; i++) {
      myThreads[i].start();
    }

    Thread.sleep(1000);
  }

  // 优化2 ：
  static class DateTools2 {
    private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
      SimpleDateFormat simpleDateFormat = null;
      simpleDateFormat = t1.get();
      if (simpleDateFormat == null) {
        simpleDateFormat = new SimpleDateFormat(datePattern);
        t1.set(simpleDateFormat);
      }
      return simpleDateFormat;
    }

  }
}