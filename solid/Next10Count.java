package solid;

import java.util.concurrent.atomic.AtomicInteger;

public class Next10Count implements Runnable{
    private String name;
    private AtomicInteger count;

    public Next10Count(String name, AtomicInteger count){
        this.name=name;
        this.count=count;
    }
    @Override
    public void run() {
        while(count.get()<=20){
            synchronized (this){
                while(count.get()<10){
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread "+this.name+", count="+count.getAndIncrement());
                notify();
            }

        }
    }
}
