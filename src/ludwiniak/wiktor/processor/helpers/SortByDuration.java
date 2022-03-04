package ludwiniak.wiktor.processor.helpers;

import java.util.Comparator;

public class SortByDuration implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        return Integer.compare(o1.getRemainingDuration(), o2.getRemainingDuration());
    }
}
