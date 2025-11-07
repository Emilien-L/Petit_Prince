package jeux;

import java.util.Random;

public class JeuShifumi extends JeuSimple {

    public enum Shifumi {
        PIERRE,
        FEUILLE,
        CISEAUX
    }

    private Random rand;
    private Shifumi[] coups;

    public JeuShifumi() {
        this.nom = "Shifumi";
        this.rand = new Random();
        this.coups = Shifumi.values();
    }

    @Override
    public String jouerUnTour() {
        int indexAleatoire = rand.nextInt(coups.length);
        Shifumi coup = coups[indexAleatoire];
        return coup.toString();
    }

    @Override
    public int arbitrer(String c1, String c2) {
        Shifumi coup1 = Shifumi.valueOf(c1);
        Shifumi coup2 = Shifumi.valueOf(c2);

        if (coup1 == coup2) {
            return 0;
        }

        switch (coup1) {
            case PIERRE:
                return (coup2 == Shifumi.CISEAUX) ? -1 : 1;
            case FEUILLE:
                return (coup2 == Shifumi.PIERRE) ? -1 : 1;
            case CISEAUX:
                return (coup2 == Shifumi.FEUILLE) ? -1 : 1;
        }

        return 0;
    }
}