package ludwiniak.wiktor.L4.Algorithms;

import ludwiniak.wiktor.L4.Process;

import java.util.ArrayList;

public class ControlErrorCount extends AlgorithmStrategy{
    public static final double MAX_ERROR_PERCENTAGE = 0.7;
    public static final double MIN_ERROR_PERCENTAGE = 0.2;



    public double execute(ArrayList<Process> processes, int totalFramesCount) {
        int processesCount = processes.size();

        int maxErrorCount = Integer.MIN_VALUE;
        int minErrorCount = Integer.MAX_VALUE;

        int maxErrorIndex = 0;
        int minErrorIndex = 0;

        int totalErrorCount = 0;

        int maxErrors = (int) (MAX_ERROR_PERCENTAGE * processes.get(0).calls.size());
        int framesPerProcess = totalFramesCount / processes.size();

        ArrayList<Integer> framesCounts = new ArrayList<>();
        fillList(framesCounts, framesPerProcess, processes.size());
        while(true) {
                for(int i = 0; i< processes.size(); i++) {
                    Process process = processes.get(i);
                    int localErrorCount = executeLRU(process.calls, framesCounts.get(i));
                    if (localErrorCount < minErrorCount) {
                       minErrorCount = localErrorCount;
                       minErrorIndex = i;
                    }

                    if(localErrorCount > maxErrorCount) {
                        maxErrorCount = localErrorCount;
                        maxErrorIndex = i;
                    }
                    process.setErrors(localErrorCount);
                }
                if(maxErrorCount >= maxErrors) {
                    int freeFrames = framesCounts.get(minErrorIndex);
                    totalErrorCount += processes.get(minErrorIndex).getErrors();

                    framesCounts.set(maxErrorIndex, framesCounts.get(maxErrorIndex) + freeFrames);
                    framesCounts.remove(minErrorIndex);
                    processes.remove(minErrorIndex);

                    maxErrorCount = Integer.MIN_VALUE;
                    minErrorCount = Integer.MAX_VALUE;
                } else {
                    break;
                }
        }

        for(Process process : processes) {
            totalErrorCount += process.getErrors();
        }
        return totalErrorCount / (double) processesCount;
    }

    private void fillList(ArrayList<Integer> framesCounts, int framesPerProcess, int size) {
        for(int i = 0; i< size; i++) {
            framesCounts.add(framesPerProcess);
        }
    }
}

