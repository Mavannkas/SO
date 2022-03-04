package ludwiniak.wiktor.processor.algorithms;

import ludwiniak.wiktor.processor.helpers.Process;

import java.util.Set;

public abstract class Alghorithm {
    protected final Set<Process> processes;
    protected int clock = 0;
    public Alghorithm(Set<Process> processes) {
        this.processes = processes;
    }

    public abstract int execute();

    protected void syncClock(int start) {
        if(clock < start) {
            clock = start;
        }
    }
}
