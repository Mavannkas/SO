package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.List;

public class EDF extends CallAlgorithm{

    public EDF(List<Call> calls, int position, int max) {
        super(calls, position, max);
    }

    @Override
    public int execute() {
        sortCallsByDeadline();
        for(Call call : calls) {
            processPosition(call);
        }
        return distance;
    }

    private void sortCallsByDeadline() {
        calls.sort(new SortByDeadline());
    }
}
