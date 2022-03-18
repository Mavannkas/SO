package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FCFS extends CallAlgorithm{

    public FCFS(ArrayList<Call> calls, int startPosition, int maxPosition) {
        super(calls, startPosition, maxPosition);

    }

    @Override
    public int execute() {
        for(Call call : calls) {
            processPosition(call);
        }
        return distance;
    }
}
