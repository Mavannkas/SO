package ludwiniak.wiktor.L5;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.*;

public class ProcessManager {
    private final int processors;
    private final int calls;

    private final Set<Process> processSet = new TreeSet<>();
    private final List<CPU> cpuList = new ArrayList<>();

    public ProcessManager(int processors, int calls) {
        this.processors = processors;
        this.calls = calls;
        init();
    }

    private void init() {
        for(int i = 0; i < calls; i++) {
            processSet.add(new Process(
                    RandomNumberGenerator.getRandom(0, calls),
                    RandomNumberGenerator.getRandom(0, processors * 15),
                    RandomNumberGenerator.getRandom(40, 60))
            );
        }

        for(int i = 0; i < processors; i++) {
            cpuList.add(new CPU());
        }
    }

    public void execute(Chooser chooser) {
        clear();

        Set<Process> newSet = new TreeSet<>(processSet);
        Iterator<Process> processIterator = newSet.iterator();
        Process process = processIterator.next();
        for(int i = 0; processIterator.hasNext(); i++) {
            syncCpu();
            while (processIterator.hasNext() && process.getStart() <= TickCounter.time) {
                CPU cpu = chooser.choose(cpuList);
                if((cpu.getCapacity() + process.getCpuUsage()) > 100) {
                    newSet.remove(process);
                    process.setStart(process.getStart() + 10);
                    newSet.add(process);
                    processIterator = newSet.iterator();
                    process = processIterator.next();
                } else {
                    cpu.addProcess(process);
                    processIterator.remove();
                    process = processIterator.next();
                }
            }
        }

        showResult();
    }

    private void showResult() {
        double avg = getAVG();

        System.out.printf("Średnie obciążenie = %.3f\n", avg);
        System.out.printf("Odchylenie standardowe = %.3f\n", getStandardDeviation(avg));
        System.out.printf("Czas= %d\n", TickCounter.time);
        for(int i = 0; i < cpuList.size(); i++) {
            System.out.printf("Proces N=%3d; ilość zapytań = %7d; ilość przeniesień = %3d; średnie obiążenie = %.3f;\n", i, cpuList.get(i).getAsks(), cpuList.get(i).getMoves(), cpuList.get(i).getAVGCapacity());
        }
    }

    private double getStandardDeviation(double avg) {
        double sum = 0;
        for(CPU cpu: cpuList) {
            sum += Math.pow(cpu.getAVGCapacity() - avg, 2);
        }

        return Math.sqrt(sum / cpuList.size());
    }

    private double getAVG() {
        double sumOfAvg = 0;
        for(CPU cpu: cpuList) {
            sumOfAvg += cpu.getAVGCapacity();
        }

        return sumOfAvg / cpuList.size();
    }

    private void syncCpu() {
        TickCounter.time++;
        for(CPU cpu: cpuList) {
            cpu.sync();
        }
    }

    private void clear() {
        TickCounter.time = 0;
        for(CPU cpu: cpuList) {
            cpu.clear();
        }
        for(Process process: processSet) {
            process.clear();
        }
    }
}
