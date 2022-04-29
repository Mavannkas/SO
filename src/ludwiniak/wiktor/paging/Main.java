package ludwiniak.wiktor.paging;

import ludwiniak.wiktor.hdd.algorithms.Executable;
import ludwiniak.wiktor.paging.algorithms.*;
import ludwiniak.wiktor.paging.utils.Call;
import ludwiniak.wiktor.paging.utils.CallGenerator;

import java.util.List;
import java.util.Queue;

public class Main {
    public static int PAGES_COUNT = 10;
    public static int FRAMES_COUNT = 10;
    public static int CALL_COUNT = 10000;
    public static void main(String[] args) {
        CallGenerator callGenerator = new CallGenerator(PAGES_COUNT);
        List<Call> calls = callGenerator.generate(CALL_COUNT);
        Executable algorithm = new FIFO(calls, FRAMES_COUNT);
        System.out.println("FIFO:");
        System.out.println(algorithm.execute());

        algorithm = new OPT(calls, FRAMES_COUNT);
        System.out.println("OPT:");
        System.out.println(algorithm.execute());

        algorithm = new LRU(calls, FRAMES_COUNT);
        System.out.println("LRU:");
        System.out.println(algorithm.execute());

        algorithm = new ALRU(calls, FRAMES_COUNT);
        System.out.println("ALRU:");
        System.out.println(algorithm.execute());

        algorithm = new RANDOM(calls, FRAMES_COUNT);
        System.out.println("RANDOM:");
        System.out.println(algorithm.execute());
    }
}
