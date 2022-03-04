package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;

import java.util.Set;

public class SRTF extends SJF {
    public SRTF(Set<Process> processes) {
        super(processes);
    }

    @Override
    public int execute() {
        while (getOldestNotExecutedProcess() != null) {
            syncClock(getOldestNotExecutedProcess().getStart());

            final Process chosenProcess = chooseProcess();
            chosenProcess.reduceRemainingDurationBy(1);
            if (chosenProcess.isFinished()) {
                chosenProcess.setEnd(clock);
            }
            clock++;
        }
        return clock;
    }

}
