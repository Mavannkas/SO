package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;
import ludwiniak.wiktor.processor.helpers.SortByDuration;

import java.util.Set;
import java.util.TreeSet;

public class SJF extends Alghorithm{
    public SJF(Set<Process> processes) {
        super(processes);
    }

    @Override
    public int execute() {
        while (getOldestNotExecutedProcess() != null) {
            syncClock(getOldestNotExecutedProcess().getStart());

            final Process chosenProcess = chooseProcess();
            clock += chosenProcess.getRemainingDuration();
            chosenProcess.setRemainingDuration(0);
            chosenProcess.setEnd(clock);
            chosenProcess.setFinished(true);
        }
        return clock;
    }

    protected Process getOldestNotExecutedProcess() {
        for(Process process : processes) {
            if (!process.isFinished()) {
                return process;
            }
        }
        return null;
    }

    protected Process chooseProcess() {
        return getActiveProcesses().iterator().next();
    }

    protected Set<Process> getActiveProcesses() {
        Set<Process> outputProcesses = new TreeSet<>(new SortByDuration());

        for(Process process : processes) {
            if (!process.isFinished() && process.getStart() <= clock) {
                outputProcesses.add(process);
            }
        }

        return outputProcesses;
    }
}
