package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Rules {
    private SimpleBooleanProperty[] BornRules;
    public SimpleBooleanProperty getBornRules(int i){ return BornRules[i]; }
    public void setBornRules(int i,boolean valeur){ BornRules[i].set(valeur);}
    public ReadOnlyBooleanProperty[] bornRulesProperty() { return BornRules; };

    private boolean[] surviveRules;

    public Rules(SimpleBooleanProperty[] bornRules, boolean[] surviveRules){
        this.BornRules = bornRules;
        this.surviveRules = surviveRules;
    }

    public BooleanProperty[] getBornRules() {
        return BornRules;
    }

    /*public void setBornRules(boolean[] bornRules) {
        this.bornRules = bornRules;
    }*/

    public boolean[] getSurviveRules() {
        return surviveRules;
    }

    public void setSurviveRules(boolean[] surviveRules) {
        this.surviveRules = surviveRules;
    }
}
