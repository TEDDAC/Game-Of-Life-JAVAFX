package view;


import stub.Stub;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
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

        VBox vbox;
        CheckBox box;
        for(int i=0;i<9;i++){ //boucle de création des checkbox et du binding
            vbox = new VBox();
            box = new CheckBox(); //initialisation d'une nouvelle checkbox avec le texte i.
            box.selectedProperty().bindBidirectional(Dieu.rules.bornRulesProperty(i)); //binding de la checkbox avec le booléen de règle born[i]
            vbox.getChildren().add(new Text(String.valueOf(i)));
            vbox.getChildren().add(box);
            bornChildren.add(vbox); //ajout de la checkbox dans le hbox

            //pareil que précedemment mais pour les règles de survies
            vbox = new VBox();
            box = new CheckBox();
            box.selectedProperty().bindBidirectional(Dieu.rules.surviveRulesProperty(i));
            vbox.getChildren().add(new Text(String.valueOf(i)));
            vbox.getChildren().add(box);
            surviveChildren.add(vbox);
        }
        createGrid(plateau);

        sliderTime.valueProperty().bindBidirectional(BoucleDeJeu.timeProperty());

        stub = new Stub();
        this.regles = stub.configRules();
        presetsRules.getItems().setAll(regles.keySet());


        ChangeListener changeHandler = (observable, oldValue, newValue) -> {
            int sizex = Dieu.monde.getTailleX();
            int sizey = Dieu.monde.getTailleY();
            Dieu.monde.setGrille(GrilleCellFactory.createCellGrid(sizex,sizey));
            createGrid(plateau);
        };
        hauteurSpinner.valueProperty().addListener(changeHandler);
        Dieu.monde.tailleYProperty().bind(hauteurSpinner.valueProperty());


        largeurSpinner.valueProperty().addListener(changeHandler);
        Dieu.monde.tailleXProperty().bind(largeurSpinner.valueProperty());
    }

    /**
     * Permet d'appliquer un préréglage des règles, sélectionné depuis la combobox
     */
    public void switchRules(){
        Dieu.rules.switchRulesTo(this.regles.get(presetsRules.getValue()));
    }

    /**
     * Gère le pause/play du jeu
     */
    public void switchPlay(){
        if(BoucleDeJeu.getPlayed()) {
            playPauseButton.setText("Play");
        } else
            playPauseButton.setText("Pause");
        BoucleDeJeu.setPlayed(!BoucleDeJeu.getPlayed());
    }

    /**
     * Regénère le tableau et bind les nouvelles checkbox sur la grille
     * @param plateau Le tableau qu'on souhaite regénérer
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
     * Appelle clearGrid pour nettoyer la grille
     */
    public void clearGrid(){
        Dieu.clearGrid();
    }

    /**
     * Affiche une fenêtre d'explorateur de fichier pour sauvegarder un motif, et appel la fonction de sauvegarde.
     * @param actionEvent
     */
    public void save(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder un motif");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pattern Files", "*.cgl"));
        fileChooser.setInitialFileName("pattern.cgl");
        Window mainStage = plateau.getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(mainStage);
        if(selectedFile != null){
            ISaver.save(Dieu.monde,selectedFile);
        }
    }

    /**
     * Affiche une fenêtre d'explorateur de fichier pour ouvrir un fichier, et appel la fonction de chargement.
     * @param actionEvent
     */
    public void load(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger un motif");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pattern Files", "*.cgl"));
        Window mainStage = plateau.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if(selectedFile != null){
            ILoader.load(Dieu.monde,selectedFile,largeurSpinner,hauteurSpinner);
        }
    }
}
