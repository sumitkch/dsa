package dsa.graph;

public class MaxHeap {
    private int HEAP[];
    private int size;
    private int maxSize;

    public MaxHeap(int n){
        this.maxSize=n;
        this.size=0;
        HEAP=new int[this.maxSize];
    }

    private void swap(int i, int j){
        int temp = HEAP[i];
        HEAP[i]=HEAP[j];
        HEAP[j]=temp;
    }

    private int parent(int pos){
        return (pos - 1)/2;
    }

    private int leftChild(int pos){
        return 2*pos+1;
    }

    private int rightChild(int pos){
        return 2*pos+2;
    }

    private boolean isLeaf(int pos){
        if(pos > size/2 && pos < size)
            return true;
        return false;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos))
            return;

        if(pos < leftChild(pos) || pos < rightChild(pos)){
            if (HEAP[pos] <= HEAP[leftChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element){
        HEAP[size] = element;

        int current = size;
        while(HEAP[current] > HEAP[parent(current)]){
            swap(current, parent(current));
            current=parent(current);
        }
        size++;
    }

    public void print(){
        for(int i=0;i<size/2;i++){
            System.out.print("Parent child is "+HEAP[i]);
            if(leftChild(i) < size)
                System.out.print(", Left child is "+HEAP[leftChild(i)]);
            if(rightChild(i) < size)
                System.out.print(", Right child is "+HEAP[rightChild(i)]);
            System.out.println();
        }
    }

    public int extractMax(){
        int popped = HEAP[0];
        HEAP[0]=HEAP[--size];
        maxHeapify(0);
        return popped;
    }
}
