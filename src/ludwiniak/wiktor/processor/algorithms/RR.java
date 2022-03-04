package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;

import java.util.LinkedList;
import java.util.Set;

public class RR extends SJF {
    private final int timeForProcess;
    private final LinkedList<Process> subQueue;

    public RR(Set<Process> processes, int timeForProcess) {
        super(processes);
        this.timeForProcess = timeForProcess;
        this.subQueue = new LinkedList<>();
    }

    @Override
    public int execute() {
        while (getOldestNotExecutedProcess() != null) {
            syncClock(getOldestNotExecutedProcess().getStart());
            updateQueue();

            final Process chosenProcess = subQueue.pop();
            final int remainingDuration = chosenProcess.getRemainingDuration();

            if (remainingDuration > timeForProcess) {
                standardReduceProcess(chosenProcess);
            } else if (remainingDuration == timeForProcess) {
                finishProcess(chosenProcess);
            } else {
                finishOffbeatProcess(remainingDuration, chosenProcess);
            }
        }
        return clock;
    }

    private void standardReduceProcess(Process chosenProcess) {
        clock += timeForProcess;
        chosenProcess.reduceRemainingDurationBy(timeForProcess);
        subQueue.add(chosenProcess);
    }

    private void finishProcess(Process chosenProcess) {
        clock += timeForProcess;
        chosenProcess.reduceRemainingDurationBy(timeForProcess);
        chosenProcess.setEnd(clock);
    }

    private void finishOffbeatProcess(int remainingDuration, Process chosenProcess) {
        clock += remainingDuration;
        chosenProcess.setFinished(true);
        chosenProcess.setRemainingDuration(0);
        chosenProcess.setEnd(clock);
    }


    protected void updateQueue() {
        for (Process process : processes) {
            if (!process.isFinished() && process.getStart() <= clock && !subQueue.contains(process)) {
                subQueue.add(process);
            }
        }
    }

}
