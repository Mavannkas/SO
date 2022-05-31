package ludwiniak.wiktor.L5;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.List;

public class Chooser_V3 extends Chooser_V2 {
    private final int minCapacity;

    public Chooser_V3(int repeats, int maxCapacity, int minCapacity) {
        super(repeats, maxCapacity);
        this.minCapacity = minCapacity;
    }

    @Override
    public CPU choose(List<CPU> cpuList) {
        CPU resultCPU = super.choose(cpuList);

        for(CPU cpu: cpuList) {
            if(cpu.getCapacity() <= minCapacity) {
                CPU innerCPU = cpuList.get(RandomNumberGenerator.getRandom(0, cpuList.size()));
                if(innerCPU.getCapacity() > 0) {
                    cpu.addProcess(innerCPU.cutProcess());
                }
            }
        }

        return resultCPU;
    }
}
