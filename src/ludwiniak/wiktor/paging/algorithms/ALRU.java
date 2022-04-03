package ludwiniak.wiktor.paging.algorithms;

import ludwiniak.wiktor.paging.utils.Call;

import java.util.List;

public class ALRU extends FIFO {
    public ALRU(List<Call> calls, int maxFrame) {
        super(calls, maxFrame);
    }

    @Override
    protected void executeFrame(Call call) {
        if (!frames.contains(call)) {
            addFrame(call);
            return;
        }

        frames.get(frames.indexOf(call)).lastCall = 1;
    }

    @Override
    protected void addFrame(Call call) {
        if (frames.size() == maxFrame){
            errorCount++;
            clearFrames();
        }

        call.lastCall = 1;
        frames.addFirst(call);
    }

    private void clearFrames() {
        while (frames.size() == maxFrame) {
            for (Call frame : frames) {
                if (frame.lastCall == 1) {
                    frame.lastCall = 0;
                } else {
                    frames.remove(frame);
                    return;
                }
            }
        }
    }


}
