package personnage;

import asteroide.Sujet; 
import asteroide.console.ConsoleJavaBoy_OLD;

public class PetitPrince0 implements Sujet {

	private String nom;
	private int argent;
	private ConsoleJavaBoy_OLD console;
	private int cpt;
	
	
	public PetitPrince0() {
		this.nom = "PetitPrince0"; 
		this.argent = 0;
		this.cpt = 0;

		this.console = new ConsoleJavaBoy_OLD(this); 
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
	public void run() {
		this.cpt++; 
		
		this.console.parler("Tour " + this.cpt + ": Je suis sur l'astéroïde !");
		
		this.console.seDirigerVers(0); 
	}
}