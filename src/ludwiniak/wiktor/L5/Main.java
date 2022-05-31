package ludwiniak.wiktor.L5;


public class Main {
    public static final int p = 80;
    public static final int r = 20;
    public static final int z = 5;
    public static final int N = 100;
    public static final int c = 20000;

    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager(N, c);
        Chooser ch1 = new Chooser_V1(z, p);
        Chooser ch2 = new Chooser_V2(z, p);
        Chooser ch3 = new Chooser_V3(z, p, r);

        System.out.println("Algorytm 1");
        processManager.execute(ch1);
        System.out.println();
        System.out.println();
        System.out.println("Algorytm 2");
        processManager.execute(ch2);
        System.out.println();
        System.out.println();
        System.out.println("Algorytm 3");
        processManager.execute(ch3);
    }
}
