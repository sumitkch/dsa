package designPattern.lld.parkingManagementSystem;

public enum VehicleType {
    TWO_WHEELER(2, "TWO_WHEELER", 20),
    FOUR_WHEELER(4, "FOUR_WHEELER", 40);

    private int vehicleTypeID;
    private String vehicleTypeName;
    private double charge;

     VehicleType(int vehicleTypeID, String vehicleTypeName, double charge){
        this.vehicleTypeID=vehicleTypeID;
        this.vehicleTypeName=vehicleTypeName;
        this.charge=charge;
    }

    public String getVehicleTypeName(){
         return this.vehicleTypeName;
    }

    public double getCharge(){
         return charge;
    }
}
