package modele;

import java.util.ArrayList;
import java.util.Iterator;


public class Dieu {
    public static Monde monde;
    public static Rules rules;
    private ArrayList<Cellule> traite;

    public static Dieu instance;//singleton

    /**
     *
     * @param monde un dieu possède un monde
     * @param rules un dieu connait aussi les règles
     */
    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
        this.traite = new ArrayList<>();
        instance = this;
    }

    /**
     * permet de setter toutes les cellules à morte donc de nettoyer la grille
     */
    public static void clearGrid() {
        for(int x=0;x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                monde.getGrille()[x][y].setAlive(false);
            }
        }
    }

    /**
     * remplit traité de cellule à faire traité updateCell
     */
    public void evolution(){
        for(int x=0; x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                Cellule current = monde.getGrille()[x][y];
                if (!traite.contains(current)) {
                    evolveCell(current);
                    traite.add(current);
                }
            }
        }
    }

    /**
     *
     * Cette fonction détermine le prochain état d'une cellule en fonction du nombre de cellules voisines et des règles
     * @param cell
     */
    public void evolveCell(Cellule cell){
        int nbVoisinesVivante = getNbvoisinesVivanteDe(cell.getX(),cell.getY());
        cell.setNextTimeStatus(0);
        if(cell.isAlive()) {
            if (rules.getsurviveRules(nbVoisinesVivante) == false){
                cell.setNextTimeStatus(-1);
            }
        }
        else { //morte
            if (rules.getbornRules(nbVoisinesVivante) == true){
                cell.setNextTimeStatus(1);
            }
        }
    }

    /**
     *
     * Cette fonction va à partir d'une position d'une cellule déterminer le nombre de cellules voisine vivante qu'elle a.
     * @param i
     * @param j
     * @return nombre de cellule voisine vivante
     */
    public int getNbvoisinesVivanteDe(int i,int j){
        int cpt=0;
        for(int x=i-1;x<=i+1;x++){
            for(int y=j-1;y<=j+1;y++){
                if(x >= 0 && x < monde.getTailleX() && y >= 0 && y < monde.getTailleY()) {
                    Cellule current = monde.getGrille()[x][y];
                    if(x!=i || y!=j){
                        if (current.isAlive()) {
                            cpt = cpt + 1;
                        }
                    }
                }
            }
        }
        return cpt;
    }

    /**
     * Itere sur toutes les cellules à traiter et donne à chaque cellule sa nouvelle forme grâce à update
     * à chaque fois qu'une cellule est traité elle est donc supprimé de la liste traité
     */
    public void updateCells() {
        Iterator<Cellule> it = traite.iterator();
        Cellule cellule;
        while(it.hasNext()){
            cellule = it.next();
            cellule.update();
            it.remove();
        }
    }


    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
    public ArrayList<Cellule> getTraite() {
        return traite;
    }

    public void setTraite(ArrayList<Cellule> traite) {
        this.traite = traite;
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }


}
