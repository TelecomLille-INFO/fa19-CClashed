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
	protected Candy grid[][];
	/** Represente une liste de mouvements possibles sur le plateau de jeu */
	@SuppressWarnings("unused")
	private List<Move> possibleMoves;

	/**
		Constructeur de plateau
	 */
	public Board() {
		this.height = 8;
		this.width = 8;
		grid = new Candy[height][width];
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
	 *	Ajouter un Candy en une case donnee de la grid
	 *	@param row Entier representant la ligne
	 *	@param col Entier representant la colonne
	 */
	public void addCandy(int row, int col) {
		Candy bonbon = new Candy(row,col);
		grid[row][col] = bonbon;
	}

	/**
	 *	Ajouter un Candy en une case donnee de la grid
	 *	@param row Entier representant la ligne
	 *	@param col Entier representant la colonne
	 *	@param bonbon Candy a ajouter;
	 */
	public void addCandy(Candy bonbon) {
		grid[bonbon.getRow()][bonbon.getCol()] = bonbon;
	}

	/**
	 *	Recuperer un Candy en une case donnée de la grid
	 *	@param row Entier representant la ligne
	 *	@param col Entier representant la colonne
	 *	@return Candy Bonbon situe aux coordonnees fournies
	 */
	public Candy getCandy(int row, int col) {
		return grid[row][col];
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
	 *	Afficher l'etat d'un plateau
	 *	@return Chaine de caracteres representant l'etat d'un plateau
	 */
	public String toString() {
		String res = "Plateau de jeu :\n";
		for(int i = 0; i<height; ++i)
		{
			for(int j = 0; j<width; ++j)
			{
				if(grid[i][j] == null)
					res += "- ";
				else
					res += grid[i][j].getColor()+ " ";
			}
			res += "\n";
		}
		res += "Fin du plateau\n";
		return res;
	}

}
