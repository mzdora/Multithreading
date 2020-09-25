package createthreads;

public class ExtendsStyle extends Thread{
    @Override
    public void run() {
        System.out.println("用Extends的方法创建Thread");
    }
}
