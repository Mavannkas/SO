package ludwiniak.wiktor.L4;

import ludwiniak.wiktor.L4.Algorithms.AlgorithmStrategy;
import ludwiniak.wiktor.paging.utils.Call;
import ludwiniak.wiktor.paging.utils.CallGenerator;

import java.util.List;

public class Process {
    public int ID;
    public List<Call> calls;
    public final int pagesCount;

    public Process(int ID, int pagesCount, int callCount) {
        this.ID = ID;
        this.pagesCount = pagesCount;
        CallGenerator callGenerator = new CallGenerator(pagesCount);
        this.calls = callGenerator.generate(callCount);
    }

}
