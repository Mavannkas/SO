package ludwiniak.wiktor.L4;

import ludwiniak.wiktor.L4.Algorithms.ControlErrorCount;
import ludwiniak.wiktor.L4.Algorithms.Even;
import ludwiniak.wiktor.L4.Algorithms.Proportional;
import ludwiniak.wiktor.L4.Algorithms.Zone;

public class Main {
    public static void main(String[] args) {
        PC pc = new PC(10, 40, 2000);

        System.out.println("Kontrola błędu");
        System.out.println(pc.doAlgorithm(new ControlErrorCount(), 30));
        System.out.println("Strefowy");
        System.out.println(pc.doAlgorithm(new Zone(), 30));
        System.out.println("Proporcjonalny");
        System.out.println(pc.doAlgorithm(new Proportional(), 30));
        System.out.println("Równy");
        System.out.println(pc.doAlgorithm(new Even(), 30));
    }
}