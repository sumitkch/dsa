package designPattern.lld.oms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private Map<Integer, Integer> productCatIdVsCount;

    public Cart(){
        productCatIdVsCount=new HashMap<>();
    }

    public void addItem(int categoryID, int count){
        productCatIdVsCount.computeIfPresent(categoryID, (key, value)->value+count);
        productCatIdVsCount.putIfAbsent(categoryID, count);
    }

    public void removeItem(int categoryID, int count){
        productCatIdVsCount.computeIfPresent(categoryID, (key, value)->value-count);
        productCatIdVsCount=productCatIdVsCount.entrySet().stream().filter(entry -> entry.getKey()==categoryID && entry.getValue()<0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void viewCart(){
        productCatIdVsCount.entrySet().forEach(entry -> System.out.println("productCategoryID = "+entry.getKey()+", count = "+entry.getValue()));
    }

    public void emptyCart(){
        this.productCatIdVsCount.clear();
    }

    public Map<Integer, Integer> getProductCatIdVsCount() {
        return productCatIdVsCount;
    }
}
