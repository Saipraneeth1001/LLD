package lld.callcenter;

public class Supervisor extends Employee {

    public Supervisor(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.isAvailable = true;
    }

    @Override
    void receiveCall(Call call) {
        this.isAvailable = false;
        call.rank = 2;
        System.out.println("Call is being handled by employee: "+name);
    }

    public void Escalate(Call call) {

    }
}
