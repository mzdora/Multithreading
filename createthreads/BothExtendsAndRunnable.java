package createthreads;

public class BothExtendsAndRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("this is runnable");
    }
}
