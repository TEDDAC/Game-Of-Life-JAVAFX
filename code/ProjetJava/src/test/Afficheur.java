package test;

import modele.Cellule;
import modele.Dieu;
import modele.Monde;

import java.util.ArrayList;

public class Afficheur {
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

    public static void afficherCelluleColl(ArrayList<Cellule> celluleCol){
        for(Cellule cell : celluleCol){
            System.out.println(cell.toString());
        }
    }
}
