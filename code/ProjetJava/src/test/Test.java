package test;


import modele.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Monde monde = new Monde(10,10);
        boolean born[] = new boolean[9];
        boolean survive[] = new boolean[9];
        born[3]=true;
        survive[2]=true;
        survive[3]=true;
        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(monde, rules);
        dieu.faireNaitre(1,0);
        dieu.faireNaitre(2,1);
        dieu.faireNaitre(0,2);
        dieu.faireNaitre(1,2);
        dieu.faireNaitre(2,2);
        dieu.afficher();
        System.out.println("\n");
        //dieu.tuer(2,1);
        //dieu.afficher();
        for(int x=0;x<10;x++){
            dieu.evolution();
            dieu.updateCells();
            dieu.afficher();
        }
    }
}
