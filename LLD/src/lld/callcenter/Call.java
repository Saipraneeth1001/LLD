package lld.callcenter;

public class Call {
    String callId;
    String callerName;
    int rank;

    public Call(String name) {
        this.callerName = name;
        this.rank = 1;
    }
}
