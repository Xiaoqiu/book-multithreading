# chapter7 补充
- 线程组的使用
- 线程状态如何切换的
- SimpleDataFormat类与多线程的解决办法
- 如何对线程的异常进行处理

## 7.1 线程的状态
- 调用线程的有关方法造成线程状态改变
- 记录：Thread.State枚举类
- NEW : 至今尚未启动,未执行start方法
- RUNNABLE ：在虚拟机中执行
- BLOCKED ：手阻塞并等待某个监视器锁
- WAITING ： 无限期地等待另一个线程来执行某一特定操作，线程执行了Object.wait()后的状态
- TIMED_WAITING：指定等待时间的，等待另一个线程来执行某一特定操作, 执行了Thread.sleep()的状态。
- TERMINATED： 已经退出的



