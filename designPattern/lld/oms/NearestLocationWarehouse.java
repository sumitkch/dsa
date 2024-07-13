package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;

import java.util.List;

public class NearestLocationWarehouse implements WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList, Address address) {
        return warehouseList.stream().filter(warehouse -> warehouse.getAddress().equals(address)).findFirst().get();
    }
}
