package ludwiniak.wiktor.processor;

import ludwiniak.wiktor.processor.algorithms.*;
import ludwiniak.wiktor.processor.helpers.DataGenerator;
import ludwiniak.wiktor.processor.helpers.Process;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class Main {
    private static final int processesCount = 5000000;

    private static final int minProcessDuration = 20;
    private static final int maxProcessDuration = 40;

    private static final int minPossibleDeviation = 10;
    private static final int maxPossibleDeviation = 40;

    private static final int maxProcessStartTime = 10000;

    private static final DataGenerator dataGenerator = new DataGenerator(processesCount, minProcessDuration, maxProcessDuration, minPossibleDeviation, maxPossibleDeviation, maxProcessStartTime);
    private static Set<Process> processes;

    public static void main(String[] args) {
        processes = dataGenerator.generateRandomProcesses();
//        System.out.println("FCFS START");
        long startTime = System.currentTimeMillis();
//        System.out.println("AVG time for FCFS: " + doFCFS() + "ms");
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
        System.out.println("SJF START");

        startTime = System.currentTimeMillis();
        System.out.println("AVG time for SJF: " + doSJF() + "ms");
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
//
//        System.out.println("SRTF START");
//        startTime = System.currentTimeMillis();

//        System.out.println("AVG time for SRTF: " + doSRTF() + "ms");
//        stopTime = System.currentTimeMillis();
//        elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
//        System.out.println("RR START");
//        startTime = System.currentTimeMillis();
//
//        System.out.println("AVG time for small rotation time RR: " + doRRSmallRotationTime() + "ms");
//        stopTime = System.currentTimeMillis();
//        elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
//        startTime = System.currentTimeMillis();
//
//        System.out.println("AVG time for big rotation time RR: " + doRRBigRotationTime() + "ms");
//        stopTime = System.currentTimeMillis();
//        elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);

    }

    private static double doSRTF() {
        return doAlgorithm(new SRTF(processes));
    }

    private static double doRRSmallRotationTime() {
        return doAlgorithm(new RR(processes, 30));
    }

    private static double doRRBigRotationTime() {
        return doAlgorithm(new RR(processes, 1000));
    }

    private static double doFCFS() {
        return doAlgorithm(new FCFS(processes));
    }

    private static double doSJF() {
        return doAlgorithm(new SJF(processes));
    }

    private static double doAlgorithm(Alghorithm algorithm) {
        int time = algorithm.execute();
        System.out.println("END: " + time + "ms");
        double avgTime = calcAvgExecutionTime();
        resetProcesses();
        return avgTime;
    }

    private static void resetProcesses() {
        for (Process process : processes) {
            process.reset();
        }
    }

    private static double calcAvgExecutionTime() {
        int sum = 0;
        for (Process process : processes) {
            sum += process.getExecutionTime();
        }
        return sum / (double) processesCount;
    }


}
