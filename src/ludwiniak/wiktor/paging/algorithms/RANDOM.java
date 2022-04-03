package ludwiniak.wiktor.paging.algorithms;

import ludwiniak.wiktor.paging.utils.Call;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RANDOM extends OPT {
    public RANDOM(List<Call> calls, int maxFrame) {
        super(calls, maxFrame);
    }

    @Override
    protected Call selectFrameToRemove() {
        return frames.get(new Random().nextInt(maxFrame));
    }
}
