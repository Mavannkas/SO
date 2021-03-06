package ludwiniak.wiktor.paging.utils;

import ludwiniak.wiktor.processor.helpers.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CallGenerator {

    private final int maxPageID;

    public CallGenerator(int maxPageID) {
        this.maxPageID = maxPageID;
    }

    public List<Call> generate(final int count) {
        List<Call> output = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            if(i % 3 == 2 && i >= 5) {
                output.add(output.get(2));
                continue;
            }

            if(i % 3 == 1 && i >= 5) {
                output.add(output.get(1));
                continue;
            }

            output.add(new Call(RandomNumberGenerator.getRandom(0, maxPageID)));

        }

        return output;
    }
}
