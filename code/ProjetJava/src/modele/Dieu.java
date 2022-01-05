package modele;

import java.util.ArrayList;

public class Dieu {
    private Monde monde;
    private Rules rules;

    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
    }

    public void evolve(){
        ArrayList<Cellule> celluleEnVie = monde.getCelluleEnVie();
    }

    public void faireNaitre(int x,int y){
        Cellule cell = monde.getGrille()[y][x];
        cell.setAlive(true);
        monde.getCelluleEnVie().add(cell); //celluleEnVie, pas traité, traité ne sert que pour l'évolution et l'updateCells
    }

    public void tuer(int x,int y){
        Cellule cell = monde.getGrille()[y][x];
        cell.setAlive(false);
        monde.getCelluleEnVie().remove(cell);
    }

    public void afficher(){
        String ligne = "";
        for (int i = 0; i < monde.getTailleY(); i++) { //Y pour les colonnes
            System.out.println(ligne);

            ligne = "";
            for (int j = 0; j < monde.getTailleX(); j++) { //X pour les lignes

                if(monde.getGrille()[i][j].isAlive())
                    ligne=ligne.concat("X");
                else{
                    ligne=ligne.concat("#");
                }
            }
        }
    }
    

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
}
