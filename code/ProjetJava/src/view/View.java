package view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.*;
import test.Afficheur;

import java.awt.*;
import java.util.Arrays;

public class View {
    private GridPane mainGrid;

    public void charger (){
        GridPane plateau = new GridPane();
        System.out.println(this);
        plateau.setVgap(10);
        plateau.setHgap(10);

    }
}
