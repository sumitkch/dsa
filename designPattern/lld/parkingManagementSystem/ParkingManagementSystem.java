package designPattern.lld.parkingManagementSystem;

import java.time.LocalDateTime;
import java.util.Random;

public class ParkingManagementSystem {

    public static void main(String[] args) throws InterruptedException {
        Random ps_count=new Random(0);
        Random ps_no=new Random(1000);
        ParkingSpaceMgr mgr = new ParkingSpaceMgr(1000, 400);
        Vehicle v1=new Vehicle(VehicleType.TWO_WHEELER);
        ParkingSpace ps1=new ParkingSpace(ps_count.nextInt(), ps_no.nextInt());
        Ticket t1 = entryPint(mgr, ps1, v1);
        Thread.sleep(5000);
        Vehicle v2=new Vehicle(VehicleType.TWO_WHEELER);
        ParkingSpace ps2=new ParkingSpace(ps_count.nextInt(), ps_no.nextInt());
        Ticket t2 = entryPint(mgr, ps2, v2);
        Thread.sleep(5000);
        System.out.println("Total space available : "+mgr.getTotalSpaceRemaining());
        Vehicle v3=new Vehicle(VehicleType.FOUR_WHEELER);
        ParkingSpace ps3=new ParkingSpace(ps_count.nextInt(), ps_no.nextInt());
        Ticket t3 = entryPint(mgr, ps3, v3);
        Thread.sleep(5000);
        exitTime(mgr, ps1, v1, t1);
        exitTime(mgr, ps2, v2, t2);
        exitTime(mgr, ps2, v2, t2);
    }

    public static Ticket entryPint(ParkingSpaceMgr mgr, ParkingSpace ps, Vehicle v){
        EntryPoint entryPoint = new EntryPoint(v, ps);
        entryPoint.assignParkingspace(mgr);
        return entryPoint.generateTicket();
    }
    public static void exitTime(ParkingSpaceMgr mgr, ParkingSpace ps, Vehicle v, Ticket t){
        ExitPoint exitPoint=new ExitPoint(t);
        double totalAmount=exitPoint.generatePayment(v);
        t.setPaidAmount(totalAmount);
        if(t.hasPaymentDone()){
            exitPoint.removeParkingSpace(v, ps, mgr);
            exitPoint.setExitTime(LocalDateTime.now());
        }
    }
}
