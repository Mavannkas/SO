package ludwiniak.wiktor.hdd.utils;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CallGenerator {

    private final int minLocation;
    private final int maxLocation;
    private final int maxDeadline;

    public CallGenerator(int minLocation, int maxLocation, int maxDeadline) {
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
        this.maxDeadline = maxDeadline;
    }

    public ArrayList<Call> generate(final int count) {
        ArrayList<Call> output = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            output.add(new Call(RandomNumberGenerator.getRandom(minLocation, maxLocation), RandomNumberGenerator.getRandom(0, maxDeadline)));
        }

        return output;
    }
}
