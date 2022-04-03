package ludwiniak.wiktor.paging.algorithms;

import ludwiniak.wiktor.hdd.algorithms.Executable;
import ludwiniak.wiktor.paging.utils.Call;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OPT extends FIFO {
    public OPT(List<Call> calls, int maxFrame) {
        super(calls, maxFrame);
    }


    @Override
    protected void addFrame(Call call) {
        if (frames.size() == maxFrame){
            errorCount++;
            Call callToRemove = selectFrameToRemove();
            frames.remove(callToRemove);
        }

        frames.addFirst(call);
    }

    protected Call selectFrameToRemove() {
        LinkedList<Call> callsInFrame = new LinkedList<>(frames);
        int i = 0;
        while (callsInFrame.size() != 1 && i < calls.size()) {
            callsInFrame.remove(calls.get(i));
            i++;
        }

        return callsInFrame.getLast();
    }
}
