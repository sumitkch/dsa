package dsa.miscellaneous;

import java.util.concurrent.atomic.AtomicInteger;

public class Before10Count implements Runnable{
    private String name;
    private AtomicInteger count;

    public Before10Count(String name, AtomicInteger count){
        this.name=name;
        this.count=count;
    }
    @Override
    public void run() {
        while(count.get()<=10){
            synchronized (this){
                while(count.get()>10){
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
