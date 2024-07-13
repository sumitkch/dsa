package designPattern.lld.parkingManagementSystem;

import java.time.LocalDateTime;
import java.util.Date;

public class ExitPoint {
    private Ticket ticket;

    public ExitPoint(Ticket ticket){
        this.ticket=ticket;
    }

    public double generatePayment(Vehicle vehicle){
        int timeDiff = LocalDateTime.now().getSecond() - vehicle.getEntryTime().getSecond();
        if(timeDiff>1){
            return vehicle.getVehicleType().getCharge()*timeDiff;
        }
        return vehicle.getVehicleType().getCharge();
    }

    public void removeParkingSpace(Vehicle vehicle, ParkingSpace parkingSpace, ParkingSpaceMgr parkingSpaceMgr){
        parkingSpace.removeParkingSpace(vehicle, parkingSpaceMgr);
    }

    public void setExitTime(LocalDateTime exitTime){
        ticket.setExitTime(exitTime);
        ticket.getVehicle().setExitTime(exitTime);
    }
}
