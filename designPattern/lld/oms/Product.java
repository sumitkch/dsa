package designPattern.lld.oms;

public class Product {
    private int productID;
    private String productName;

    public Product(int productID, String productName){
        this.productID=productID;
        this.productName=productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
