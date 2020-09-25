package startthread;

/***
 * 对比Start和run启动线程的方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        runnable.run();
        Thread th = new Thread(runnable);
        th.start();
        //th.start();
    }
}
