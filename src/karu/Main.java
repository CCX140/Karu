/* Romain Guittienne alias CCX 28/01/2019*/

package karu;

import karu.model.Karu;
import karu.view.MainView;

import java.io.FileNotFoundException;

public class Main  {


    public static void main(String[] args) throws FileNotFoundException {
        Karu model = new Karu();
        MainView mainView = new MainView(model);
    }
}
