package chapter1;

/**
 * @author kate
 * @create 2019/6/4
 * @since 1.0.0
 */
public class LoginServlet {
  private static String usernameRef;
  private static String passwordRef;
  synchronized public static void doPost(String username, String password) {
    try {
      usernameRef = username;
      passwordRef = password;
      if (username.equals("a")) {
        Thread.sleep(5000);
      }
      passwordRef = password;
      System.out.println("username=" + usernameRef + " password=" + passwordRef);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ALogin extends Thread {
  @Override
  public void run() {
    LoginServlet.doPost("a","aa");
  }
}

class BLogin extends Thread{
  @Override
  public void run() {
    LoginServlet.doPost("b","bb");
  }
}

class Run_1{
  public static void main(String[] args){
    ALogin a = new ALogin();
    a.start();
    BLogin b = new BLogin();
    b.start();
  }
}