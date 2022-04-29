package ludwiniak.wiktor.processor.helpers;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    public static int getRandom(final int min, final int max) {
        return random.nextInt(max - min) + (min);
    }

}
