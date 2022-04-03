package ludwiniak.wiktor.paging.algorithms;

import ludwiniak.wiktor.paging.utils.Call;

import java.util.LinkedList;
import java.util.List;

public class LRU extends FIFO {
    private int time = 0;

    public LRU(List<Call> calls, int maxFrame) {
        super(calls, maxFrame);
    }


    @Override
    protected void executeFrame(Call call) {
        time++;
        if (!frames.contains(call)) {
            addFrame(call);
            return;
        }

        frames.get(frames.indexOf(call)).lastCall = time;
    }

    @Override
    protected void addFrame(Call call) {
        if (frames.size() == maxFrame){
            errorCount++;
            Call callToRemove = selectFrameToRemove();
            frames.remove(callToRemove);
        }

        call.lastCall = time;
        frames.addFirst(call);
    }

    private Call selectFrameToRemove() {
        Call oldestCall = frames.getFirst();
        for (Call frame : frames) {
            if (oldestCall.lastCall > frame.lastCall) {
                oldestCall = frame;
            }
        }

        return oldestCall;
    }


}
