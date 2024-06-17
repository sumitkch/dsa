package dsa.sorting;

public class Bubble {

    public void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-j+1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
