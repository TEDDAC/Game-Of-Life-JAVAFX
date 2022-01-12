package view;

import javafx.fxml.Initializable;
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
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                plateau.add(new CheckBox(),i,j);
            }
        }
    }
}
