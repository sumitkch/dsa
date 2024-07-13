package designPattern.lld.oms;

import java.util.List;

public class Inventory {
    private List<ProductCategory> productCategoryList;

    public Inventory(List<ProductCategory> productCategoryList){
        this.productCategoryList=productCategoryList;
    }

    public void addProductCategory(ProductCategory productCategory){
        productCategoryList.add(productCategory);
    }

    public void removeProductCategory(ProductCategory productCategory){
        productCategoryList.remove(productCategory);
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }
}
