package threadobjectclasscommonmethods;

import java.util.LinkedList;

public class ProductorAndConsumer {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Consumer consumer = new Consumer(queue);
        Productor productor = new Productor(queue);
        new Thread(consumer).start();
        new Thread(productor).start();
    }
}

class Productor implements Runnable{
    Queue queue;
    public Productor(Queue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            queue.put();
        }
    }
}

class Consumer implements Runnable{
    Queue queue;
    public Consumer(Queue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            queue.take();
        }
    }
}

class Queue{
    private int max = 10;
    private LinkedList<String> list = new LinkedList<>();
    public synchronized void put(){
        while(list.size()==max ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("产品");
        System.out.println("生产产品咯!现在有"+list.size()+"个产品!");
        notify();
    }
    public synchronized void take() {
        while(list.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.poll();
        System.out.println("消费产品咯!现在有"+list.size()+"个产品!");
        notify();
    }
}
