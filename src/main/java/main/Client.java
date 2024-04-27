package main;

import main.controllers.TokenController;
import main.repositories.GateRepository;
import main.repositories.ParkingLotRepository;
import main.repositories.TokenRepository;
import main.repositories.VehicleRepository;
import main.services.TokenService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TokenRepository tokenRepository = new TokenRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TokenService tokenService = new TokenService(gateRepository,vehicleRepository,parkingLotRepository,tokenRepository);
        TokenController tokenController = new TokenController(tokenService);
    }
}
