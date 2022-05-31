package ludwiniak.wiktor.L5;

public class Process implements Comparable<Process>{
    private int start;
    private final int duration;
    private final int cpuUsage;
    private int fstart;

    public Process(int start, int duration, int cpuUsage) {
        this.start = start;
        fstart = start;
        this.duration = duration;
        this.cpuUsage = cpuUsage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isFinished(int time) {
        return time >= start + duration;
    }

    public int getCpuUsage() {
        return cpuUsage;
    }

    @Override
    public int compareTo(Process o) {
        return start - o.start;
    }

    public void clear() {
        this.start = fstart;
    }
}
