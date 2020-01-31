package MyUtil;

import java.util.Scanner;

/**
 *
 * @author cstuser
 */
public class MyScanner {

    Scanner input = new Scanner(System.in);

    public int readInt() {
        while (!input.hasNextInt()) {
            String badInput = input.next();
            System.out.printf("%s\n%s", "Bad input, input not an integer",
                    "Please try again");
        }
        return input.nextInt();
    }
}
