package ludwiniak.wiktor.hdd;

import ludwiniak.wiktor.hdd.algorithms.C_SCAN;
import ludwiniak.wiktor.hdd.algorithms.FCFS;
import ludwiniak.wiktor.hdd.algorithms.SCAN;
import ludwiniak.wiktor.hdd.algorithms.SSTF;
import ludwiniak.wiktor.hdd.utils.Call;
import ludwiniak.wiktor.hdd.utils.CallGenerator;

import java.util.*;

public class Main {
    private static int START_POSITION = 0;
    private static int MAX_POSITION = 100;
    public static void main(String[] args) {
        CallGenerator callGenerator = new CallGenerator(0, MAX_POSITION);
        List<Call> calls = callGenerator.generate(10);
        FCFS fcfs = new FCFS(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(fcfs.execute());
        SSTF sstf = new SSTF(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(sstf.execute());
        SCAN scan = new SCAN(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(scan.execute());
        C_SCAN c_scan = new C_SCAN(new ArrayList<>(calls), START_POSITION, MAX_POSITION);
        System.out.println(c_scan.execute());
    }
}
