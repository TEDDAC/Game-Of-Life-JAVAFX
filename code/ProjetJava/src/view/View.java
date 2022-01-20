package view;

import Stub.Stub;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.ResourceBundle;
import modele.*;

import java.net.URL;

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
    public Spinner<Integer> hauteurSpinner;
    @FXML
    public Spinner<Integer> largeurSpinner;
    @FXML
    public ListView<String> TypeDeMonde;
    @FXML
    public ComboBox<String> presetsRules;

    private HashMap<String,Rules> regles;
    private Stub stub;


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
        createGrid(plateau);

        sliderTime.valueProperty().bindBidirectional(BoucleDeJeu.timeProperty());

        stub =new Stub();
        HashMap<String,Cellule[][]> motifs = stub.Config();
        TypeDeMonde.getItems().setAll(motifs.keySet());

        this.regles = stub.configRules();
        presetsRules.getItems().setAll(regles.keySet());


        hauteurSpinner.valueProperty().addListener((caller,oldValue,newValue) ->{
            Dieu.monde.generer();
            createGrid(plateau);
        });
        Dieu.monde.tailleYProperty().bind(hauteurSpinner.valueProperty());


        largeurSpinner.valueProperty().addListener((caller,oldValue,newValue) ->{
            Dieu.monde.generer();
            createGrid(plateau);
        });
        Dieu.monde.tailleXProperty().bind(largeurSpinner.valueProperty());
    }

    public void switchRules(){
        Dieu.rules.switchRulesTo(this.regles.get(presetsRules.getValue()));
    }

    public void switchMonde(){
        /*largeurSpinner.getValueFactory().setValue(30);
        hauteurSpinner.getValueFactory().setValue(30);*/
        try{
            HashMap<String,Cellule[][]> motifs = stub.Config();

            int index =TypeDeMonde.getSelectionModel().getSelectedIndex();
            switch (index) {
                case 1 -> Dieu.instance.getMonde().setGrille(motifs.get("Récursif"));
                case 2 -> Dieu.instance.getMonde().setGrille(motifs.get("Glider"));
                case 3 -> Dieu.instance.getMonde().setGrille(motifs.get("Base"));
                case 0 -> Dieu.instance.getMonde().setGrille(motifs.get("Achim Flammenkamp"));
            }
            createGrid(plateau);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Taille de la grille");
            alert.setContentText("La grille est trop petite pour accueillir ce motifs !");
            alert.showAndWait();
        }
    }

    public void switchPlay(){
        if(BoucleDeJeu.getPlayed()) {
            playPauseButton.setText("Play");
        } else
            playPauseButton.setText("Pause");
        BoucleDeJeu.setPlayed(!BoucleDeJeu.getPlayed());
    }

    public void createGrid(GridPane plateau){
        plateau.getChildren().clear();
        CheckBox box;
        for (int i=0;i<Dieu.monde.getTailleX();i++){
            for (int j=0;j<Dieu.monde.getTailleY();j++){
                box = new CheckBox();
                box.selectedProperty().bindBidirectional(Dieu.monde.getGrille()[i][j].aliveProperty());
                plateau.add(box,i,j);
            }
        }
    }

    public void clearGrid(){
        Dieu.clearGrid();
    }
}
