package view;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ResourceBundle;
import modele.*;
import test.Afficheur;

import java.awt.*;
import java.net.URL;
import java.util.Arrays;

public class View implements Initializable {
    public GridPane plateau;
    public HBox surviveHbox;
    public HBox bornHbox;

    @Override
    public void initialize (URL location, ResourceBundle resources){
        ObservableList<Node> bornChildren = bornHbox.getChildren();
        ObservableList<Node> surviveChildren = surviveHbox.getChildren();
        CheckBox box;
        for(int i=0;i<9;i++){
            box = new CheckBox(String.valueOf(i));
            box.selectedProperty().bindBidirectional(Dieu.rules.bornRulesProperty(i));
            bornChildren.add(box);

            box = new CheckBox(String.valueOf(i));
            box.selectedProperty().bindBidirectional(Dieu.rules.surviveRulesProperty(i));
            surviveChildren.add(box);
        }
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                plateau.add(new CheckBox(),i,j);
            }
        }
    }
}
