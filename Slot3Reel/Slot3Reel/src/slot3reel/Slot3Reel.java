package slot3reel;

import MyUtil.RandomIntGenerator;

/**
 * Create a a class for the reels
 * @author Christian Paul David
 */
public class Slot3Reel {

    private String[] symbolList = {"Banana", "Apricot", "Fig", "Mandarin", "Pear",
        "Tangerine", "Melon"};
    private String[] payline = new String[3];

    /**
     * Default constructor
     */
    public void fillPayline() {
        for (int i = 0; i < payline.length; i++) {
            int position = RandomIntGenerator.generate(0, symbolList.length - 1);
            payline[i] = symbolList[position];
        }
    }
    
    public String get(int k) {
        if (k < 0 || k > payline.length) {
            throw new IllegalArgumentException("Slot3Reel:get: array index out of bounds");
        }
        return payline[k];
    }

    /**
     * 
     */
    public Slot3Reel() {
        fillPayline();
    }

    /**
     * Simulates the spinning of the reel of a casino machine
     */
    public void spin() {
        int num = MyUtil.RandomIntGenerator.generate(2, 9);
        for (int i = 1; i <= num; i++) {
            fillPayline();
            System.out.println(toString());
        }
        System.out.println("*************************************************");
        fillPayline();
        System.out.println(toString());
        System.out.println("*************************************************");

    }

    /**
     * To string method
     * @return the result of a spin
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < payline.length; i++) {
            result += "|  " + payline[i];
        }
        result += "|";
        return result;
    }

    /**
     * Getter for symbollist
     * @return The symbollist
     */
    public String[] getSymbolList() {
        return symbolList;
    }

    /**
     * setter for symbolist
     * @param symbolList
     */
    public void setSymbolList(String[] symbolList) {
        this.symbolList = symbolList;
    }

    /**
     * getter for payline
     * @return the payline
     */
    public String[] getPayline() {
        return payline;
    }

    /**
     * setter for payline
     * @param payline
     */
    public void setPayline(String[] payline) {
        this.payline = payline;
    }

}
