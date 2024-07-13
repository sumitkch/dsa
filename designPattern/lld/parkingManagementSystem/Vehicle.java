package designPattern.lld.parkingManagementSystem;

import java.time.LocalDateTime;
import java.util.Random;

public class Vehicle {
    private int vehicleID;
    private VehicleType vehicleType;
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Ticket ticket;

    public Vehicle(VehicleType vehicleType){
        vehicleID=new Random(0).nextInt();
        this.vehicleType=vehicleType;
        this.entryTime=LocalDateTime.now();
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setExitTime(LocalDateTime exitTime){
        this.exitTime=exitTime;
    }

    public LocalDateTime getExitTime(){
        return this.exitTime;
    }

    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    }

    public Ticket getTicket(){
        return this.ticket;
    }
}
