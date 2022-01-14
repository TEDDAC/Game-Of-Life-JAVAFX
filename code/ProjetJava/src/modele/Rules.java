package modele;

public class Rules {
    //SimpleListProperty<E> pour le binding
    private boolean[] bornRules;
    private boolean[] surviveRules;

    public Rules(boolean[] bornRules, boolean[] surviveRules){
        this.bornRules = bornRules;
        this.surviveRules = surviveRules;
    }

    public boolean[] getBornRules() {
        return bornRules;
    }

    public void setBornRules(boolean[] bornRules) {
        this.bornRules = bornRules;
    }

    public boolean[] getSurviveRules() {
        return surviveRules;
    }

    public void setSurviveRules(boolean[] surviveRules) {
        this.bornRules = surviveRules;
    }
}
