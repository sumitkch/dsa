import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {
    private AtomicInteger count;
    public EvenOdd(AtomicInteger count){
        this.count=count;
    }
    public void even() throws InterruptedException {
        while(count.get()%2==0){
            synchronized (this){
                while(count.get()%2!=0){
                    wait(1000);
                }
                System.out.println("EVEN, Count="+count.getAndIncrement());
                notifyAll();
            }

        }
    }

    public void odd() throws InterruptedException {
        while(count.get()%2!=0){
            synchronized (this){
                while(count.get()%2==0){
                    wait(1000);
                }
                System.out.println("ODD, Count="+count.getAndIncrement());
                notifyAll();
            }

        }
    }
}
