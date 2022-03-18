package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.List;

public class C_SCAN extends SCAN {
    public C_SCAN(List<Call> calls, int startPosition, int maxPosition) {
        super(calls, startPosition, maxPosition);
    }

    @Override
    public int execute() {
        shouldGoToRight();
        processSideCalling();

        if (goToRight) {
            distance += max - position;
            position = 0;
        } else {
            distance += position;
            position = max;
        }

        callRestOfCalls();
        return distance;
    }



}
