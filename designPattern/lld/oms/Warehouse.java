package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Warehouse {
    private Inventory inventory;
    private Address address;

    public void addItemToInventory(Map<Integer, Integer> prodCatIdVsCount){
        prodCatIdVsCount.entrySet().stream().forEach(entry -> {
            Optional<ProductCategory> prdCategory = inventory.getProductCategoryList().stream().filter(productCategory -> productCategory.getProductCategoryID()== entry.getKey()).findFirst();
            if(prdCategory.isPresent()){
                inventory.addProductCategory(prdCategory.get());
            }
        });
    }

    public void removeItemFromInventory(Map<Integer, Integer> prodCatIdVsCount){
        Optional<ProductCategory> productCategory = inventory.getProductCategoryList().stream().filter(prdCategory -> prodCatIdVsCount.get(prdCategory.getProductCategoryID())!=null).findFirst();
        if(productCategory.isPresent()){
            List<Product> productList=productCategory.get().getProductList().stream().skip(prodCatIdVsCount.get(productCategory.get().getProductCategoryID())).collect(Collectors.toList());
            productCategory.get().clearProduct();
            productCategory.get().addAllProduct(productList);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
