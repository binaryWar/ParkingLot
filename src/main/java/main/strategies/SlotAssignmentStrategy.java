package main.strategies;

import main.models.Gate;
import main.models.ParkingLot;
import main.models.ParkingSlot;
import main.models.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
