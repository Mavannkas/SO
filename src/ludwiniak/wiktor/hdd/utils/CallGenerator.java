package ludwiniak.wiktor.hdd.utils;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CallGenerator {

    private final int minLocation;
    private final int maxLocation;

    public CallGenerator(int minLocation, int maxLocation) {
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
    }

    public ArrayList<Call> generate(final int count) {
        ArrayList<Call> output = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            output.add(new Call(RandomNumberGenerator.getRandom(minLocation, maxLocation)));
        }

        return output;
    }
}
