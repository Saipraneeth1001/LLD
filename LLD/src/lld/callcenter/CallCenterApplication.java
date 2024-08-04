package lld.callcenter;

import java.util.List;

public class CallCenterApplication {

    CallManager callManager;

    List<Employee> addData() {
        List<Employee> employeeList = List.of(
                new Operator("op1", 1),
                new Operator("op2", 1),
                new Supervisor("sp1", 2),
                new Supervisor("sp2", 2),
                new Operator("op3", 1),
                new Supervisor("sp3", 2),
                new Director("d1", 3)
                );
        return employeeList;
    }

    List<Call> calls() {
        List<Call> calls = List.of(
                new Call("cl1"),
                new Call("cl2"),
                new Call("cl3"),
                new Call("cl4")
        );
        return calls;
    }

    void processCalls() {
        callManager = new CallManager();
        for (Call call: calls()) {
            callManager.processCallsInQueue(call, addData());
        }
    }

    public static void main(String []args) {
        CallCenterApplication app = new CallCenterApplication();
        app.processCalls();
    }


}
