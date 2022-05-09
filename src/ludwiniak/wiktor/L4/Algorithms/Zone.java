package ludwiniak.wiktor.L4.Algorithms;

import ludwiniak.wiktor.L4.Process;
import ludwiniak.wiktor.paging.utils.Call;

import java.util.ArrayList;
import java.util.HashSet;

public class Zone extends AlgorithmStrategy{
    public static final int ZONE_SIZE = 30;
    public double execute(ArrayList<Process> processes, int totalFramesCount) {
        int processesCount = processes.size();
        int freeFrames = totalFramesCount;

        ArrayList<Integer> framesCounts = new ArrayList<>();

        fillList(framesCounts, processes);

        int totalError = 0;
        while (processes.size() != 0) {
            for(int i = 0; i < processes.size(); i++) {
                if(freeFrames >= framesCounts.get(i)) {
                    freeFrames -= framesCounts.get(i);

                    totalError += executeLRU(processes.get(i).calls, framesCounts.get(i));

                    framesCounts.remove(i);
                    processes.remove(i);
                    i--;
                }
            }
            freeFrames = totalFramesCount;
        }

        return totalError / (double)processesCount;
    }

    private void fillList(ArrayList<Integer> framesCounts, ArrayList<Process> processes) {
        for (Process process : processes) {
            framesCounts.add(new HashSet<>(process.calls.subList(0, ZONE_SIZE)).size());
        }
    }

}
