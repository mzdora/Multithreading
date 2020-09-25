package startthread;

public class CantStartTwice {

    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
        th.start();
        th.start(); //会抛出异常,在start最开始会检查state是否为0。
    }
}
