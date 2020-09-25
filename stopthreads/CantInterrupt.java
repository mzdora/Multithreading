package stopthreads;

/***
 * 如果while里面放try/catch会导致中断失效
 */
public class CantInterrupt implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(num<=10000){
            if(num%100 == 0){
                System.out.println(num+"是100的倍数");
            }
            num++;
            try {
                Thread.sleep(10);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new CantInterrupt());
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
    }
}
