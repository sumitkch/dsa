package dsa.stack;

public class Stack {
    private int[] STACK;
    private int MAX_SIZE;
    private int size;

    public Stack(int n){
        this.MAX_SIZE=n;
        this.size=-1;
        this.STACK=new int[this.MAX_SIZE];
    }

    public void push(int element){
        if(this.size == this.MAX_SIZE){
            System.out.println("STACK is FUll");
            return;
        }
         STACK[++size]=element;
    }

    public int pop(){
        if(this.size==-1){
            System.out.println("STACK is Empty");
            return -1;
        }
        int data = STACK[size];
        STACK[size]=0;
        size--;
        return data;
    }

    public void print(){
        int current = this.size;
        while(current>=0){
            int data = STACK[current];
            System.out.print(data+", ");
            current--;
        }
    }

}
