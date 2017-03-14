package main.java;

import java.util.List;

/**
*	La classe Candy représente un bonbon sous sa forme la plus abstraite
*/
public class Candy {

	/** Représente la couleur d'un bonbon */
	protected int color;
	/** Représente le numéro de ligne d'un bonbon sur le plateau de jeu */
	protected int row;
	/** Représente le numéro de colonne d'un bonbon sur le plateau de jeu */
	protected int col;
	
	/** Constante 'EMPTY' (entier : 0) pouvant être affectée à l'attribut color */
   	public static final int EMPTY=0;
   	/** Constante 'ORANGE' (entier : 1) pouvant être affectée à l'attribut color */
    	public static final int ORANGE=1;
    	/** Constante 'GREEN' (entier : 2) pouvant être affectée à l'attribut color */
    	public static final int GREEN=2;
    	/** Constante 'YELLOW' (entier : 3) pouvant être affectée à l'attribut color */
    	public static final int YELLOW=3;
    	/** Constante 'RED' (entier : 4) pouvant être affectée à l'attribut color */
    	public static final int RED=4;
    	/** Constante 'CAMEL' (entier : 5) pouvant être affectée à l'attribut color */
    	public static final int CAMEL=5;
    	
    	/** Booléen indiquant si le bonbon en question est à supprimer du plateau ou non */
    	protected boolean aSupprimer=false;
    	

	/**
	*	Constructeur de bonbon prenant en paramètres la ligne et la colonne et affectant aléatoirement une couleur
	*	@param row Ligne
	*	@param col Colonne
	*/
	public Candy(int row, int col) {
		this.color = (int)(Math.random()*(6)+1);
		this.row = row;
		this.col = col;
	}
	
	/**
	*	Constructeur de bonbon prenant en paramètres la couleur, la ligne et la colonne
	*	@param color Couleur
	*	@param row Ligne
	*	@param col Colonne
	*/
	public Candy(int color, int row, int col) {
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	/**
	*	Constructeur par copie
	*	@param c Bonbon depuis lequel on se base
	*/
	public Candy(Candy c) {
		this.color = c.color;
		this.row = c.row;
		this.col = c.col;
	}
	
	/**
	*	Accesseur
	*	@return Entier représentant la couleur du bonbon
	*/
	public int getColor() {
		return this.color;
	}
	
	/**
	*	Mutateur
	*	@param color Entier représentant la couleur du bonbon
	*/
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	*	Accesseur
	*	@return Entier représentant la ligne du bonbon
	*/
	public int getRow() {
		return this.row;
	}
	
	/**
	*	Mutateur
	*	@param row Numéro de ligne du bonbon
	*/
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	*	Accesseur
	*	@return Entier représentant la colonne du bonbon
	*/
	public int getCol() {
		return this.col;
	}
	
	/**
	*	Mutateur
	*	@param col Numéro de colonne du bonbon
	*/
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	*	Accesseur
	*	@return Booléen indiquant si le bonbon en question est à supprimer du plateau ou non
	*/
	public boolean getASupprimer() {
		return this.aSupprimer;
	}

	/**
	*	Mutateur
	*	@param aSupprimer Booléen à true si le bonbon est à supprimer du plateau, false sinon
	*/
	public void setASupprimer(boolean aSupprimer) {
		this.aSupprimer = aSupprimer;
	}
	
	/**
	*	Détecter si le bonbon est dans un alignement
	*	@param sens Sens de l'alignement
	*	@param liste Liste à analyser
	*	@return True si le bonbon est dans l'alignement, false sinon
	*/
	public boolean isWithinAlignment(Sens sens, List<Alignment> liste) {
		boolean res = false;
		for(Alignment al: liste)
		{
			if(al.orientation.equals(sens))
			{
				if(sens.equals(Sens.VERTICAL))
				{
					int color = al.getStart().getColor();
					int x = al.getStart().getCol();
					int yStart = al.getStart().getRow();
					int yEnd = al.getEnd().getRow();
					if(this.getColor() == color && this.getCol() == x)
					{
						if(this.getRow() >= yStart && this.getRow() <= yEnd)
							res = true;
					}
				}
				else if(sens.equals(Sens.HORIZONTAL))
				{
					int color = al.getStart().getColor();
					int y = al.getStart().getRow();
					int xStart = al.getStart().getCol();
					int xEnd = al.getEnd().getCol();
					if(this.getColor() == color && this.getRow() == y)
					{
						if(this.getCol() >= xStart && this.getCol() <= xEnd)
							res = true;
					}
				}
			}
		}
		return res;
	}
	
	/**
	*	Tester l'égalité de deux bonbons
	*	@param c Bonbon dont on veut tester l'égalite avec l'instance courante
	*	@return True si les deux bonbons sont égaux, false sinon
	*/
	public boolean equals(Candy c) {
		if ((this.color == c.color) && (this.row == c.row) && (this.col == c.col)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	*	Afficher l'état d'un bonbon
	*	@return Chaîne de caractères représentant l'état d'un bonbon
	*/
	public String toString() {
		return "/----------\n| Affichage du bonbon :\n|\n| Id couleur = " + this.color + "\n| N. ligne = " + this.row + "\n| N. colonne = " + this.col + "\n|\n----------/";
	}

}
