package solid;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //stack operation
    //7, 10, 9, 7, 3, 2
    //7,2,3,9,10,7
    public static void stackOpration(int arr[]){
        Stack<Integer> st1= new Stack<>();
        Stack<Integer> temp = new Stack<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(data -> {
            st1.push(data);
            map.computeIfPresent(data, (d, count) -> count+1 );
            map.putIfAbsent(data, 1);

        });

        while(!st1.isEmpty()){
            Integer data=st1.pop();
            Map.Entry entry=map.entrySet().stream().max((e1,e2) -> e1.getValue() - e2.getValue()).get();
            if(entry.getValue() == map.get(data) ){
                System.out.println(data+", ");
            }else{
                while(data != entry.getKey() && !st1.isEmpty()){
                    temp.push(data);
                    data = st1.pop();
                }
                System.out.println(data+", ");
                while(!temp.isEmpty())
                    st1.push(temp.pop());

            }
            if((int)entry.getValue()>1){
                map.remove(entry.getKey());
                map.putIfAbsent((Integer) entry.getKey(), (int)entry.getValue()-1);
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int arr[] = {7, 10, 9, 7, 3, 2};
        stackOpration(arr);
    }
}