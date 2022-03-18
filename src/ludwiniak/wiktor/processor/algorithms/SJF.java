package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;
import ludwiniak.wiktor.processor.helpers.SortByDuration;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SJF extends Alghorithm{
    public SJF(Set<Process> processes) {
        super(processes);
    }
    Process oldest = null;
    @Override
    public int execute() {
        while (getOldestNotExecutedProcess() != null) {
            syncClock(oldest.getStart());

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
                oldest = process;
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

        for(Iterator<Process> processIterator = processes.iterator(); processIterator.hasNext() ; ) {
            Process process = processIterator.next();
            if (!process.isFinished() && process.getStart() <= clock) {
                outputProcesses.add(process);
            }
        }

        return outputProcesses;
    }
}
