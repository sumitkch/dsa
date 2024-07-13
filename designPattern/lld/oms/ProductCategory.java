package designPattern.lld.oms;

import java.util.List;

public class ProductCategory {
    private int productCategoryID;
    private String productCategoryName;
    private List<Product> productList;
    private double price;

    public ProductCategory(int productCategoryID, String productCategoryName, List<Product> productList, double price) {
        this.productCategoryID = productCategoryID;
        this.productCategoryName = productCategoryName;
        this.productList = productList;
        this.price=price;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    public void clearProduct(){
        productList.clear();
    }

    public void addAllProduct(List<Product> productList){
        this.productList=productList;
    }

    public double getPrice(){
        return price;
    }

    public int getProductCategoryID() {
        return productCategoryID;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
