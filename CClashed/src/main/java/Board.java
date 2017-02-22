package main.java;
import java.util.List;

/**
	La classe Board represente le plateau de jeu
*/
public class Board {

	/** Represente la hauteur du plateau de jeu */
	private int height;
	/** Represente la largeur du plateau de jeu */
	private int width;
	/** Represente le tableau de bonbons */
	private Candy grid[][];
	/** Represente une liste de mouvements possibles sur le plateau de jeu */
	private List<Move> possibleMoves;
	
	/**
		Constructeur de plateau
	*/
	public Board() {
		this.height = 8;
		this.width = 8;
		/* A voir comment on initialise le tableau et la liste */
	}
	
	/**
	*	Accesseur
	*	@return Entier representant la hauteur du plateau de jeu
	*/
	public int getHeight() {
		return this.height;
	}
	
	/**
	*	Mutateur
	*	@param height Entier representant la hauteur du plateau de jeu
	*/
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	*	Accesseur
	*	@return Entier representant la largeur du plateau de jeu
	*/
	public int getWidth() {
		return this.width;
	}
	
	/**
	*	Mutateur
	*	@param width Entier representant la largeur du plateau de jeu
	*/
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
		Verifier si le tour de jeu est termine
		@return True si le tour de jeu est termine, false sinon
	*/
	public boolean checkTurnHasEnded() {
		System.out.println("Appel de la methode checkTurnHasEnded() de la classe Board");
		return true;
	}
	
	/**
	*	Verifier si un mouvement est possible sur le plateau de jeu
	*	@param m Mouvement dont on veut verifier la possibilite
	*	@return True si le mouvement est possible, false sinon
	*/
	public boolean checkMove(Move m) {
		System.out.println("Appel de la methode checkMove(Move m) de la classe Board");
		return true;
	}
	
	/**
	*	Effectuer un mouvement sur le plateau de jeu
	*	@param m Mouvement a effectuer
	*/
	public void executeMove(Move m) {
		System.out.println("Appel de la methode executeMove(Move m) de la classe Board");
	}
	
	/**
	*	Afficher l'état d'un plateau
	*	@return Chaine de caracteres representant l'etat d'un plateau
	*/
	public String toString() {
		return "Appel de la methode toString() de la classe Board";
	}

}
