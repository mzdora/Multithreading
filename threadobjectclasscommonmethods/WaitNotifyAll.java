package threadobjectclasscommonmethods;

/***
 * 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify,notifyAll。
 * start先执行不代表线程先启动
 */
public class WaitNotifyAll implements Runnable{
    static Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"拿到锁了");
            try {
                System.out.println(Thread.currentThread().getName()+"开始等待");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    resourceA.notifyAll();
                    System.out.println("唤醒你们了哦!");
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(300);
        t3.start();
        //Thread
    }
}
