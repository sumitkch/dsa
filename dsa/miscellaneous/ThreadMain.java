package dsa.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadMain {
    static String a[], b;
    static String[] c,d;
    public static int balancedSum(List<Integer> arr) {
        // Write your code here
        for (int i = 1; i <= arr.size(); i++) {
            int leftSum = arr.subList(0, i)
                    .stream()
                    .mapToInt(x -> x)
                    .sum();
            int rightSum = arr.subList(i + 1, arr.size())
                    .stream()
                    .mapToInt(x -> x)
                    .sum();

            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println("a "+a);
        System.out.println("b "+b);
        System.out.println("c "+c);
        System.out.println("d "+d);

        AtomicInteger count = new AtomicInteger(1);
        /*Next10Count next = new Next10Count("Next10",count);
        Before10Count before = new Before10Count("Before10", count);
        Thread t1=new Thread(next);
        Thread t2=new Thread(before);
        t1.start();
        t2.start();*/
        /*EvenOdd evenOdd=new EvenOdd(count);
        Runnable runnable = () -> {
            try {
                while(count.get()<20)
                    evenOdd.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
        Runnable runnable2 = () -> {
            try {
                while (count.get()<20)
                evenOdd.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
        new Thread(runnable).start();
        new Thread(runnable2).start();*/
        System.out.println(balancedSum(Arrays.asList(1,2,3,3)));
    }
}
