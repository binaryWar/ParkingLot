package main.services;

import main.models.*;
import main.repositories.GateRepository;
import main.repositories.ParkingLotRepository;
import main.repositories.TokenRepository;
import main.repositories.VehicleRepository;
import main.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepository tokenRepository;
    public TokenService(GateRepository gateRepository, VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository

    , TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }
    public Token issueToken(
            Long gateId,
            String vehicleNumber,
            String ownername,
            VehicleType vehicleType
    ){
        // create token
        Token token = new Token();
        token.setEntryTime(new Date());
        Optional<Gate> gateOptional =  this.gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new RuntimeException("Invalid! gate does not exist");
        }
        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getOperator());
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownername);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(vehicle);
        }else{
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        ParkingSlot parkingSlot = SlotAssignmentStrategyFactory.
                getSlotAssignmentStrategyByType(parkingLot.getSlotAssignmentStrategyType())
                .getSlot(parkingLot,vehicleType);
        token.setAssignedSlot(parkingSlot);
        parkingSlot.setSlotStatus(SlotStatus.FILLED);
        Token savedToken = tokenRepository.save(token);
        savedToken.setNumber(savedToken.getId() + "-TOKEN");
        return savedToken;
    }
}
