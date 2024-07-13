package designPattern.lld.parkingManagementSystem;

import java.time.LocalDateTime;

public class EntryPoint {

    private ParkingSpace parkingSpace;
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    public EntryPoint(Vehicle vehicle, ParkingSpace parkingSpace){
        this.vehicle=vehicle;
        this.entryTime=LocalDateTime.now();
        this.parkingSpace=parkingSpace;
    }

    public Ticket generateTicket(){
        Ticket ticket=new Ticket(1, parkingSpace.getParkingSpaceNo(), vehicle);
        return ticket;
    }

    public void assignParkingspace(ParkingSpaceMgr parkingSpaceMgr){
        parkingSpace.assignParkingSpace(vehicle, parkingSpaceMgr);
    }
}
