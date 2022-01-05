package modele;

import java.util.ArrayList;

public class BoucleDeJeu {
    private Monde monde;

    public BoucleDeJeu(){
        monde = new Monde(100,100);
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }


    /*public void evolution(){
        Rules rules = this.monde.getRules();
        ArrayList<Cellule> cellulesEnVie = this.monde.getCelluleEnVie();
        ArrayList<Cellule> traite = this.monde.getTraite();

        for (Cellule cellule : cellulesEnVie){
            if(!traite.contains(cellule)){
                cellule.evolve(rules);
                traite.add(cellule);
                if(cellule.getNextTimeStatus() == 0)
                    return;
                for (Cellule voisine : cellule.getCellulesVoisines()){
                    if(!traite.contains(voisine)){
                        voisine.evolve(rules);
                        traite.add(voisine);
                    }
                }
            }
        }
    }*/

    /*public void updateCells(){
        for (Cellule cellule : monde.getTraite()){
            cellule.update();
            monde.getTraite().remove(cellule);
        }
    }*/
}
