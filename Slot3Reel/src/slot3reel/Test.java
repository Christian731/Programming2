/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot3reel;

/**
 *
 * @author cstuser
 */
public class Test {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SlotMachine work = new SlotMachine("turd", 0);
        work.play();
        Slot3Reel reels = new Slot3Reel();
        reels.spin();
    }
}
