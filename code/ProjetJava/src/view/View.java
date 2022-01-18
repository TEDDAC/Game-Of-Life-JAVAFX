package view;

import Stub.Stub;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import modele.*;
import test.Afficheur;

import java.awt.*;
import java.net.URL;
import java.util.Arrays;

public class View implements Initializable {
    @FXML
    public GridPane plateau;
    @FXML
    public HBox surviveHbox;
    @FXML
    public HBox bornHbox;
    @FXML
    public Button playPauseButton;
    @FXML
    public Slider sliderTime;
    @FXML
    public Spinner hauteurSpinner;
    @FXML
    public Spinner largeurSpinner;
    @FXML
    private ListView<String> TypeDeMonde;


    @Override
    public void initialize (URL location, ResourceBundle resources){
        //Liste des enfants des Hbox des règles
        ObservableList<Node> bornChildren = bornHbox.getChildren();
        ObservableList<Node> surviveChildren = surviveHbox.getChildren();

        CheckBox box;
        for(int i=0;i<9;i++){ //boucle de création des checkbox et du binding
            box = new CheckBox(String.valueOf(i)); //initialisation d'une nouvelle checkbox avec le texte i.
            box.selectedProperty().bindBidirectional(Dieu.rules.bornRulesProperty(i)); //binding de la checkbox avec le booléen de règle born[i]
            bornChildren.add(box); //ajout de la checkbox dans le hbox

            //pareil que précedemment mais pour les règles de survies
            box = new CheckBox(String.valueOf(i));
            box.selectedProperty().bindBidirectional(Dieu.rules.surviveRulesProperty(i));
            surviveChildren.add(box);
        }
        for (int i=0;i<Dieu.monde.getTailleX();i++){
            for (int j=0;j<Dieu.monde.getTailleY();j++){
                box = new CheckBox();
                box.selectedProperty().bindBidirectional(Dieu.monde.getGrille()[i][j].aliveProperty());
                plateau.add(box,i,j);
            }
        }

        sliderTime.valueProperty().bindBidirectional(BoucleDeJeu.timeProperty());

        Stub stub =new Stub();
        HashMap<String,Monde> Dico = stub.Config();
        TypeDeMonde.getItems().setAll(Dico.keySet());
    }
    public void switchMonde(){
        Stub stub =new Stub();
        HashMap<String,Monde> Dico = stub.Config();
        Dieu.instance.setMonde(Dico.get("Récursif"));
        CheckBox box;
        for (int i=0;i<Dieu.monde.getTailleX();i++){
            for (int j=0;j<Dieu.monde.getTailleY();j++){
                box = new CheckBox();
                box.setSelected( Dieu.monde.getGrille()[i][j].aliveProperty().getValue());
                plateau.add(box,i,j);
            }
        }
    }

    public void switchPlay(){
        if(BoucleDeJeu.getPlayed()) {
            playPauseButton.setText("Play");
        } else
            playPauseButton.setText("Pause");
        BoucleDeJeu.setPlayed(!BoucleDeJeu.getPlayed());
    }
}
