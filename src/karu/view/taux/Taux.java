package karu.view.taux;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import karu.model.Karu;
import karu.model.Runes;

import java.util.Observable;
import java.util.Observer;

import static karu.util.Constants.LABEL_NOM_RUNE_HEIGHT;
import static karu.util.Constants.LABEL_NOM_RUNE_WIDTH;

public class Taux implements Observer{

    //model
    private Karu model;

    @FXML
    private HBox hbox;

    private VBox runesSprite;
    private VBox nomRunes;
    private VBox prix;
    private VBox taux;


    public Taux(Karu model){
        this.model = model;
        this.runesSprite = new VBox();
        this.nomRunes = new VBox();
        this.prix = new VBox();
        this.taux = new VBox();
    }

    @FXML
    public void initialize() throws Exception {

        //on range les 4 Vbox dans la Hbox principal
        hbox.getChildren().addAll(runesSprite,nomRunes,prix,taux);
        Runes runes = model.getRunes();

        //Remplissage de la colone "Nom de la rune"

        //Titre colone "nom des runes"
        Label TitreNomRunes = new Label("Nom de la Rune");
        //style -> size 18px, bold, border black
        TitreNomRunes.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-border-color: black;");
        TitreNomRunes.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        this.nomRunes.getChildren().add(TitreNomRunes);

        //remplissage du tableau : colone "nom de la rune"
        runes.getListRunes().forEach((nom,poids)-> {
            Label nomRune = new Label(nom);
            //Style -> alignement center, size 14px, border black 1px
            nomRune.setStyle("-fx-alignment: center; -fx-font-size: 14px; -fx-border-color: black;");
            nomRune.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
            this.nomRunes.getChildren().add(nomRune);
        });

        //remplissage du tableau : colone "Prix" avec des textes fields
        //l'utilisateur rentre le prix de la rune correspondante
        //Titre
        Label TitrePrix = new Label("Prix de la rune");
        //style -> size 18px, bold, border black
        TitrePrix.setStyle("-fx-font-size: 18px; -fx-border-color: black; -fx-font-weight: bold; ");
        TitrePrix.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        prix.getChildren().add(TitrePrix);
        runes.getListRunes().forEach((nom,poids)-> {
            TextField field = new TextField();
            field.setStyle("-fx-faint-focus-color: red");
            field.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
            field.setOnKeyReleased(event -> {calculTaux();coloreTaux();});
            this.prix.getChildren().add(field);
        });

        //colone taux
        Label TitreTaux = new Label("Taux de la rune");
        //style -> size 18px, bold, border black
        TitreTaux.setStyle("-fx-font-size: 18px; -fx-border-color: black; -fx-font-weight: bold; ");
        TitreTaux.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        taux.getChildren().add(TitreTaux);
        runes.getListRunes().forEach((nom,poids) -> {
            Label TauxRune = new Label("null");
            TauxRune.setStyle("-fx-alignment: center; -fx-font-size: 14px; -fx-border-color: black;");
            TauxRune.setPrefSize(LABEL_NOM_RUNE_WIDTH, LABEL_NOM_RUNE_HEIGHT);
            this.taux.getChildren().add(TauxRune);
        });
    }


    public void calculTaux() {
        //regarde tous les champs de texte et calcul les taux avec les prix entrés
        for(int i = 1;i < prix.getChildren().size();i++) {
            TextField text = (TextField) prix.getChildren().get(i);
            if (!text.getText().isEmpty()) {
                int p = Integer.parseInt(text.getText());
                model.getRunes().setPrixWithIndex(i-1, p);
            }
        }
        model.getRunes().calculTaux();

        //affiche le prix
        for(int i = 1; i<taux.getChildren().size();i++){
            Label label = (Label) taux.getChildren().get(i);
            if(model.getRunes().getTauxWithIndex(i-1) != 0) {
                label.setText("" + model.getRunes().getTauxWithIndex(i - 1));
            }
        }
    }

    public void coloreTaux(){
        for(int i = 1; i<taux.getChildren().size();i++){
            Label label = (Label) taux.getChildren().get(i);
            int t = model.getRunes().getTauxWithIndex(i-1);
            if( t != 0) {
                if(t > 200){
                    label.setStyle("-fx-alignment: center; -fx-font-size: 16px; -fx-border-color: black; -fx-background-color: red;");
                }
                else if(t > 100){
                    label.setStyle("-fx-alignment: center; -fx-font-size: 15px; -fx-border-color: black; -fx-background-color: orange;");
                }
                else if(t > 0){
                    label.setStyle("-fx-alignment: center; -fx-font-size: 14px; -fx-border-color: black; -fx-background-color: yellow;");
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
