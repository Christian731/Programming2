package MyUtil;

import java.util.Random;

/**
 *
 * @author cstuser
 */
public class RandomIntGenerator {
    private static Random rand = new Random();

    public static int generate(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        
        int x = rand.nextInt(max - min + 1) + min;
        return x;

    }

}
