package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;

import java.util.Set;

public class FCFS extends Alghorithm{
    public FCFS(Set<Process> processes) {
        super(processes);
    }

    @Override
    public int execute() {
        for (Process process : processes) {
            syncClock(process.getStart());
            clock += process.getRemainingDuration();
            process.setRemainingDuration(0);
            process.setEnd(clock);
            process.setFinished(true);
        }
        return clock;
    }


}
