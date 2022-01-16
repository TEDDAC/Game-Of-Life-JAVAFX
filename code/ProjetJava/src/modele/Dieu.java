package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Dieu {
    public static Monde monde;
    public static Rules rules;
    private ArrayList<Cellule> traite;


    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
        this.traite = new ArrayList<>();
    }

    public void faireNaitre(int x,int y){
        Cellule cell = monde.getGrille()[x][y];
        cell.setAlive(true);
        monde.getCelluleEnVie().add(cell); //celluleEnVie, pas traité, traité ne sert que pour l'évolution et l'updateCells
    }

    public void tuer(int x,int y){
        Cellule cell = monde.getGrille()[x][y];
        cell.setAlive(false);
        monde.getCelluleEnVie().remove(cell);
    }

    public void evolution(){
        int cellX;
        int cellY;
        ArrayList<Cellule> celluleEnVie = monde.getCelluleEnVie();

        for (Cellule cell : celluleEnVie)
        {
            cellX=cell.getX(); //coordonnée de la cellule de départ de la boucle
            cellY=cell.getY();

            for(int x=cellX-1;x<=cellX+1;x++){
                for(int y=cellY-1;y<=cellY+1;y++){
                    if(x >= 0 && x < monde.getTailleX() && y >= 0 && y < monde.getTailleY()){
                        Cellule current = monde.getGrille()[x][y];
                        if (!traite.contains(current)) {
                            evolveCell(current);
                            traite.add(current);
                        }
                    }
                }
            }
        }
    }

    public void evolveCell(Cellule cell){
        //boolean[] bornRules = rules.getBornRules();
        //boolean[] surviveRules = rules.getSurviveRules();
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
            if(cellule.getNextTimeStatus() == 1){
                monde.getCelluleEnVie().add(cellule);
            }
            if(cellule.getNextTimeStatus() == -1){
                monde.getCelluleEnVie().remove(cellule);
            }
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
