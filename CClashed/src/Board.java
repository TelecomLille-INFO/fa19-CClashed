/**
	La classe Board représente le plateau de jeu.
*/
public class Board {

	/** Représente la hauteur du plateau de jeu. */
	private int height;
	/** Représente la largeur du plateau de jeu. */
	private int width;
	/** Représente le tableau de bonbons. */
	private Candy grid[][];
	/** Représente une liste de mouvements possibles sur le plateau de jeu. */
	private List<Move> possibleMoves;
	
	/**
		Constructeur de plateau.
	*/
	public Board() {
		this.height = 8;
		this.width = 8;
		/* A voir comment on initialise le tableau et la liste */
	}
	
	/**
		Vérifier si le tour de jeu est terminé.
	*/
	public boolean checkTurnHasEnded() {
	
	}
	
	/**
		Vérifier si un mouvement est possible sur le plateau de jeu.
		@param m Mouvement dont on veut vérifier la possibilité.
		@return True si le mouvement est possible, False sinon.
	*/
	public boolean checkMove(Move m) {
	
	}
	
	/**
		Effectuer un mouvement sur le plateau de jeu.
		@param m Mouvement à effectuer.
	*/
	public void executeMove(Move m) {
	
	}
	
	/**
		Afficher l'état d'un plateau.
	*/
	public String toString() {
		
	}

}
