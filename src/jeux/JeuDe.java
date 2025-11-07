package jeux;

import java.util.Random;

public class JeuDe extends JeuSimple {

    private Random rand;

    public JeuDe() {
        this.nom = "Jeu de Dés";
        this.rand = new Random();
    }

    @Override
    public String jouerUnTour() {
        int lancer = rand.nextInt(6) + 1;
        return lancer + "";
    }

    @Override
    public int arbitrer(String c1, String c2) {
        int coup1 = Integer.parseInt(c1);
        int coup2 = Integer.parseInt(c2);

        if (coup1 > coup2) {
            return -1;
        } else if (coup2 > coup1) {
            return 1;
        } else {
            return 0;
        }
    }
}