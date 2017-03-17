package fr.telecom.cclashed;

import java.awt.Color;
import java.util.List;
import fr.telecom.cclashed.MG2D.*;
import fr.telecom.cclashed.MG2D.geometrie.*;

public class Main {

	final static int largeur = 600;
    final static int hauteur = 600;
    final static int tailleC = 60;
    static Fenetre f = new Fenetre ("Cclashed", largeur, hauteur);
    
    private final static Clavier clavier = new Clavier();
    private final static Souris souris = new Souris(600);
    
	public static void main(String[] args) {

		//Board plateau = new Board(6,6);
		
		//for(int j = 2; j<5;++j){
		//	Candy c = new Candy(3,3,j);
		//	plateau.addCandy(c);
		//}
		//do{
		//	System.out.println(plateau);
		//	List<Alignment> currentAlignments = plateau.detectAlignments();
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
		
		/* utilisaiton souris et clavier */
		f.addMouseListener(souris);
		f.getP().addMouseListener(souris);
		f.getP().addMouseMotionListener(souris);

		/* creation du plateau */
		Board plateau = new Board(10,10); 
		Point p;

		/* gestion facile de l'affichage des cases */
		Carre cases[][] = new Carre[10][10];

		/* points qui permettront de recuperer les deux cases a inverser */
		Point posS1 = new Point(0,0);
		Point posS2 = new Point(0,0);
		int x1, y1, x2, y2;

		/* affichage du plateau une premiere fois */
		for (int i = 0; i < 10; i++){
		    for (int j = 0; j < 10; j++){
			switch(plateau.getCandy(i,j).getColor()){
			case 0:
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.white,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 1:
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.red,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 2:
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.green,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 3:    
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.blue,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 4:
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.yellow,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 5:
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.magenta,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			case 6 :
			    p = new Point(i*tailleC,j*tailleC);
			    cases[i][j] = new Carre(Color.orange,p,tailleC,true);
			    f.ajouter(cases[i][j]);
			    break;

			}
		    }
		}

		while (true){
		    /* on eclate plusieurs fois pour ne pas avoir de vide au debut */
		    for (int i = 0; i < 25; i++){
			plateau.eclater();
		    }	
		    f.rafraichir();

		    /* au fur et a mesure des passages dans la boucle infinie, les deux boucles et le switch vont permettre d'actualiser la couleur de la bulle en fonction de la valeur qu'elle contient */
		    for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
			    switch(plateau.getCandy(i,j).getColor()){
			    case 0:
				cases[i][j].setCouleur(Color.white);
				break;

			    case 1:
				cases[i][j].setCouleur(Color.red);
				break;

			    case 2:
				cases[i][j].setCouleur(Color.green);
				break;

			    case 3:    
				cases[i][j].setCouleur(Color.blue);  
				break;

			    case 4:
				cases[i][j].setCouleur(Color.yellow);
				break;

			    case 5:
				cases[i][j].setCouleur(Color.magenta);
				break;

			    case 6 :
				cases[i][j].setCouleur(Color.orange);
				break;

			    }
			    f.rafraichir();
			}
		    }

		    /* jeu en pause tant qu'il n'y a pas de clic */
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

		    /* on verifie que les cases sont voisines pour inverser leurs valeurs */
		    if (((x1+1 == x2 || x1-1 == x2) 
			 && (y1 == y2)) || ((y1+1 == y2 || y1-1 == y2)) 
			&& (x1 == x2))
			//insérer ici éthode pour switcher 2 points
		    f.rafraichir();
		}
	}
}
