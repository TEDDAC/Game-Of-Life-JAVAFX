package modele;


import java.util.ArrayList;

public class Cellule {
    private int nextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre
    private boolean alive;
    private ArrayList<Cellule> cellulesVoisines;

    public Cellule(ArrayList<Cellule> voisines) { //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        alive = false;
        this.cellulesVoisines = voisines;
    }



    public int getNextTimeStatus() {
        return nextTimeStatus;
    }

    public void setNextTimeStatus(int nextTimeStatus) {
        nextTimeStatus = nextTimeStatus;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        alive = alive;
    }

    public ArrayList<Cellule> getCellulesVoisines() {
        return cellulesVoisines;
    }

    public void setCellulesVoisines(ArrayList<Cellule> cellulesVoisines) {
        this.cellulesVoisines = cellulesVoisines;
    }


    public int getNbVoisinesVivante(){
        return 2;
    }

    public void evolve(Rules rules)
    {
        int nbVoisinesVivantes = getNbVoisinesVivante();
        boolean[] survivedRules = rules.getSurviveRules();
        boolean[] bornRules = rules.getBornRules();
        if(isAlive()){
            if(survivedRules[nbVoisinesVivantes])
                this.nextTimeStatus = 0;
            else this.nextTimeStatus = -1;
        } else {
            if(bornRules[nbVoisinesVivantes])
                this.nextTimeStatus = 1;
            else this.nextTimeStatus = 0;
        }
    }

    public void update(){
        if(nextTimeStatus == 1) alive = true;
        if(nextTimeStatus == -1) alive = false;
    }
}
