package main.java;
/**
	La classe Candy represente un bonbon sous sa forme la plus abstraite
*/
public class Candy {

	/** Represente la couleur d'un bonbon */
	protected int color;
	/** Represente le numero de ligne d'un bonbon sur le plateau de jeu */
	protected int row;
	/** Represente le numero de colonne d'un bonbon sur le plateau de jeu */
	protected int col;
	
	/** Constante 'EMPTY' (entier : 0) pouvant etre affectee a l'attribut color */
   	public static final int EMPTY=0;
   	/** Constante 'ORANGE' (entier : 1) pouvant etre affectee a l'attribut color */
    	public static final int ORANGE=1;
    	/** Constante 'GREEN' (entier : 2) pouvant etre affectee a l'attribut color */
    	public static final int GREEN=2;
    	/** Constante 'YELLOW' (entier : 3) pouvant etre affectee a l'attribut color */
    	public static final int YELLOW=3;
    	/** Constante 'RED' (entier : 4) pouvant etre affectee a l'attribut color */
    	public static final int RED=4;
    	/** Constante 'CAMEL' (entier : 5) pouvant etre affectee a l'attribut color */
    	public static final int CAMEL=5;
    	
    	/**
	*	Constructeur de bonbon prenant en parametres la ligne et la colonne et affectant aleatoirement une couleur
	*	@param row Ligne
	*	@param col Colonne
	*/
	public Candy(int row, int col) {
		this.color = (int)(Math.random()*(6));
		this.row = row;
		this.col = col;
	}
	
	/**
	*	Constructeur de bonbon prenant en parametres la couleur, la ligne et la colonne
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
	*	@return Entier representant la couleur du bonbon
	*/
	public int getColor() {
		return this.color;
	}
	
	/**
	*	Mutateur
	*	@param color Entier representant la couleur du bonbon
	*/
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	*	Accesseur
	*	@return Entier representant la ligne du bonbon
	*/
	public int getRow() {
		return this.row;
	}
	
	/**
	*	Mutateur
	*	@param row Numero de ligne du bonbon
	*/
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	*	Accesseur
	*	@return Entier representant la colonne du bonbon
	*/
	public int getCol() {
		return this.col;
	}
	
	/**
	*	Mutateur
	*	@param col Numero de colonne du bonbon
	*/
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	*	Tester l'egalite entre deux bonbons
	*	@param c Bonbon dont on veut tester l'egalite avec l'instance courante
	*	@return True si les deux bonbons sont egaux, false sinon
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
	*	Afficher l'etat d'un bonbon
	*	@return Chaine de caracteres representant l'etat d'un bonbon
	*/
	public String toString() {
		return "/----------\n| Affichage du bonbon :\n|\n| Id couleur = " + this.color + "\n| N° ligne = " + this.row + "\n| N° colonne = " + this.col + "\n|\n----------/";
	}

}
