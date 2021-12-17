package modele;


import modele.Monde;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Monde monde= new Monde(10,10);
        monde.generer();
        monde.faireNaitre(1,1);
        monde.faireNaitre(5,6);
        monde.faireNaitre(6,7);
        monde.faireNaitre(4,4);
        monde.faireNaitre(2,2);
        monde.faireNaitre(8,8);
        monde.afficher();
        System.out.println("\n");
        monde.tuer(1,1);
        monde.afficher();
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        born[3]=true;
        survive[2]=true;
        Rules rules = new Rules(born,survive);

    }
}
