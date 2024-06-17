package dsa.sorting;

public class Selection {

    public void selection(int arr[]){
        for(int i=0;i< arr.length;i++){
            int idx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[idx] > arr[j]){
                    idx = j;
                }
            }
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }
}
