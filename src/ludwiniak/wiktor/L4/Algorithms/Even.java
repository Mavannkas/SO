package ludwiniak.wiktor.L4.Algorithms;

import ludwiniak.wiktor.L4.Process;
import ludwiniak.wiktor.paging.algorithms.LRU;

import java.util.ArrayList;

public class Even extends AlgorithmStrategy{

    public double execute(ArrayList<Process> processes, int totalFramesCount) {
        int totalErrorCount = 0;
        int framesPerProcess = totalFramesCount / processes.size();
        for(Process process : processes) {
            int localErrorCount = executeLRU(process.calls, framesPerProcess);
            totalErrorCount += localErrorCount;
            log(process.ID, process.pagesCount, process.calls.size(), framesPerProcess, localErrorCount);
        }

        return totalErrorCount / (double) processes.size();
    }
}
