package modele;


import java.util.ArrayList;

public class Cellule {
    private int nextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre
    private boolean alive;
    private int x;
    private int y;

    public Cellule(int x,int y) { //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        alive = false;
        this.x = x;
        this.y = y;
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

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
