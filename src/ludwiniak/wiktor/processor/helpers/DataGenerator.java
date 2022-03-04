package ludwiniak.wiktor.processor.helpers;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DataGenerator {
    private final int processesCount;

    private final int minProcessDuration;
    private final int maxProcessDuration;

    private final int minPossibleDeviation;
    private final int maxPossibleDeviation;

    private final int maxProcessStartTime;

    private final Random random = new Random();


    public DataGenerator(int processesCount, int minProcessDuration, int maxProcessDuration, int minPossibleDeviation, int maxPossibleDeviation, int maxProcessStartTime) {
        this.processesCount = processesCount;
        this.minProcessDuration = minProcessDuration;
        this.maxProcessDuration = maxProcessDuration;
        this.minPossibleDeviation = minPossibleDeviation;
        this.maxPossibleDeviation = maxPossibleDeviation;
        this.maxProcessStartTime = maxProcessStartTime;
    }

    public Set<Process> generateRandomProcesses() {
        Set<Process> processSet = new TreeSet<>();
        int min = minProcessDuration - getPercent(minProcessDuration, getRandom(minPossibleDeviation, maxPossibleDeviation));
        int max = maxProcessDuration + getPercent(maxProcessDuration, getRandom(minPossibleDeviation, maxPossibleDeviation));
        for (int i = 0; i < processesCount; i++) {
            final Process process = new Process(i, getRandom(0, maxProcessStartTime), getRandom(min, max));
            processSet.add(process);
        }
        return processSet;
    }

    private int getPercent(int number, int percent) {
        return (int) (number * (percent / 100.0));
    }

    private int getRandom(final int min, final int max) {
        return random.nextInt(max) + min;
    }
}
