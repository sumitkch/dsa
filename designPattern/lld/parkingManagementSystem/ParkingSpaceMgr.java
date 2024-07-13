package designPattern.lld.parkingManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpaceMgr {
    private Map<VehicleType, List<ParkingSpace>> parkingSpaceList;
    private int totalCapacity;
    private int fourWheelerCapacity;
    private int twoWheelerCapacity;

    public ParkingSpaceMgr(int totalCapacity, int fourWheelerCapacity){
        this.totalCapacity=totalCapacity;
        this.fourWheelerCapacity=fourWheelerCapacity;
        this.twoWheelerCapacity=totalCapacity-fourWheelerCapacity;
        parkingSpaceList = new HashMap<>();
        parkingSpaceList.put(VehicleType.TWO_WHEELER, new ArrayList<>(totalCapacity-fourWheelerCapacity));
        parkingSpaceList.put(VehicleType.FOUR_WHEELER, new ArrayList<>(fourWheelerCapacity));
    }

    public Map<VehicleType, List<ParkingSpace>> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getFourWheelerCapacity() {
        return fourWheelerCapacity;
    }

    public int getTwoWheelerCapacity() {
        return twoWheelerCapacity;
    }

    public void assignParkingSpace(VehicleType vehicleType,ParkingSpace parkingSpace){
        parkingSpaceList.get(vehicleType).add(parkingSpace);
        if(VehicleType.TWO_WHEELER==vehicleType)
            twoWheelerCapacity--;
        else
            fourWheelerCapacity--;
    }

    public void removeParkingSpace(VehicleType vehicleType, ParkingSpace parkingSpace){
        parkingSpaceList.get(vehicleType).remove(parkingSpace);
        if(VehicleType.TWO_WHEELER==vehicleType)
            twoWheelerCapacity--;
        else
            fourWheelerCapacity--;
    }
    public int getTotalSpaceRemaining(){
        return twoWheelerCapacity+fourWheelerCapacity;
    }
}
