package test;

import modele.Cellule;
import modele.Dieu;
import modele.Monde;

import java.util.ArrayList;

/**
 * Classe pour l'affichage en terminal
 */
public class Afficheur {
    /**
     * Affiche un monde dans le terminal
     * @param monde Monde à afficher.
     */
    public static void afficherGrille(Monde monde){
        String ligne = "";
        for (int i = 0; i < monde.getTailleY(); i++) { //Y pour les colonnes
            System.out.println(ligne);
            ligne = "";
            for (int j = 0; j < monde.getTailleX(); j++) { //X pour les lignes
                if(monde.getGrille()[j][i].isAlive())
                    ligne=ligne.concat("X");
                else{
                    ligne=ligne.concat(".");
                }
            }
        }
    }

    /**
     * Affiche une ArrayList de cellule dans le terminal
     * @param celluleCol List qu'on souhaite afficher
     */
    public static void afficherCelluleColl(ArrayList<Cellule> celluleCol){
        for(Cellule cell : celluleCol){
            System.out.println(cell.toString());
        }
    }
}
