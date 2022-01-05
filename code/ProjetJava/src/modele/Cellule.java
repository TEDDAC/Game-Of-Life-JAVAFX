package modele;


import java.util.ArrayList;

public class Cellule {
    private int nextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre
    private boolean alive;

    public Cellule() { //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        alive = false;
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
        this.alive = alive;
    }

    public int getNbVoisinesVivante(){
        return 2;
    }

    public void update(){
        if(nextTimeStatus == 1) alive = true;
        if(nextTimeStatus == -1) alive = false;
    }
}
