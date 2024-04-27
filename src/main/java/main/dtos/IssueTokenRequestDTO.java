package main.dtos;

import main.models.VehicleType;

public class IssueTokenRequestDTO {
    private Long getId;
    private String vecihleNumber;
    private String ownerName;
    private VehicleType vehicleType;

    public Long getGetId() {
        return getId;
    }

    public void setGetId(Long getId) {
        this.getId = getId;
    }

    public String getVecihleNumber() {
        return vecihleNumber;
    }

    public void setVecihleNumber(String vecihleNumber) {
        this.vecihleNumber = vecihleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
