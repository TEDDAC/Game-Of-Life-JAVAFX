package modele;

import javafx.scene.control.Spinner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface ILoader {
    public static void load(Monde monde, File fichier, Spinner<Integer> largeur,Spinner<Integer> hauteur){
        try {
            Scanner reader = new Scanner(fichier);
            hauteur.getValueFactory().setValue(Integer.parseInt(reader.nextLine()));
            largeur.getValueFactory().setValue(Integer.parseInt(reader.nextLine()));
            for(int x=0;x<monde.getTailleX();x++){
                for(int y=0;y<monde.getTailleY();y++){
                    monde.getGrille()[x][y].setAlive(reader.nextLine().equals("1"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
