package modele;

import java.util.ArrayList;

public class Cellule {
    private int NextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre
    private boolean Alive;
    private ArrayList<Cellule> celluesVoisines;



    public Cellule(int nextTimeStatus, boolean alive, ArrayList<Cellule> celluesVoisines) {
        NextTimeStatus = nextTimeStatus;
        Alive = alive;
        this.celluesVoisines = celluesVoisines;
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

    public ArrayList<Cellule> getCelluesVoisines() {
        return celluesVoisines;
    }

    public void setCelluesVoisines(ArrayList<Cellule> celluesVoisines) {
        this.celluesVoisines = celluesVoisines;
    }


}
