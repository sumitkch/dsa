package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;

import java.util.List;

public interface WarehouseSelectionStrategy {
    public Warehouse selectWarehouse(List<Warehouse> warehouseList, Address address);
}
