package main.repositories;

import main.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber) {
        return Optional.empty();
    }
    public Vehicle save(Vehicle vehicle) {
        return vehicle;
    }
}
