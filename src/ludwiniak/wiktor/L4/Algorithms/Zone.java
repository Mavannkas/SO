package ludwiniak.wiktor.L4.Algorithms;

import ludwiniak.wiktor.L4.Process;

import java.util.ArrayList;

public class Zone extends AlgorithmStrategy{

    public double execute(ArrayList<Process> processes, int totalFramesCount) {
        int totalErrorCount = 0;
        double framesPerPageProportion = totalFramesCount / (double)countAllPages(processes);
        for(Process process : processes) {
            int framesForProcess = (int) Math.round(framesPerPageProportion * process.pagesCount);
            int localErrorCount = executeLRU(process.calls, framesForProcess);
            totalErrorCount += localErrorCount;
            log(process.ID, process.pagesCount, process.calls.size(), framesForProcess, localErrorCount);
        }

        return totalErrorCount / (double) processes.size();
    }

}
