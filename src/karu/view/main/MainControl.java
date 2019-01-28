/* Romain Guittienne alias CCX 28/01/2019*/
package karu.view.main;

import javafx.application.Platform;

import java.util.Observable;
import java.util.Observer;

public class MainControl implements Observer{

    public MainControl(){

    }


    public void quitter(){
        Platform.exit();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
