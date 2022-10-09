package ConcurrentTest;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/7 13:00
 */
class Window1 implements Runnable{

    private int ticket = 10000;
    Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){ //加锁

                if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() +
                            ":卖票，票号为：" + ticket);

                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class Test2 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}