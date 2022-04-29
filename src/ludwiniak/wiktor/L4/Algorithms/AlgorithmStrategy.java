package ludwiniak.wiktor.L4.Algorithms;

import ludwiniak.wiktor.L4.Process;
import ludwiniak.wiktor.paging.algorithms.LRU;
import ludwiniak.wiktor.paging.utils.Call;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmStrategy {
    public abstract double execute(ArrayList<Process> calls, int totalFramesCount);

    void log(int id, int pagesCount, int callsCount, int framesCount,int errorCount) {
        System.out.printf("Proces ID=%3d PAGES=%4d CALLS=%5d FRAMES=%3d ERRORS=%5d\n", id, pagesCount, callsCount, framesCount, errorCount);
    }

    int executeLRU(List<Call> calls, int framesPerProcess) {
        LRU lru = new LRU(calls, framesPerProcess);
        return lru.execute();
    }


    int countAllPages(ArrayList<Process> processes) {
        int count = 0;
        for(Process process: processes) {
            count += process.pagesCount;
        }

        return count;
    }
}
