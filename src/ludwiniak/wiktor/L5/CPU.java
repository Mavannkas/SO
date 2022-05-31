package ludwiniak.wiktor.L5;


import java.util.LinkedList;
import java.util.List;

public class CPU {
    private List<Process> processes = new LinkedList<>();
    private int totalCapacity = 0;
    private int capacity = 0;
    private int asks = 0;
    private int moves = 0;

    public int getAsks() {
        return asks;
    }

    public int getCapacity() {
        asks++;
        return capacity;
    }

    public void addProcess(Process process) {
        capacity += process.getCpuUsage();
        processes.add(process);
    }

    public void sync() {
        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);
            if (process.isFinished(TickCounter.time)) {
                processes.remove(process);
                i--;
                capacity -= process.getCpuUsage();
            }
        }
        totalCapacity += capacity;
    }

    public void clear() {
        totalCapacity = 0;
        capacity = 0;
        asks = 0;
        moves = 0;
        processes = new LinkedList<>();
    }

    public double getAVGCapacity() {
        return (double) totalCapacity / TickCounter.time;
    }

    public Process cutProcess() {
        moves++;
        Process process = processes.get(0);
        processes.remove(process);
        capacity -= process.getCpuUsage();
        return process;
    }

    public int getMoves() {
        return moves;
    }
}
