package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;
import designPattern.lld.oms.user.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public Warehouse createWarehouse(){
        Warehouse warehouse=new Warehouse();
        warehouse.setInventory(createInventory());
        return warehouse;
    }

    public Inventory createInventory(){
        Inventory inventory=new Inventory(createProductCategory());

        return inventory;
    }

    public List<ProductCategory> createProductCategory(){
        ProductCategory cat1=new ProductCategory(1, "COLD_DRINKS", createProduct1(), 10);
        ProductCategory cat2=new ProductCategory(2, "CHAPATI", createProduct2(), 30);
        return Arrays.asList(cat1,cat2);
    }

    public List<Product> createProduct1(){
        Product prd1=new Product(1, "PEPSI");
        Product prd2=new Product(2, "COKE");
        Product prd3=new Product(3, "THUMSUP");
        Product prd4=new Product(4, "DEO");
        return Arrays.asList(prd1,prd2,prd3,prd4);
    }
    public List<Product> createProduct2(){
        Product prd1=new Product(1, "CHAPATI");
        Product prd2=new Product(2, "NAAN");
        Product prd3=new Product(3, "TANDOORI");
        Product prd4=new Product(4, "LACHAA");
        return Arrays.asList(prd1,prd2,prd3,prd4);
    }

    public User createUser(){
        User user=new User();
        user.setUserName("Sumit");
        Address address=new Address();
        address.setAddress("Bangalore");
        address.setCity("Bangalore");
        address.setCountry("IN");
        address.setDistrict("Bangalore");
        address.setState("KA");
        address.setZipcode("560078");
        user.setAddress(address);

        return user;
    }
    public static void main(String[] args) {

    }


}
