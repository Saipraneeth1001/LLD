package lld.parkinglot;

public class Car implements Vehicle {
    int space;
    public Car(int space) {
        this.space = space;
    }
    public int getSpace() {
        return this.space;
    }
}
