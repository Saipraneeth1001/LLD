package lld.parkinglot;

import java.util.List;

public class Level {
    int level;
    List<Spot> parkingSpots;

    public Level(int level, List<Spot> parkingSpots) {
        this.level = level;
        this.parkingSpots = parkingSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Spot spot: parkingSpots) {
            if (spot.isAvailable && spot.space == vehicle.getSpace()) {
                spot.vehicle = vehicle;
                spot.isAvailable = false;
                return true;
            }
        }
        return false;
    }

    public void exitParking(Vehicle vehicle) {
        for (Spot spot: parkingSpots) {
            if (vehicle == spot.vehicle) {
                spot.isAvailable = true;
                spot.vehicle = null;
                System.out.println("exited successfully");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Motorcycle(1);
        Spot spot = new Spot(1, true);
        List<Spot> list = List.of(spot);
        Level l1 = new Level(1, list);
        l1.parkVehicle(vehicle);
    }
}
