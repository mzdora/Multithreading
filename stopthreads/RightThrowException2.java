package stopthreads;

/***
 * 如果把try-catch放在循环里怎么办(就地恢复中断)
 */
public class RightThrowException2 implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(num<=10000 && !Thread.currentThread().isInterrupted()){
            if(num%100 == 0){
                System.out.println(num+"是100的倍数");
            }
            num++;
            check();
        }
    }

    private void check() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RightThrowException2());
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
    }
}
