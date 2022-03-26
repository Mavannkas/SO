package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.List;

public class FD_SCAN extends CallAlgorithm {
    protected boolean goToRight = true;

    public FD_SCAN(List<Call> calls, int startPosition, int maxPosition) {
        super(calls, startPosition, maxPosition);
    }

    @Override
    public int execute() {
        sortCallsByDeadline();
        shouldGoToRight();
        processSideCalling();
        callRestOfCalls();
        return distance;
    }


    protected void processSideCalling() {
        for (int i = 0; i < calls.size(); i++) {
            Call call = calls.get(i);
            if (goToRight && call.getLocation() > position || !goToRight && call.getLocation() < position) {
                --i;
                calls.remove(call);
                processPosition(call);
            }
        }
    }

    protected void callRestOfCalls() {
        while (calls.size() > 0) {
            Call call = cropSelectedCall();
            processPosition(call);
        }

    }

    protected void shouldGoToRight() {
        goToRight = calls.get(0).getLocation() > position;
    }

    private void sortCallsByDeadline() {
        calls.sort(new SortByDeadline());
    }
}
