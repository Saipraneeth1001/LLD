package lld.parkinglot;

public class Bus implements Vehicle {
    int space;
    public Bus(int space) {
        this.space = space;
    }
    public int getSpace() {
        return this.space;
    }
}
