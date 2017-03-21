package fr.telecom.cclashed;

import java.awt.Color;
import java.util.List;
import fr.telecom.cclashed.MG2D.*;
import fr.telecom.cclashed.MG2D.geometrie.*;

public class Main {

	final static int largeur = 600;
    final static int hauteur = 600;
    final static int tailleC = 60;
    static Fenetre f = new Fenetre ("CClashed", largeur, hauteur);
    
    //private final static Clavier clavier = new Clavier();
    private final static Souris souris = new Souris(600);
    
	public static void main(String[] args) {

		//Board plateau = new Board(6,6);
		
		//for(int j = 2; j<5;++j){
		//	Candy c = new Candy(3,3,j);
		//	plateau.addCandy(c);
		//}
		//do{
		//	System.out.println(plateau);
		//	List<Alignment> currentAlignments = plateau.detectAllAlignments();
		//	for(Alignment al:currentAlignments) {
		//		System.out.println(al);
		//	}
		//	plateau.deleteCandiesInAlignments(currentAlignments);
		//	plateau.eclater();
		//}while(!plateau.checkTurnHasEnded());

		//System.out.println(plateau);
		
		//System.out.println("Ajout Candy rouge en 2/4\n");
		//Candy redCandy = new Candy(4,2,4);
		//plateau.addCandy(redCandy);
		//System.out.println(plateau);*/
		
		/* Utilisation souris et clavier */
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);

		/* Création du plateau de jeu */
		Board plateau = new Board(10,10); 
		Point p;

		/* Gestion facile de l'affichage des cases */
		Carre cases[][] = new Carre[10][10];

		/* Points qui permettront de récupérer les deux cases à inverser */
		Point posS1 = new Point(0,0);
		Point posS2 = new Point(0,0);
		int x1, y1, x2, y2;

		/* Affichage du plateau une première fois */
		for (int i = 0; i < 10; i++) {
		    for (int j = 0; j < 10; j++) {
			switch(plateau.getCandy(i,j).getColor()) {
				case 0:
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(Color.WHITE,p,tailleC,true);
					f.ajouter(cases[i][j]);
					break;

				case 1:
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(Color.ORANGE,p,tailleC,true);
					f.ajouter(cases[i][j]);
					break;

				case 2:
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(Color.GREEN,p,tailleC,true);
			    	f.ajouter(cases[i][j]);
			    	break;

				case 3:    
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(Color.YELLOW,p,tailleC,true);
					f.ajouter(cases[i][j]);
					break;

				case 4:
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(Color.RED,p,tailleC,true);
					f.ajouter(cases[i][j]);
					break;

				case 5:
					p = new Point(i*tailleC,j*tailleC);
					cases[i][j] = new Carre(new Color(193,154,107),p,tailleC,true);
					f.ajouter(cases[i][j]);
					break;

				}
		    }
		}

		while (true) {
		    /* On éclate plusieurs fois pour ne pas avoir de vide au début */
		    for (int i = 0; i < 25; i++) {
		    	plateau.eclater();
		    }	
		    f.rafraichir();

		    /* Au fur et à mesure des passages dans la boucle infinie, les deux boucles et le switch vont permettre d'actualiser la couleur de la bulle en fonction de la valeur qu'elle contient */
		    for (int i = 0; i < 10; i++) {
		    	for (int j = 0; j < 10; j++) {
		    		switch(plateau.getCandy(i,j).getColor()){
		    			case 0:
		    				cases[i][j].setCouleur(Color.WHITE);
		    				break;

		    			case 1:
		    				cases[i][j].setCouleur(Color.ORANGE);
		    				break;

		    			case 2:
		    				cases[i][j].setCouleur(Color.GREEN);
		    				break;

		    			case 3:    
		    				cases[i][j].setCouleur(Color.YELLOW);  
		    				break;

		    			case 4:
		    				cases[i][j].setCouleur(Color.RED);
		    				break;

		    			case 5:
		    				cases[i][j].setCouleur(new Color(193,154,107));
		    				break;
		    		}
			    f.rafraichir();
		    	}
		    }

		    /* Jeu en pause tant qu'il n'y a pas de clic */
		    while(!souris.getClicGauche())
			try{Thread.sleep(0,5);}catch(Exception e){} // pour ralentir un peu l'application
		    posS1=souris.getPosition();
		    x1 = (int)((posS1.getX())/tailleC);
		    y1 = (int)((posS1.getY())/tailleC);

		    while(!souris.getClicGauche())
			try{Thread.sleep(0,5);}catch(Exception e){} // pour ralentir un peu l'application
		    posS2=souris.getPosition();
		    x2 = (int)((posS2.getX())/tailleC);
		    y2 = (int)((posS2.getY())/tailleC);

		    /* On vérifie que les bonbons sont voisins avant inversion */
		    if (((x1+1 == x2 || x1-1 == x2) && (y1 == y2)) || ((y1+1 == y2 || y1-1 == y2)) && (x1 == x2))
			//insérer ici méthode pour switcher 2 points
		    f.rafraichir();
		}
	}
}
