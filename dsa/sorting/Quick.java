package dsa.sorting;

public class Quick {

    public void quick(int arr[], int low, int high){
        if(low<high){
            int partition = getPartition(arr, low, high);
            quick(arr, low, partition-1);
            quick(arr, partition+1, high);
        }
    }

    private int getPartition(int arr[], int low, int high){
        int pivot = arr[high];
        int idx = low-1;
        for(int i=low;i<=high;i++){
            if(pivot < arr[i]){
                idx++;
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[idx+1];
        arr[idx+1]=arr[high];
        arr[high]=temp;

        return idx+1;
    }
}
