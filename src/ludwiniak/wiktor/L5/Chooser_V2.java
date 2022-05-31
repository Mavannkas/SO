package ludwiniak.wiktor.L5;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.List;

public class Chooser_V2 implements Chooser {
    private final int repeats;
    protected final int maxCapacity;

    public Chooser_V2(int repeats, int maxCapacity) {
        this.repeats = repeats;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public CPU choose(List<CPU> cpuList) {
        CPU mainCPU = cpuList.get(0);
        if(mainCPU.getCapacity() <= maxCapacity) {
            return mainCPU;
        }

        int i=0;
        while (true) {
            if(i++ >= 2000) {
                return mainCPU;
            }
            CPU cpu = cpuList.get(RandomNumberGenerator.getRandom(1, cpuList.size()));
            if(mainCPU.getCapacity() >= cpu.getCapacity()) {
                return cpu;
            }
        }
    }
}
