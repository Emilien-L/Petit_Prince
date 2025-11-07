package jeux;

public abstract class JeuSimple {

	protected String nom;
	
	
	public String getNom() {
		return this.nom;
	}
	
	public abstract String jouerUnTour();
	
	public abstract int arbitrer(String c1, String c2);
}
