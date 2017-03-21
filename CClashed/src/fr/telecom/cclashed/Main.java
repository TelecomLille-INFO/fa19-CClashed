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

		Board plateau = new Board(10,10);
		
		List<Alignment> currentAlignments;
		do{
			currentAlignments = plateau.detectAllAlignments();
			plateau.deleteCandiesInAlignments(currentAlignments);
			plateau.eclater();
		}while(!plateau.checkTurnHasEnded());

		/* Utilisation souris et clavier */
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);
		
		Point p;

		/* Gestion facile de l'affichage des cases */
		Rectangle cases[][] = new Rectangle[10][10];

		/* Points qui permettront de récupérer les deux cases à inverser */
		Point posS1 = new Point(0,0);
		Point posS2 = new Point(0,0);
		int x1, y1, x2, y2;

		/* Affichage du plateau une première fois */
		// Peut être sortir ce bloc du main pour le mettre dans une méthode displayBoard() ?
		for (int i = 0; i < plateau.getHeight(); i++) {
			for (int j = 0; j < plateau.getWidth(); j++) {
				
				// La méthode getCandy n'utilise pas les même coordonnées que MG2D
				// la grille du plateau a le 0,0 en haut à gauche, MG2D en bas à gauche
				// diffHeight permet donc de calculer l'équivalent MG2D de l'ordonnée de getCandy
				int diffHeight = plateau.getHeight() - i - 1;

				// ATTENTION : Point(x, y) -> j = x, i = y et pas l'inverse
				switch(plateau.getCandy(i,j).getColor()) {
				case 0:
					p = new Point(j*tailleC,diffHeight*tailleC);
					cases[i][j] = new Rectangle(Color.WHITE,p,tailleC,tailleC,true);
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

				}
			}
		}
		
		System.out.println(plateau);
		
		// Bloc commenté pour simplifier le test d'affichage
		// (en vrai je sais pas du tout ce que ça fait)
/*		while (true) {
		    plateau.eclater();
		    f.rafraichir();

		    /* Au fur et à mesure des passages dans la boucle infinie, les deux boucles et le switch vont permettre d'actualiser la couleur de la bulle en fonction de la valeur qu'elle contient 
		    for (int i = 0; i < plateau.getHeight(); i++) {
		    	for (int j = 0; j < plateau.getWidth(); j++) {
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

		     Jeu en pause tant qu'il n'y a pas de clic 
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

		     On vérifie que les bonbons sont voisins avant inversion 
		    if (((x1+1 == x2 || x1-1 == x2) && (y1 == y2)) || ((y1+1 == y2 || y1-1 == y2)) && (x1 == x2))
			//insérer ici méthode pour switcher 2 points
		    f.rafraichir();
		}*/
	}
}
