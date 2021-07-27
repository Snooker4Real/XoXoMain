package fr.snooker4real.model;

public class Case {

    public static final String EMPTY=" ";
    public static final String X="X";
    public static final String O="O";

    private String etat;

    public Case() {
        etat = EMPTY;
    }

    public Case(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }
}
