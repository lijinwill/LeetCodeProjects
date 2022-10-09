package ConcurrentTest;

/**
 * @author Will
 * @version 1.0
 * @description: 这几个test都是java基础里面的例子
 * @date 2022/9/6 19:24
 */
public class Test1 {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    public static int ticket = 1000;
    Object obj = new Object();
    @Override
    public void run() {
        synchronized (obj){
            while(true){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }

        }
    }
}
