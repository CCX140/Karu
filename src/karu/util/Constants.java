/* Romain Guittienne alias CCX 28/01/2019*/

package karu.util;
import java.awt.Dimension;
import java.util.ArrayList;

public class Constants {

    private final Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private final int HEIGHT = (int)dimension.getHeight();
    private int WIDTH  = (int)dimension.getWidth();

    public Constants(){
    }


    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
