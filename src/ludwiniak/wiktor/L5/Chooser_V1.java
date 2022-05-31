package ludwiniak.wiktor.L5;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.List;

public class Chooser_V1 implements Chooser {
    private final int repeats;
    private final int maxCapacity;

    public Chooser_V1(int repeats, int maxCapacity) {
        this.repeats = repeats;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public CPU choose(List<CPU> cpuList) {
        for(int i = 0; i < repeats; i++) {
            CPU cpu = cpuList.get(RandomNumberGenerator.getRandom(1, cpuList.size()));
            if(cpu.getCapacity() <= maxCapacity) {
                return cpu;
            }
        }

        return cpuList.get(0);
    }
}
