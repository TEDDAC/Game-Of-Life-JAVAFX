package view;

import Stub.Stub;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.security.cert.Extension;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
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

    /**
     * Chargement et bind de nos items
     * @param location
     * @param resources
     */
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

    /**
     * Permet de modifier les règles en fonction de ce que l'utilisateur à choisi dans la combobox
     */
    public void switchRules(){
        Dieu.rules.switchRulesTo(this.regles.get(presetsRules.getValue()));
    }

    /**
     * Permet de changer la configuration du monde en fonction de ce que l'utilisateur à choisi dans la listview
     * en cas d'erreur on génére une exeception et on affiche une fenetre.
     */
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

    /**
     * Cette fonction gère le pause/play du jeu
     */
    public void switchPlay(){
        if(BoucleDeJeu.getPlayed()) {
            playPauseButton.setText("Play");
        } else
            playPauseButton.setText("Pause");
        BoucleDeJeu.setPlayed(!BoucleDeJeu.getPlayed());
    }

    /**
     * Cette fonction regénère la grille
     * @param plateau
     */
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

    /**
     * Cette fonction appelle clearGrid pour nettoyer la grille
     */
    public void clearGrid(){
        Dieu.clearGrid();
    }

    public void save(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder un motif");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pattern Files", "*.cgl"));
        Window mainStage = plateau.getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(mainStage);
        ISaver.save(Dieu.monde,selectedFile);
    }

    public void load(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger un motif");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pattern Files", "*.cgl"));
        Window mainStage = plateau.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        ILoader.load(Dieu.monde,selectedFile,largeurSpinner,hauteurSpinner);
    }
}
