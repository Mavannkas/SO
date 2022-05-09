package ludwiniak.wiktor.L4;

import ludwiniak.wiktor.L4.Algorithms.AlgorithmStrategy;
import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.ArrayList;

public class PC {
    ArrayList<Process> processes = new ArrayList<>();

    public PC(int processesCount, int pagesCount, int callCount) {
        for(int i = 0; i <= processesCount; i++) {
           this.processes.add(new Process(i, RandomNumberGenerator.getRandom(3, pagesCount), callCount));
        }
    }

    public double doAlgorithm(AlgorithmStrategy algorithmStrategy, int framesCount) {
        return algorithmStrategy.execute(new ArrayList<>(processes), framesCount);
    }
}
