package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Dieu {
    private Monde monde;
    private Rules rules;
    private ArrayList<Cellule> traite;


    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
        this.traite = new ArrayList<Cellule>();
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
    public void evolution(){
        int i;
        int j;
        int x;
        int y;
        ArrayList<Cellule> celluleEnVie = monde.getCelluleEnVie();

        for (Cellule cell : celluleEnVie)
        {
            i=cell.getX();
            j=cell.getY();
            for(x=i-1;x<=i-1;x++){
                for(y=j-1;y<=j-1;y++){
                    if(x>0 && x< monde.getTailleX() && y>0 && y< monde.getTailleY()) {
                        Cellule current = monde.getGrille()[y][x];
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
        boolean[] bornRules = rules.getBornRules();
        boolean[] surviveRules = rules.getSurviveRules();
        int nbVoisinesVivante = getNbvoisinesVivanteDe(cell.getX(),cell.getY());
        System.out.println(nbVoisinesVivante);
        if(cell.isAlive())
            if(surviveRules[nbVoisinesVivante])
                cell.setNextTimeStatus(0);
            else cell.setNextTimeStatus(-1);
        else //morte
            if(bornRules[nbVoisinesVivante])
                cell.setNextTimeStatus(1);
            else cell.setNextTimeStatus(0);
    }

    public int getNbvoisinesVivanteDe(int i,int j){
        int cpt=0;
        for(int x=i-1;x<=i-1;x++){
            for(int y=j-1;y<=j-1;y++){
                if(x>0 && x< monde.getTailleX() && y>0 && y< monde.getTailleY()) {
                    Cellule current = monde.getGrille()[y][x];
                    if(current.isAlive()){
                        cpt=cpt+1;}
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
}
