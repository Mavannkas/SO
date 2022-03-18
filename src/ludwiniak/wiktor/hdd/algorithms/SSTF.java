package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class SSTF extends CallAlgorithm{

    public SSTF(ArrayList<Call> calls, int startPosition, int maxPosition) {
        super(calls, startPosition, maxPosition);
    }

    @Override
    public int execute() {
        while (calls.size() > 0) {
            Call call = cropSelectedCall();
            processPosition(call);
        }
        return distance;
    }

}
