package lld.parkinglot;

public class Motorcycle implements Vehicle {
    int space;
    public Motorcycle(int space) {
        this.space = space;
    }
    public int getSpace() {
        return this.space;
    }
}
