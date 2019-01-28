package karu.view.taux;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.text.Element;
import javax.swing.text.TableView;
import java.util.Observable;
import java.util.Observer;

public class Taux implements Observer{

    @FXML
    private HBox hbox;

    private VBox runes;
    private VBox nomRunes;
    private VBox prix;
    private VBox taux;


    public Taux(){
        this.runes = new VBox();
        this.nomRunes = new VBox();
        this.prix = new VBox();
        this.taux = new VBox();
    }

    @FXML
    public void initialize() throws Exception {
        hbox.getChildren().addAll(runes,nomRunes,prix,taux);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
