package stopthreads;

/***
 * 带有sleep中断线程的写法
 */
public class RightWayStopThreadWithSleep implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(num<=300 && !Thread.currentThread().isInterrupted()){
            if(num%100 == 0){
                System.out.println(num+"是100的倍数");
            }
            num++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("捕捉到了sleep interrupt");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RightWayStopThreadWithSleep());
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
