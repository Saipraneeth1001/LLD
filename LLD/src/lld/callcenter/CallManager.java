package lld.callcenter;

import java.util.*;
import java.util.stream.Collectors;

public class CallManager {

    Queue<Call> queue = new LinkedList<>();
    List<Employee> availableEmployees;

    void processIncomingCall(Call call, List<Employee> availableEmployees) {
        System.out.println("call manager has received the call with caller name: "+call.callerName);
        this.availableEmployees = availableEmployees;
        List<Employee> empList = getAvailableEmployee(call);
        if (empList.size() == 0) {
            if (!queue.contains(call))
                queue.add(call);
            System.out.println("since none of the employees are available, your call is moved to call waiting");
        } else {
            Employee employee = empList.get(0);
            assignEmployeeToCall(call, employee);
            queue.poll();
        }
    }

    List<Employee> getAvailableEmployee(Call call) {
        // we should fetch employees based on their ranks
//        Comparator<Employee> comparator = (x, y) -> x.rank - y.rank;
//        Map<Integer, List<Employee>> map = availableEmployees.stream().filter(emp -> emp.isAvailable)
//                .collect(Collectors.groupingBy(emp -> emp.rank));
        List<Employee> employeeList = availableEmployees.stream()
                .filter(x -> x.isAvailable)
                .filter(x -> {
                    if (x.rank == call.rank) return true;
                    else return false;
                })
                .sorted((x, y) -> x.rank - y.rank)
                .toList();
        return employeeList;

    }

    void escalateCall(Call call, int rank) {
        List<Employee> empList = getAvailableEmployee(call).stream().filter(emp -> {
                    if (emp.rank == rank && emp.isAvailable)
                        return true;
                    else return false;
                })
                .toList();
        if (empList.size() == 0) {
            call.rank = rank;
            queue.add(call);
        } else {
            Employee emp = empList.get(0);
            call.rank = emp.rank;
            emp.receiveCall(call);
        }
    }

    void assignEmployeeToCall(Call call, Employee employee) {
        call.rank = employee.rank;
        employee.receiveCall(call);
    }

    void processCallsInQueue(Call call, List<Employee> availableEmployees) {
        queue.add(call);
        while (!queue.isEmpty()) {
            processIncomingCall(call, availableEmployees);
        }
    }
}
