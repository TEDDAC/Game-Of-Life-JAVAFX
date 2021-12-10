package modele;

import java.util.ArrayList;

public class Main {
    private Jeu jeu;

    public Main(){
        jeu = new Jeu(100,100);
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }


    public void evolution(){
        Rules rules = this.jeu.getRules();
        ArrayList<Cellule> cellulesEnVie = this.jeu.getCelluleEnVie();
        ArrayList<Cellule> traite = this.jeu.getTraite();

        for (Cellule cellule : cellulesEnVie){
            if(!traite.contains(cellule)){
                cellule.evolve(rules);
                traite.add(cellule);
                if(cellule.getNextTimeStatus() == 0)
                    return;
                for (Cellule voisine : cellule.getCellulesVoisines()){
                    if(!traite.contains(voisine)){
                        voisine.evolve();
                        traite.add(voisine);
                    }
                }
            }
        }
    }

    public void updateCells(){
        for (Cellule cellule : jeu.getTraite()){
            cellule.update();
            jeu.getTraite().remove(cellule);
        }
    }
}
