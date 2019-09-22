/* Romain Guittienne alias CCX 28/01/2019*/

package karu;

import karu.model.Karu;
import karu.model.Rune;
import karu.view.MainView;
import karu.view.toprunes.LigneTopRune;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Observer;

public class Main  {


    public static void main(String[] args) throws FileNotFoundException {
        Karu model = new Karu();
        MainView mainView = new MainView(model);
    }
}
