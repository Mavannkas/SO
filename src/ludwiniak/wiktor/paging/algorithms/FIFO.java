package ludwiniak.wiktor.paging.algorithms;

import ludwiniak.wiktor.hdd.algorithms.Executable;
import ludwiniak.wiktor.paging.utils.Call;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFO implements Executable {
    protected int errorCount = 0;
    protected LinkedList<Call> frames = new LinkedList<>();
    protected int maxFrame;
    protected List<Call> calls;
    public FIFO(List<Call> calls, int maxFrame) {
        this.calls = new ArrayList<>(calls);
        this.maxFrame = maxFrame;
    }

    @Override
    public int execute() {
        while (!calls.isEmpty()) {
            Call call = calls.remove(0);
            executeFrame(call);
        }
        return errorCount;
    }

    protected void executeFrame(Call call) {
        if (!frames.contains(call)) {
            addFrame(call);
        }
    }

    protected void addFrame(Call call) {
        if (frames.size() == maxFrame){
            errorCount++;
            frames.removeLast();
        }

        frames.addFirst(call);
    }
}
