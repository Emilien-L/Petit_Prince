package jeux;

import personnage.PetitPrince;

public class TestArbitre {

    public static void arbitrer(PetitPrince j1, PetitPrince j2, JeuSimple jeu) {
        String coup1 = jeu.jouerUnTour();
        String coup2 = jeu.jouerUnTour();

        System.out.println("J1 (" + j1.getNom() + ") joue : " + coup1);
        System.out.println("J2 (" + j2.getNom() + ") joue : " + coup2);

        int resultat = jeu.arbitrer(coup1, coup2);

        if (resultat == -1) {
            System.out.println("Gagnant : J1 (" + j1.getNom() + ")");
            j1.gagner(1);
            j2.perdre(1);
        } else if (resultat == 1) {
            System.out.println("Gagnant : J2 (" + j2.getNom() + ")");
            j1.perdre(1);
            j2.gagner(1);
        } else {
            System.out.println("Egalite");
        }
    }

    public static void main(String[] args) {
        
        PetitPrince joueur1 = new PetitPrince("JoueurTest1");
        PetitPrince joueur2 = new PetitPrince("JoueurTest2");

        System.out.println("Jouons maintenant au jeu Dés");
        JeuSimple jeuDe = new JeuDe();
        arbitrer(joueur1, joueur2, jeuDe);

        System.out.println("\nJouons maintenant au jeu Shifumi");
        JeuSimple jeuShifumi = new JeuShifumi();
        arbitrer(joueur1, joueur2, jeuShifumi);
        
        System.out.println("\n--- Bilan des joueurs ---");
        System.out.println(joueur1.getNom() + " a " + joueur1.getArgent() + " argent.");
        System.out.println(joueur2.getNom() + " a " + joueur2.getArgent() + " argent.");
    }
}