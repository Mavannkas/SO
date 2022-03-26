package ludwiniak.wiktor.hdd.algorithms;

import ludwiniak.wiktor.hdd.utils.Call;

import java.util.Comparator;

public class SortByDeadline implements Comparator<Call> {
    @Override
    public int compare(Call o1, Call o2) {
        return o2.getDeadline() - o1.getDeadline();
    }
}
