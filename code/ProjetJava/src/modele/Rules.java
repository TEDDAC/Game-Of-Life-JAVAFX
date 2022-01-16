package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Rules {
    private SimpleBooleanProperty[] BornRules;
    public SimpleBooleanProperty getBornRules(int i){ return BornRules[i]; }
    public void setBornRules(int i,boolean valeur){ BornRules[i].set(valeur);}
    public final BooleanProperty bornRulesProperty(int i) { return BornRules[i]; };

    private SimpleBooleanProperty[] SurviveRules;
    public SimpleBooleanProperty getSurviveRules(int i){ return SurviveRules[i]; }
    public void setSurviveRules(int i,boolean valeur){ SurviveRules[i].set(valeur);}
    public final BooleanProperty surviveRulesProperty(int i) { return SurviveRules[i]; };

    public Rules(SimpleBooleanProperty[] bornRules, SimpleBooleanProperty[] surviveRules){
        this.BornRules = bornRules;
        this.SurviveRules = surviveRules;
    }

    public BooleanProperty[] getBornRules() {
        return BornRules;
    }

    /*public void setBornRules(boolean[] bornRules) {
        this.bornRules = bornRules;
    }*/

    public BooleanProperty[] getSurviveRules() {
        return SurviveRules;
    }

    /*public void setSurviveRules(boolean[] surviveRules) {
        this.SurviveRules = surviveRules;
    }*/
}
