package slot3reel;

import MyUtil.MyScanner;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Christian Paul David
 */
public class SlotMachine {

    private Slot3Reel reel;
    private String name;
    private int currentBet;
    private int totalBet;
    private int totalDeposits;
    private int totalPayouts;
    private int totalSpins;

    /**
     * default constructor
     *
     * @param name name of the user
     * @param initialDeposits the initial deposit of the player
     */
    public SlotMachine(String name, int initialDeposits) {
        this.reel = new Slot3Reel();
        this.name = name;
        this.currentBet = 0;
        this.totalBet = 0;
        this.totalDeposits = initialDeposits;
        this.totalPayouts = 0;
        this.totalSpins = 0;
    }

    /**
     *
     */
    public void play() {
//        if (totalSpins == 0) {
//            intro();
//        } else {
//            System.out.println("Welcome back!");
//        }

        intro();
        int x;
        
        while (currentBet != 0) {
            validateBet();
            
        }
        finalGreetingsMessage();
    }

    /**
     * A string that gives the rules and welcomes the user
     */
    private void intro() {
        System.out.printf("%s", "Greetings Jack\nWelcome to 3-Reel Slot Machine\n"
                + "Each reels is adorned with the following 7 fruit names:\n"
                + "Apricot, Melon, Tangerine, Mandarin, Banana, Fig and Pear\n \n"
                + "There are four possible types of payout combinations:\n"
                + "1) Triple       : all 3 symboles match\n"
                + "2) Left-Double  : the left symbol matches either of the two other symobls\n"
                + "3) Right-Double : the center and the rightmost symbols match\n"
                + "4) zilch        : no matches\n \n"
                + "The rules:\n"
                + "--------------------\n"
                + "1) You will be prompted to enter a bet value.\n"
                + "   A bet value is the number of bet coins you want to bet."
                + "   If your bet value exceeds your current balance, then\n"
                + "   you'll have to deposit enought bet coins to satisfy your bets\n"
                + "2) Enter 0 for a bet to end the game"
                + "3) Get a Triple to win 3 times your bet.\n"
                + "4) get a Left-Double to win 2 times your bet.\n"
                + "5) Get a Right-Double to win 1 time your bet.\n"
                + "6) Get a zilch to lose your bet.\n \n"
                + "Let the fun begin!!!!!!!!\n"
                + "Good Luck! \n  \n");
    }

    /**
     * A string that says goodbye to the user
     */
    private void finalGreetingsMessage() {
        System.out.println("------------------------------");
        System.out.println("Slot Machine Status");
        System.out.println("------------------------------");
        System.out.printf("%-15s: %s", "Player", name);
        System.out.printf("%-15s: %d", "Current credits", credit());
        System.out.printf("%-15s: %d", "Total Deposits", totalDeposits);
        System.out.printf("%-15s: %d", "Total Payouts", totalPayouts);
        System.out.printf("%-15s: %d", "Total Bets", totalBet);
        System.out.printf("%-15s: %d", "Total Spins", totalSpins);
        System.out.printf("%-15s: %d", "Bottom line", credit());
        System.out.println("------------------------------");
    }

    /**
     * method that ask the user for a bet
     */
    private int readBet() {
        MyUtil.MyScanner console = new MyScanner();
        System.out.printf("\n%d\n%s", credit(), "How many coins do you want to bet (0 to quit)");
        currentBet = console.readInt();
        return currentBet;
    }

    /**
     * if bet exceeds credit and ask the user to give a proper bet
     *
     * @return the
     */
    private int readDeposit() {
        MyUtil.MyScanner input = new MyScanner();
        int x;

        while (currentBet <= credit()) {
            System.out.printf("Insufficient credits -> (Credits = %d) but (Bet = %d)", credit(), currentBet);
            System.out.printf("To continue playing you must deposit at least %d", currentBet - credit());
            System.out.printf("How many bet coins do you want to deposit?");
            x = input.readInt();
            totalDeposits += x;
            currentBet += x;
        }
        return currentBet;

    }

    /**
     * Calculate the credit
     *
     * @return the amount of credits
     */
    private int credit() {
        return totalDeposits + totalPayouts - totalBet;
    }

    /**
     * Determines whether the current bet is valid or not
     *
     * @return whether it is a valid bet or not
     */
    private boolean validateBet() {
        return currentBet < 0 || currentBet > credit();
    }

    /**
     * Determines whether all three strings in the payline are the same
     *
     * @return if it is a triple
     */
    private boolean isTriple() {
        return reel.get(0).equals(reel.get(1))
                && reel.get(0).equals(reel.get(2));
    }

    /**
     * Determines whether if the left and right or left and middle string are
     * the same in payline
     *
     * @return if it is a left double
     */
    private boolean isLeftDouble() {
        return (reel.get(0).equals(reel.get(1))
                && !(reel.get(0).equals(reel.get(2))))
                || (reel.get(0).equals(reel.get(2))
                && !(reel.get(0).equals(reel.get(1))));
    }

    /**
     * Determines whether if the middle and right most string are the same in
     * payline
     *
     * @return if it is a right-double
     */
    private boolean isRightDouble() {
        return (reel.get(2).equals(reel.get(1))
                && !(reel.get(0).equals(reel.get(2))));
    }

    /**
     * Determines whether if there are no string the same in payline
     *
     * @return if it is a zilch
     */
    private boolean isZilch() {
        return isLeftDouble() && isRightDouble() && isTriple();
    }

    /**
     * Method that determines the outcome
     *
     * @return the outcome of the spin
     */
    private String getSpinOutcome() {
        if (isTriple()) {
            return "Triple";
        } else if (isRightDouble()) {
            return "Right-Double";
        } else if (isLeftDouble()) {
            return "Left-Double";
        } else {
            return "Zilch";
        }
    }

    /**
     * A to string method
     *
     * @return a string
     */
    @Override
    public String toString() {
        String strOut = "";
        strOut += String.format("----------------------------------\n");
        strOut += String.format("Slot Machine Status\n");
        strOut += String.format("----------------------------------\n");
        strOut += String.format("%-15s: %s\n", "Player", name);
        strOut += String.format("%-15s: %d\n", "Current Credits", credit());
        strOut += String.format("%-15s: %d\n", "Total Deposits", totalDeposits);
        strOut += String.format("%-15s: %d\n", "Total Payouts", totalPayouts);
        strOut += String.format("%-15s: %d\n", "Total Bets", totalBet);
        strOut += String.format("%-15s: %d\n", "Total Spins", totalSpins);
        strOut += String.format("%-15s: %d\n", "Bottom Line", totalPayouts - credit());
        strOut += String.format("----------------------------------\n");
        strOut += "%s, your current status is saved.\n";
        strOut += "You may continue playing this game later.\n";
        strOut += "Have a nice day and hurry back.\n";

        return strOut;
    }

    /**
     * Determines whether the player won and give the proper rewards
     *
     * @return
     */
    private int computeSpinPayout() {
        if (isTriple()) {
            totalPayouts += (currentBet * 3);
        } else if (isLeftDouble()) {
            totalPayouts += (currentBet * 2);
        } else if (isRightDouble()) {
            totalPayouts += currentBet;
        } else {
            totalPayouts += 0;
        }
        return totalPayouts;

    }
}
