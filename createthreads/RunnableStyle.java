package createthreads;

/**
 * Create by Mzdora
 * 用Runnable方法实现线程
 */
public class RunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
