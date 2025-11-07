package personnage;

import asteroide.Sujet;
import asteroide.console.ConsoleJavaBoy;
import jeux.JeuDe;
import jeux.JeuShifumi;
import jeux.JeuSimple;
import jeux.Joueur;

import java.util.ArrayList;
import java.util.Random;

public class PetitPrince implements Sujet, Joueur {

	private String nom;
	private int argent;
	private ConsoleJavaBoy console;
	private int cpt;

	private ArrayList<Integer> sujetsConnus;
	private ArrayList<JeuSimple> jeux;
	private Random rand;

	public PetitPrince(String nom) {
		this.nom = nom;
		this.argent = 10;
		this.cpt = 0;
		this.console = new ConsoleJavaBoy(this);
		
		this.sujetsConnus = new ArrayList<>();
		this.rand = new Random();
		
		this.jeux = new ArrayList<>();
		this.jeux.add(new JeuDe());
		this.jeux.add(new JeuShifumi());
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getArgent() {
		return this.argent;
	}

	@Override
	public void gagner(int argent) {
		this.argent += argent;
		this.console.parler("J'ai gagnée " + argent + " ! J'ai maintenant " + this.argent);
	}

	@Override
	public void perdre(int argent) {
		this.argent -= argent;
		this.console.parler("J'ai perdu " + argent + "... Il me reste " + this.argent);
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int abs(int a) {
		return (a < 0) ? -a : a;
	}

	private int distanceChebyshev(int l, int c) {
		return max(abs(l - 10), abs(c - 10));
	}

	private int[] chercherPlusProche(int[][] vision) {
		int[] sujetPlusProche = null;
		int distanceMin = 21;

		for (int l = 0; l < 20; l++) {
			for (int c = 0; c < 20; c++) {
				int idSujet = vision[l][c];
				
				if (idSujet > 0 && !this.sujetsConnus.contains(idSujet)) {
					int d = distanceChebyshev(l, c);
					if (d < distanceMin) {
						distanceMin = d;
						sujetPlusProche = new int[]{idSujet, l, c};
					}
				}
			}
		}
		return sujetPlusProche;
	}

	@Override
	public void run() {
		this.cpt++;
		
		int[][] vision = this.console.regarder();
		int[] sujetProche = this.chercherPlusProche(vision);

		if (sujetProche != null) {
			int idSujet = sujetProche[0];
			int l = sujetProche[1];
			int c = sujetProche[2];
			
			int distance = distanceChebyshev(l, c);

			if (distance <= 1) {
				JeuSimple jeuAleatoire = this.jeux.get(rand.nextInt(this.jeux.size()));
				this.console.jouer(jeuAleatoire, idSujet);
				this.sujetsConnus.add(idSujet);
			} else {
				this.console.seDirigerVers(idSujet);
			}
		} else {
			this.console.seDirigerVers(0);
		}
	}
}