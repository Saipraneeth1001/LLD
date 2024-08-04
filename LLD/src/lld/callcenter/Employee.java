package lld.callcenter;

public class Employee {
    String empId;
    String name;
    int rank;
    boolean isAvailable;
    CallManager callManager;
    void receiveCall(Call call) {
        this.isAvailable = false;
        System.out.println("call received by: "+name);
    }


}
