package dsa.sorting;

public class Insertion {
    public void insertion(int arr[]){
        for(int i=1;i< arr.length;i++){
            int key=arr[i];
            int idx = i-1;
            while(idx>=0 && key < arr[idx]){
                arr[idx+1]=arr[idx];
            }
            arr[idx+1]=key;
        }
    }
}
