package designPattern.lld.parkingManagementSystem;

public class ParkingSpace {
    private int parkingSpaceID;
    private int parkeingSpaceNo;
    private boolean isEmpty;

    public ParkingSpace(int parkingSpaceID, int parkeingSpaceNo){
        this.parkingSpaceID=parkingSpaceID;
        this.parkeingSpaceNo=parkeingSpaceNo;
        this.isEmpty=true;
    }

    public int getParkingSpaceNo() {
        return parkeingSpaceNo;
    }

    public void assignParkingSpace(Vehicle vehicle, ParkingSpaceMgr parkingSpaceMgr){
        parkingSpaceMgr.assignParkingSpace(vehicle.getVehicleType(), this);
        this.isEmpty=false;
    }

    public void removeParkingSpace(Vehicle vehicle, ParkingSpaceMgr parkingSpaceMgr){
        parkingSpaceMgr.removeParkingSpace(vehicle.getVehicleType(), this);
        this.isEmpty=true;
    }

}
