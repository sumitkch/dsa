package designPattern.lld.parkingManagementSystem;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketID;
    private int spaceNo;
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private double paidAmount;

    public Ticket(int ticketID, int spaceNo, Vehicle vehicle){
        this.ticketID=ticketID;
        this.vehicle=vehicle;
        this.spaceNo=spaceNo;
        this.entryTime=vehicle.getEntryTime();
    }

    public void setExitTime(LocalDateTime exitTime){
        this.exitTime=exitTime;
    }

    public LocalDateTime getExitTime(){
        return this.exitTime;
    }

    public void setPaidAmount(double paidAmount){
        this.paidAmount=paidAmount;
    }

    public double getPaidAmount(){
        return paidAmount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean hasPaymentDone(){
        if(paidAmount>0)
            return true;

        return false;
    }
}
