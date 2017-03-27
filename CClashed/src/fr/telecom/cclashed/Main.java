package fr.telecom.cclashed;

import java.awt.Color;
import java.util.List;
import fr.telecom.cclashed.MG2D.*;
import fr.telecom.cclashed.MG2D.geometrie.*;

public class Main {
	public static void main(String[] args) {
		
		int nbrLignes = 12;
		int nbrColonnes = 15;

		Board plateau = new Board(nbrLignes,nbrColonnes);
		
		int largeur = nbrColonnes * 60;
	    int hauteur = nbrLignes * 60;
	    int tailleC = 60;
	    Fenetre f = new Fenetre ("CClashed", largeur, hauteur);
	    
	    //private final static Clavier clavier = new Clavier();
	    Souris souris = new Souris(hauteur);
		
		List<Alignment> currentAlignments;
		do
		{
			plateau.resetBoard();
			do {
				currentAlignments = plateau.detectAllAlignments();
				plateau.deleteCandiesInAlignments(currentAlignments);
				plateau.eclater();
			}while(!plateau.checkTurnHasEnded());
		}
		while(plateau.checkGameHasEnded());

		/* Utilisation souris et clavier */
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		
		Point p;

		/* Gestion facile de l'affichage des cases */
		Texture cases[][] = new Texture[nbrLignes][nbrColonnes];

		/* Points qui permettront de récupérer les deux cases à inverser */
		Point posS1 = new Point(0,0);
		Point posS2 = new Point(0,0);
		int x1, y1, x2, y2;
		
		int diffHeight;
		int score = 0;

		/* Affichage du plateau une première fois */
		for (int i = 0; i < plateau.getHeight(); i++) {
			for (int j = 0; j < plateau.getWidth(); j++) {
				
				// La méthode getCandy n'utilise pas les même coordonnées que MG2D
				// la grille du plateau a le 0,0 en haut à gauche, MG2D en bas à gauche
				// diffHeight permet donc de calculer l'équivalent MG2D de l'ordonnée de getCandy
				diffHeight = plateau.getHeight() - i - 1;

				// ATTENTION : Point(x, y) -> j = x, i = y et pas l'inverse
				switch(plateau.getCandy(i,j).getColor()) {
				case 0:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/emptyCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				case 1:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/blueCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				case 2:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/brownCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				case 3:    
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/orangeCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				case 4:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/pinkCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				case 5:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/yellowCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;
					
				case 6:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/greenCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;
					
				case 7:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Texture(Color.WHITE,"../../resources/img/redCandy.png",p,tailleC,tailleC);
					f.ajouter(cases[i][j]);
					break;

				}
			}
		}
		
		while (!plateau.checkGameHasEnded()) {

		    /* Jeu en pause tant qu'il n'y a pas eu de premier clic */
		    while(!souris.getClicGauche()) {
		    	try {
		    		Thread.sleep(0,5);
		    	}catch(Exception e){} // pour ralentir un peu l'application
		    }
			
		    posS1 = souris.getPosition();
		    x1 = (int)((posS1.getX())/tailleC);
		    y1 = (int)((posS1.getY())/tailleC);
		    
		    /* On colore l'arrière-plan du premier bonbon cliqué */
		    cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.lightGray);
		    f.rafraichir();

		    /* Jeu en pause tant qu'il n'y a pas eu de deuxième clic */
		    while(!souris.getClicGauche()) {
		    	try {
		    		Thread.sleep(0,5);
		    	}catch(Exception e){} // pour ralentir un peu l'application
		    }
			
		    posS2 = souris.getPosition();
		    x2 = (int)((posS2.getX())/tailleC);
		    y2 = (int)((posS2.getY())/tailleC);
		    
		    /* On colore l'arrière-plan du deuxième bonbon cliqué */
		    cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.lightGray);
		    f.rafraichir();
		    
		    /* On vérifie que les bonbons soient voisins avant inversion */
		    if (((x1+1 == x2 || x1-1 == x2) && (y1 == y2)) || ((y1+1 == y2 || y1-1 == y2)) && (x1 == x2)) {

		    	Move move = new Move(plateau.getCandy(plateau.getHeight() - 1 - y1, x1), plateau.getCandy(plateau.getHeight() - 1 - y2, x2));
		    	
		    	if (plateau.checkMove(move)) {
		    		cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.GREEN);
		    		cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.GREEN);
		    		try {
		    			Thread.sleep(1000);
		    		}catch(Exception e){}
		    		plateau.executeMove(move);
		    		score++;
		    	}
		    	
		    	else if (!plateau.checkMove(move)) {
		    		cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.RED);
		    		cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.RED);
		    		try {
		    			Thread.sleep(1000);
		    		}catch(Exception e){}
		    	}
			
		    	cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.WHITE);
		    	cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.WHITE);
		    
		    }
		    
		    else {
		    	cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.RED);
	    		cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.RED);
	    		try {
	    			Thread.sleep(1000);
	    		}catch(Exception e){}
	    		cases[plateau.getHeight() - 1 - y1][x1].setCouleur(Color.WHITE);
		    	cases[plateau.getHeight() - 1 - y2][x2].setCouleur(Color.WHITE);
		    }
		    
		    do {
				currentAlignments = plateau.detectAllAlignments();
				plateau.deleteCandiesInAlignments(currentAlignments);
				plateau.eclater();
			}while(!plateau.checkTurnHasEnded());
		    
		    f.rafraichir();
		    
		    /* Au fur et à mesure des passages dans la boucle infinie, les deux boucles et le switch vont permettre d'actualiser la couleur de la bulle en fonction de la valeur qu'elle contient */ 
		    for (int i = 0; i < plateau.getHeight(); i++) {
		    	for (int j = 0; j < plateau.getWidth(); j++) {
		    		
		    		switch(plateau.getCandy(i,j).getColor()){
		    			case 0:
		    				cases[i][j].setImg("../../resources/img/emptyCandy.png");
		    				break;

		    			case 1:
		    				cases[i][j].setImg("../../resources/img/blueCandy.png");
		    				break;

		    			case 2:
		    				cases[i][j].setImg("../../resources/img/brownCandy.png");
		    				break;

		    			case 3:    
		    				cases[i][j].setImg("../../resources/img/orangeCandy.png"); 
		    				break;

		    			case 4:
		    				cases[i][j].setImg("../../resources/img/pinkCandy.png");
		    				break;

		    			case 5:
		    				cases[i][j].setImg("../../resources/img/yellowCandy.png");
		    				break;
		    				
		    			case 6:
		    				cases[i][j].setImg("../../resources/img/greenCandy.png");
		    				break;
		    				
		    			case 7:
		    				cases[i][j].setImg("../../resources/img/redCandy.png");
		    				break;
		    		}
			    f.rafraichir();
		    	}
		    }
		    
		}
		
		System.out.println("Plus aucun mouvement possible, partie terminée.");
		System.out.println("Votre score : " + score);
		
	}
}
