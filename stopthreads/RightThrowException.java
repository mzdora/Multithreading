package stopthreads;

/***
 * 如果把try-catch放在循环里怎么办(向上抛出异常)
 */
public class RightThrowException implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(num<=10000 && !Thread.currentThread().isInterrupted()){
            if(num%100 == 0){
                System.out.println(num+"是100的倍数");
            }
            num++;
            try {
                check();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    private void check() throws InterruptedException {
        Thread.sleep(10);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RightThrowException());
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
    }
}
