package modele;

import java.util.ArrayList;

public class Cellule {
    private int NextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre
    private boolean Alive;
    private ArrayList<Cellule> cellulesVoisines;

    public Cellule() { //on initialise toutes les cellules en créant la grille
        NextTimeStatus = 0;
        Alive = false;
        this.cellulesVoisines = new ArrayList<Cellule>();
    }



    public int getNextTimeStatus() {
        return NextTimeStatus;
    }

    public void setNextTimeStatus(int nextTimeStatus) {
        NextTimeStatus = nextTimeStatus;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public ArrayList<Cellule> getCellulesVoisines() {
        return cellulesVoisines;
    }

    public void setCellulesVoisines(ArrayList<Cellule> cellulesVoisines) {
        this.cellulesVoisines = cellulesVoisines;
    }


}
