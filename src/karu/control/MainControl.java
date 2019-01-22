package karu.control;

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
