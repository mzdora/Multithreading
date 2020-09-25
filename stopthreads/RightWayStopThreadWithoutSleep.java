package stopthreads;

/***
 * Run方法内没有sleep或wait方法时,停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
        int num = 0;
        while(!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE){
            if(num%10000==0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("都是主人给的任务罢了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RightWayStopThreadWithoutSleep());
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}