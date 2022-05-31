package ludwiniak.wiktor.hdd;

import ludwiniak.wiktor.hdd.algorithms.*;
import ludwiniak.wiktor.hdd.utils.Call;
import ludwiniak.wiktor.hdd.utils.CallGenerator;

import java.util.*;

public class Main {
    private static int START_POSITION = 50;
    private static int MAX_POSITION = 100;
    private static int MAX_DEADLINE = 1000;
    public static void main(String[] args) {
        CallGenerator callGenerator = new CallGenerator(0, MAX_POSITION, MAX_DEADLINE);
        List<Call> calls = callGenerator.generate(100000);
        System.out.println("FCFS");
        FCFS fcfs = new FCFS(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(fcfs.execute());
        System.out.println("SSTF");
        SSTF sstf = new SSTF(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(sstf.execute());
        System.out.println("SCAN");
        SCAN scan = new SCAN(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(scan.execute());
        System.out.println("C_SCAN");
        C_SCAN c_scan = new C_SCAN(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(c_scan.execute());
        System.out.println("EDF");
        EDF edf = new EDF(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(edf.execute());
        System.out.println("FD_SCAN");
        FD_SCAN fd_scan = new FD_SCAN(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(fd_scan.execute());
    }
}
