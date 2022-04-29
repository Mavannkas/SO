package ludwiniak.wiktor.L4;

import ludwiniak.wiktor.L4.Algorithms.Even;
import ludwiniak.wiktor.L4.Algorithms.Proportional;

public class Main {
    public static void main(String[] args) {
        PC pc = new PC(10, 10, 100);

        System.out.println(pc.doAlgorithm(new Proportional(), 50));
    }
}


//Każda ramka ma jakąś wielkość
//Każdy exec dzielimy na strony
//Wrzucamy kawałki do pamięci
//Przy zmianie procesu wrzucamy nową stron  ę do ramki