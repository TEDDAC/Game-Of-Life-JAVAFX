package modele;

import javafx.scene.control.Spinner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Interface de chargement des fichier de motif
 */
public interface ILoader {

    /**
     * Charge un monde depuis un fichier
     * @param monde Contiendra le nouveau monde.
     * @param fichier Fichier à charger
     * @param largeur Largeur de la grille de cellule chargée, les spinner ne sont qu'en ReadOnly, la largeur du monde est bind sur le spinner et on vient modifier le spinner
     * @param hauteur Hauteur de la grille de cellule chargée
     */
    static void load(Monde monde, File fichier, Spinner<Integer> largeur,Spinner<Integer> hauteur){
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
