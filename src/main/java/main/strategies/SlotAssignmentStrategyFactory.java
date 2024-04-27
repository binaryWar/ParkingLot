package main.strategies;

import main.models.SlotAssignmentStrategyType;
import main.repositories.ParkingLotRepository;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(SlotAssignmentStrategyType type) {
        return new RandomSlotAssignmentStrategy();
    }
}
