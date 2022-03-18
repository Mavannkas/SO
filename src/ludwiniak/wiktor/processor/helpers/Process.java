package ludwiniak.wiktor.processor.helpers;

import java.util.Objects;

public class Process implements Comparable<Process> {
    private final int ID;
    private final int start;
    private final int startDuration;
    private int remainingDuration;
    private int end = 0;
    private boolean isFinished = false;


    public Process(int ID, int start, int startDuration) {
        this.ID = ID;
        this.start = start;
        this.startDuration = startDuration;
        this.remainingDuration = startDuration;
    }

    public int getStart() {
        return start;
    }

    public int getStartDuration() {
        return startDuration;
    }

    public int getExecutionTime() {
        return end - start - startDuration;
    }

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = remainingDuration;
    }

    public void reduceRemainingDurationBy(int time) {
        this.remainingDuration -= time;
        if (remainingDuration == 0) {
            setFinished(true);
        }
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void reset() {
        end = 0;
        isFinished = false;
        remainingDuration = startDuration;
    }

    @Override
    public int compareTo(Process o) {
        return Integer.compare(start, o.start);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return ID == process.ID && start == process.start && startDuration == process.startDuration && remainingDuration == process.remainingDuration && end == process.end && isFinished == process.isFinished;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, start, startDuration, remainingDuration, end, isFinished);
    }
}
