package test;


import modele.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Monde monde= new Monde(10,10);
        monde.generer();
        monde.faireNaitre(1,0);
        monde.faireNaitre(2,1);
        monde.faireNaitre(0,2);
        monde.faireNaitre(1,2);
        monde.faireNaitre(2,2);
        monde.afficher();
        System.out.println("\n");
        monde.tuer(1,1);
        monde.afficher();
        boolean born[] = new boolean[9];
        boolean survive[] = new boolean[9];
        born[3]=true;
        survive[2]=true;
        survive[3]=true;
        Rules rules = new Rules(born,survive);

    }
}
