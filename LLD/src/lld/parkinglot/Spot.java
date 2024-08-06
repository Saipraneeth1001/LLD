package lld.parkinglot;

public class Spot {
    int space;
    boolean isAvailable;
    Vehicle vehicle;

    public Spot(int space, boolean isAvailable) {
        this.space = space;
        this.isAvailable = isAvailable;
    }
}
