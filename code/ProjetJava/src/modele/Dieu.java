package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Dieu {
    public static Monde monde;
    public static Rules rules;
    private ArrayList<Cellule> traite;

    public static Dieu instance;//singleton

    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
        this.traite = new ArrayList<>();
        instance = this;
    }

    public static void clearGrid() {
        for(int x=0;x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                monde.getGrille()[x][y].setAlive(false);
            }
        }
    }

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

    public void evolveCell(Cellule cell){
        int nbVoisinesVivante = getNbvoisinesVivanteDe(cell.getX(),cell.getY());
        cell.setNextTimeStatus(0);
        if(cell.isAlive()) {
            if (rules.getSurviveRules(nbVoisinesVivante) == false){
                cell.setNextTimeStatus(-1);
            }
        }
        else { //morte
            if (rules.getBornRules(nbVoisinesVivante) == true){
                cell.setNextTimeStatus(1);
            }
        }
    }

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
