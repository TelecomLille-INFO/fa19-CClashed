import java.util.List;

/**
	La classe Board représente le plateau de jeu
*/
public class Board {

	/** Représente la hauteur du plateau de jeu */
	private int height;
	/** Représente la largeur du plateau de jeu */
	private int width;
	/** Représente le tableau de bonbons */
	private Candy grid[][];
	/** Représente une liste de mouvements possibles sur le plateau de jeu */
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
	*	@return Entier représentant la hauteur du plateau de jeu
	*/
	public int getHeight() {
		return this.height;
	}
	
	/**
	*	Mutateur
	*	@param height Entier représentant la hauteur du plateau de jeu
	*/
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	*	Accesseur
	*	@return Entier représentant la largeur du plateau de jeu
	*/
	public int getWidth() {
		return this.width;
	}
	
	/**
	*	Mutateur
	*	@param width Entier représentant la largeur du plateau de jeu
	*/
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
		Vérifier si le tour de jeu est terminé
		@return True si le tour de jeu est terminé, false sinon
	*/
	public boolean checkTurnHasEnded() {
		System.out.println("Appel de la méthode checkTurnHasEnded() de la classe Board");
		return true;
	}
	
	/**
	*	Vérifier si un mouvement est possible sur le plateau de jeu
	*	@param m Mouvement dont on veut vérifier la possibilité
	*	@return True si le mouvement est possible, false sinon
	*/
	public boolean checkMove(Move m) {
		System.out.println("Appel de la méthode checkMove(Move m) de la classe Board");
		return true;
	}
	
	/**
	*	Effectuer un mouvement sur le plateau de jeu
	*	@param m Mouvement à effectuer
	*/
	public void executeMove(Move m) {
		System.out.println("Appel de la méthode executeMove(Move m) de la classe Board");
	}
	
	/**
	*	Afficher l'état d'un plateau
	*	@return Chaîne de caractères représentant l'état d'un plateau
	*/
	public String toString() {
		return "Appel de la méthode toString() de la classe Board";
	}

}
