package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class CallAlgorithm implements Executable{
    protected int position ;
    protected int max ;
    protected int distance = 0;
    protected List<Call> calls;

    public CallAlgorithm(List<Call> calls, int position, int max) {
        this.calls = calls;
        this.position = position;
        this.max = max;
    }

    protected void processPosition(Call call) {
        distance += getDifference(call);
        position = call.getLocation();
    }

    protected int getDifference(Call call) {
        return Math.abs(call.getLocation() - position);
    }

    public Call cropSelectedCall() {
        Call nearestElement = null;
        for (Call call : calls) {
            if (Objects.isNull(nearestElement) || getDifference(call) < getDifference(nearestElement)) {
                nearestElement = call;
            }
        }
        calls.remove(nearestElement);
        return nearestElement;
    }
}
