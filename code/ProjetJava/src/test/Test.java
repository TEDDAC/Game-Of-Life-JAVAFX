package test;


import modele.*;
import test.Afficheur;

import java.awt.*;
import java.util.Arrays;
import java.lang.Thread;

import java.util.ArrayList;

public class Test {

    /**
     * Fonction servant pour tester le model dans le terminal
     * @deprecated Le code n'est pas à jour et utilise d'anciennes fonctions qui n'existe plus.
     */
    public static void main(String[] args) {
        /*Monde monde = new Monde(10,10);
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        Arrays.fill(born, false);
        Arrays.fill(survive, false);
        born[3]=true;
        survive[2]=true;
        survive[3]=true;
        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(monde, rules);

        //glider
        dieu.faireNaitre(1,0);
        dieu.faireNaitre(2,1);
        dieu.faireNaitre(0,2);
        dieu.faireNaitre(1,2);
        dieu.faireNaitre(2,2);

        //oscillateur basique 3 cellules
        /*dieu.faireNaitre(0,1);
        dieu.faireNaitre(1,1);
        dieu.faireNaitre(2,1);*/

        //static figure
        /*dieu.faireNaitre(1,0);
        dieu.faireNaitre(2,1);
        dieu.faireNaitre(2,2);
        dieu.faireNaitre(1,3);
        dieu.faireNaitre(0,2);
        dieu.faireNaitre(0,1);
        dieu.faireNaitre(1,2);*/

        /*Afficheur.afficherCelluleColl(dieu.getMonde().getCelluleEnVie());
        Afficheur.afficherCelluleColl(dieu.getTraite());
        Afficheur.afficherGrille(dieu.getMonde());
        System.out.println("\n");

        for(int x=0;x<31;x++){
            dieu.evolution();
            //System.out.println("Cellule traite: ");
            //Afficheur.afficherCelluleColl(dieu.getTraite());
            //System.out.println("\nCellule En Vie: ");
            //Afficheur.afficherCelluleColl(dieu.getMonde().getCelluleEnVie());
            dieu.updateCells();
            Afficheur.afficherGrille(dieu.getMonde());
            try {
                Thread.sleep(500);
            } catch(Exception e){

            }
        }*/


    }
}
