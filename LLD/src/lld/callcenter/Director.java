package lld.callcenter;

public class Director extends Employee {

    public Director(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.isAvailable = true;
    }

    @Override
    void receiveCall(Call call) {
        this.isAvailable = false;
        call.rank = 1;
        System.out.println("Call is being handled by employee: "+name);
    }

    public void Escalate(Call call) {

    }
}
