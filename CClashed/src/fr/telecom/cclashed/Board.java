package fr.telecom.cclashed;
import java.util.ArrayList;
import java.util.List;

/**
*	La classe Board représente le plateau de jeu
*/
public class Board {

	/** Représente la hauteur du plateau de jeu */
	private int height;
	/** Représente la largeur du plateau de jeu */
	private int width;
	/** Représente le tableau de bonbons */
	protected Candy grid[][];
	/** Représente une liste de mouvements possibles sur le plateau de jeu */
	private List<Move> possibleMoves;

	/**
	*	Constructeur par défaut de plateau
	*/
	public Board() {
		this.height = 8;
		this.width = 8;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
		/* A voir comment on initialise le tableau et la liste */
		resetBoard();
	}
	
	/**
	*	Constructeur de plateau prenant en paramètres la hauteur et la largeur du plateau
	*	@param height Entier représentant la hauteur du plateau
	*	@param width Entier représentant la largeur du plateau
	*/
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
		/* A voir comment on initialise le tableau et la liste */
		resetBoard();
	}
	
	/**
	 * Méthode permettant de réinitialiser le plateau
	 */
	private void resetBoard()
	{
		for(int i = 0; i<this.getHeight();++i)
		{
			for(int j = 0; j<this.getWidth();++j)
			{
				Candy c = new Candy(i,j);
				this.addCandy(c);
			}
		}	
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
	*	Ajouter un bonbon généré aléatoirement en une case donnée du plateau de jeu
	*	@param row Entier représentant le numéro de ligne
	*	@param col Entier représentant le numéro de colonne
	*/
	public void addCandy(int row, int col) {
		Candy bonbon = new Candy(row,col);
		grid[row][col] = bonbon;
	}

	/**
	*	Ajouter un bonbon précis sur le plateau de jeu
	*	@param bonbon Candy a ajouter;
	*/
	public void addCandy(Candy bonbon) {
		grid[bonbon.getRow()][bonbon.getCol()] = bonbon;
	}

	/**
	*	Récupérer un bonbon situé sur une case donnée du plateau de jeu
	*	@param row Entier représentant le numéro de ligne
	*	@param col Entier représentant le numéro de colonne
	*	@return Bonbon situé aux coordonnées passées en paramètres
	*/
	public Candy getCandy(int row, int col) {
		return grid[row][col];
	}

	/**
	*	Vérifier si le tour de jeu est terminé
	*	@return True si le tour de jeu est terminé, false sinon
	*/
	public boolean checkTurnHasEnded() {
		for(int i=0; i<this.getHeight(); i++) {
			for(int j=0; j<this.getWidth(); j++) {
				if(this.getCandy(i,j).getASupprimer()==true) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	*	Vérifier si un mouvement est possible sur le plateau de jeu
	*	@param m Mouvement dont on veut vérifier la possibilité
	*	@return True si le mouvement est possible, false sinon
	*/
	public boolean checkMove(Move m) {
		System.out.println("Appel de la methode checkMove(Move m) de la classe Board");
		return true;
	}

	/**
	*	Chercher les mouvements possibles sur le plateau de jeu
	*/
	public void findPossibleMoves(){
		possibleMoves.clear();
		//TODO
	}

	/**
	*	Effectuer un mouvement sur le plateau de jeu
	*	@param m Mouvement à effectuer
	*/
	public void executeMove(Move m) {
		System.out.println("Appel de la methode executeMove(Move m) de la classe Board");
	}

	/**
	*	Vérifier la condition d'arrêt de partie
	*	@return True si la partie est terminée, false sinon
	*/
	public Boolean checkGameHasEnded()
	{
		return possibleMoves.isEmpty();
	}

	/**
	*	Afficher l'état d'un plateau de jeu
	*	@return Chaîne de caractères représentant l'état d'un plateau de jeu
	*/
	public String toString() {
		String res = "Plateau de jeu :\n";
		for(int i=0; i<height; ++i) {
			for(int j=0; j<width; ++j) {
				if(grid[i][j] == null) {
					res += "- ";
				}
				else {
					res += grid[i][j].getColor()+ " ";
				}
			}
			res += "\n";
		}
		res += "Fin du plateau\n";
		return res;
	}
	
	/**
	*	Méthode permettant de détecter les alignements et marquer les Candy à supprimer
	*/
	public void detectAlignments() {
		//Liste des alignements à remplir
		List<Alignment> alignements = new ArrayList<Alignment>();
		
		//Parcours vertical
		for(int i=0; i<this.getHeight(); ++i) {
			//Parcours horizontal
			for(int j = 0; j<this.getWidth();++j) {
				Candy currentCandy = grid[i][j];
				// On checke si le Candy est deja dans un alignement vertical...
				if(!currentCandy.isWithinAlignment(Sens.VERTICAL, alignements)) {
					// Si non on detecte les eventuels alignements
					Alignment vAlign = detectVerticalAlignment(currentCandy);
					if(vAlign.orientation == Sens.VERTICAL) {
						alignements.add(vAlign);
					}
				}
				// ... ou horizontal
				else if(!currentCandy.isWithinAlignment(Sens.HORIZONTAL, alignements)) {
					// Si non on detecte les eventuels alignements
					Alignment hAlign = detectHorizontalAlignment(currentCandy);
					if(hAlign.orientation == Sens.HORIZONTAL) {
						alignements.add(hAlign);
					}
				}
			}
		}
		
		// On a notre liste d'alignements, on n'a plus qu'a la parcourir pour set les Candy a supprimer
		if(!alignements.isEmpty()) {
			for(Alignment al:alignements) {
				deleteCandiesInAlignment(al);
			}
		}
	}
	
	/**
	*	Marquer les bonbons à supprimer d'un alignement
	*	@param al Alignement à parcourir
	*/
	protected void deleteCandiesInAlignment(Alignment al) {
		if(al.orientation.equals(Sens.VERTICAL)) {
			int x = al.getStart().getCol();
			int yStart = al.getStart().getRow();
			int length = al.getLength();
			// Check if alignment contains 3 Candys or more
			if(length >= 2) {
				for(int i = 0; i <= length; ++i) {
					grid[yStart+i][x].setASupprimer(true);
				}
			}
		}
		else if(al.orientation.equals(Sens.HORIZONTAL)) {
			int y = al.getStart().getRow();
			int xStart = al.getStart().getCol();
			int length = al.getLength();
			// Check if alignment contains 3 Candys or more
			if(length >= 2) {
				for(int i = 0; i <= length; ++i) {
					grid[y][xStart+i].setASupprimer(true);
				}
			}
		}
	}
	
	/**
	*	Détecter un alignement vertical à partir d'un bonbon
	*	@param c Bonbon à analyser
	*	@return Objet de type Alignment
	*/
	protected Alignment detectVerticalAlignment(Candy c) {
		// Alignement resultat
		Alignment verticalAlignment = new Alignment(c,c);
		Candy currentCandy = new Candy(c);
		for(int k=0; c.getRow()+k+1 < this.getHeight();) {
			++k;
			currentCandy = grid[c.getRow()+k][c.getCol()];
			if(c.getColor() == currentCandy.getColor()) {
				verticalAlignment.setEnd(currentCandy);
				verticalAlignment.orientation = Sens.VERTICAL;
			}
			else {
				return verticalAlignment;
			}
		}
		return verticalAlignment;
	}
	
	/**
	*	Détecter un alignement horizontal à partir d'un bonbon
	*	@param c Bonbon à analyser
	*	@return Objet de type Alignment
	*/
	protected Alignment detectHorizontalAlignment(Candy c) {
		// Alignement resultat
		Alignment horizontalAlignment = new Alignment(c,c);
		Candy currentCandy = new Candy(c);
		for(int k=0; c.getCol()+k+1 < this.getWidth();) {
			++k;
			currentCandy = grid[c.getRow()][c.getCol()+k];
			if(c.getColor() == currentCandy.getColor()) {
				horizontalAlignment.setEnd(currentCandy);
				horizontalAlignment.orientation = Sens.HORIZONTAL;
			}
			else {
				return horizontalAlignment;
			}
		}
		return horizontalAlignment;
	}
	
	/**
	 *	Méthode non commentée
	 */
	public void compacter(){
		int x,y;
		for(y=this.getWidth()-1; y>=0; y--) {
			for(x=this.getHeight()-1; x>=0; x--) {

				if((this.getCandy(x,y).getColor()==0) && (x!=0)){
					int i=x;
					while(i!=0) {
						/* deplacement si la case reste dans l'ecran */
						this.getCandy(i,y).setColor(this.getCandy(i-1,y).getColor());
						i--;
					}

					if(i==0) {
						this.getCandy(i,y).setRandomColor();
					}

					this.getCandy(x,y).setASupprimer(false);

				}

				else if((this.getCandy(x,y).getColor()==0) && (x==0)) {
					/* remplacement aleatoire si la case n'etait pas dans l'ecran */
					this.getCandy(x,y).setRandomColor();
					this.getCandy(x,y).setASupprimer(false);
				}
			}
		}
	}

	/**
	 *	Méthode non commentée
	 */
	public void eclater(){
		int x,y;
		for(y=0; y<this.getWidth(); y++) {
			for(x=0; x<this.getHeight(); x++) {
				if(this.getCandy(x,y).getASupprimer()==true) {
					/* si le critere de suppression est verifie, contenu devient "vide" */
					this.getCandy(x,y).setColor(0);
				}
			}
		}
		this.compacter();
	}

}
