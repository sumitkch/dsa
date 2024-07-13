package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;

import java.util.List;

public class WarehouseController {
    private List<Warehouse> warehouseList;
    private WarehouseSelectionStrategy strategy;

    public WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy strategy){
        this.warehouseList=warehouseList;
    }

    public Warehouse getWareHouseFromStrategy(Address address){
        return strategy.selectWarehouse(warehouseList, address);
    }
}
