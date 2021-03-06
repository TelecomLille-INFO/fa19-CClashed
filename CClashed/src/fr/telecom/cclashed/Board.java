package fr.telecom.cclashed;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Board représente le plateau de jeu
 * @author TeamCClashed
 * 
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
	 * Constructeur par défaut de plateau
	 */
	public Board() {
		this.height = 8;
		this.width = 8;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
		resetBoard();
	}
	
	/**
	 * Constructeur de plateau prenant en paramètres la hauteur et la largeur du plateau
	 * @param height Entier représentant la hauteur du plateau
	 * @param width Entier représentant la largeur du plateau
	 */
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
		resetBoard();
	}
	
	/**
	 * Méthode permettant de réinitialiser le plateau
	 */
	protected void resetBoard() {
		for(int i=0; i<this.getHeight();++i) {
			for(int j=0; j<this.getWidth();++j) {
				Candy c = new Candy(i,j);
				this.addCandy(c);
			}
		}	
	}
	
	/**
	 * Accesseur
	 * @return Entier représentant la hauteur du plateau de jeu
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Mutateur
	 * @param height Entier représentant la hauteur du plateau de jeu
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Accesseur
	 * @return Entier représentant la largeur du plateau de jeu
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Mutateur
	 * @param width Entier représentant la largeur du plateau de jeu
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Ajouter un bonbon généré aléatoirement en une case donnée du plateau de jeu
	 * @param row Entier représentant le numéro de ligne
	 * @param col Entier représentant le numéro de colonne
	 */
	public void addCandy(int row, int col) {
		Candy bonbon = new Candy(row,col);
		grid[row][col] = bonbon;
	}

	/**
	 * Ajouter un bonbon précis sur le plateau de jeu
	 * @param bonbon Candy à ajouter
	 */
	public void addCandy(Candy bonbon) {
		grid[bonbon.getRow()][bonbon.getCol()] = bonbon;
	}

	/**
	 * Récupérer un bonbon situé sur une case donnée du plateau de jeu
	 * @param row Entier représentant le numéro de ligne
	 * @param col Entier représentant le numéro de colonne
	 * @return Bonbon situé aux coordonnées passées en paramètres
	 */
	public Candy getCandy(int row, int col) {
		return grid[row][col];
	}

	/**
	 * Vérifier si le tour de jeu est terminé
	 * @return True si le tour de jeu est terminé, false sinon
	 */
	public boolean checkTurnHasEnded() {
		return detectAllAlignments().isEmpty();
	}

	/**
	 * Vérifier si un mouvement est possible sur le plateau de jeu
	 * @param m Mouvement dont on veut vérifier la possibilité
	 * @return True si le mouvement est possible, false sinon
	 */
	public boolean checkMove(Move m) {
		/* On effectue le mouvement de manière temporaire sur le plateau */
		this.executeMove(m);
		
		if (this.detectAllAlignments().isEmpty()) {
			this.reverseMove(m);
			return false;
		}
		
		else {
			this.reverseMove(m);
			return true;
		}
	}

	/**
	 * Chercher les mouvements possibles sur le plateau de jeu
	 */
	public void findPossibleMoves(){
		possibleMoves.clear();
		int x,y;
		Move moveBottom;
		Move moveRight;
		
		for(y=0; y<this.getWidth(); y++) {
			for(x=0; x<this.getHeight(); x++) {
				
				/* Cases situées sur la dernière colonne */
				if ((y == this.getWidth()-1) && (x != this.getHeight()-1)) {
					moveBottom = new Move(this.getCandy(x,y),this.getCandy(x+1,y));
					if (checkMove(moveBottom)) {
						possibleMoves.add(moveBottom);
					}
				}
				
				/* Cases situées sur la dernière ligne */
				else if ((y != this.getWidth()-1) && (x == this.getHeight()-1)) {
					moveRight = new Move(this.getCandy(x,y),this.getCandy(x,y+1));
					if (checkMove(moveRight)) {
						possibleMoves.add(moveRight);
					}
				}
				
				/* Autres cases sauf celle situé en coin inférieur droit */
				else if ((y != this.getWidth()-1) && (x != this.getHeight()-1)) {
					moveBottom = new Move(this.getCandy(x,y),this.getCandy(x+1,y));
					if (checkMove(moveBottom)) {
						possibleMoves.add(moveBottom);
					}
					moveRight = new Move(this.getCandy(x,y),this.getCandy(x,y+1));
					if (checkMove(moveRight)) {
						possibleMoves.add(moveRight);
					}
				}
				
			}
		}

	}

	/**
	 * Effectuer un mouvement sur le plateau de jeu
	 * @param m Mouvement à effectuer
	 */
	public void executeMove(Move m) {
		this.getCandy(m.getCandy1().getRow(), m.getCandy1().getCol()).setColor(m.getCandy2().getColor());
		this.getCandy(m.getCandy2().getRow(), m.getCandy2().getCol()).setColor(m.getCandy1().getColor());
	}
	
	/**
	 * Annuler un mouvement sur le plateau de jeu
	 * @param m Mouvement à annuler
	 */
	public void reverseMove(Move m) {
		this.getCandy(m.getCandy1().getRow(), m.getCandy1().getCol()).setColor(m.getCandy1().getColor());
		this.getCandy(m.getCandy2().getRow(), m.getCandy2().getCol()).setColor(m.getCandy2().getColor());
	}

	/**
	 * Vérifier la condition d'arrêt de partie
	 * @return True si la partie est terminée, false sinon
	 */
	public Boolean checkGameHasEnded() {
		this.findPossibleMoves();
		return possibleMoves.isEmpty();
	}

	/**
	 * Afficher l'état d'un plateau de jeu
	 * @return Chaîne de caractères représentant l'état d'un plateau de jeu
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
	 * Méthode permettant de détecter les alignements
	 * @return Liste des alignements détectés
	 */
	public List<Alignment> detectAllAlignments() {
		//Liste des alignements à remplir
		List<Alignment> alignements = new ArrayList<Alignment>();
		
		//Parcours vertical
		for(int i=0; i<this.getHeight(); ++i) {
			//Parcours horizontal
			for(int j=0; j<this.getWidth();++j) {
				Candy currentCandy = grid[i][j];
				// On check si le bonbon est déjà dans un alignement vertical
				if(!currentCandy.isWithinAlignment(Sens.VERTICAL, alignements)) {
					// Si non on détecte les éventuels alignements
					Alignment vAlign = detectAlignment(currentCandy, Sens.VERTICAL);
					if(vAlign.orientation == Sens.VERTICAL && vAlign.getLength() >= 3) {
						alignements.add(vAlign);
					}
				}
				// On check si le bonbon est déjà dans un alignement horizontal
				if(!currentCandy.isWithinAlignment(Sens.HORIZONTAL, alignements)) {
					// Si non on détecte les éventuels alignements
					Alignment hAlign = detectAlignment(currentCandy, Sens.HORIZONTAL);
					if(hAlign.orientation == Sens.HORIZONTAL && hAlign.getLength() >= 3) {
						alignements.add(hAlign);
					}
				}
			}
		}
		return alignements;
	}
	
	/**
	 * Méthode qui attribue la couleur 'EMPTY' aux bonbons faisant partie d'alignements de longueur supérieure ou égale à 3
	 * @param aligns Alignements à parcourir
	 */
	public void deleteCandiesInAlignments(List<Alignment> aligns) {
		for(Alignment al:aligns) {
			if(al.orientation.equals(Sens.VERTICAL)) {
				int x = al.getStart().getCol();
				int yStart = al.getStart().getRow();
				int length = al.getLength();
				for(int i = 0; i <= length - 1; ++i) {
					grid[yStart+i][x].setColor(Candy.EMPTY);
				}
			}
			else if(al.orientation.equals(Sens.HORIZONTAL)) {
				int y = al.getStart().getRow();
				int xStart = al.getStart().getCol();
				int length = al.getLength();
				for(int i = 0; i <= length - 1; ++i) {
					grid[y][xStart+i].setColor(Candy.EMPTY);
				}
			}
		}
	}
	
	/**
	 * Détecter un alignement à partir d'un bonbon
	 * @param c Bonbon à analyser
	 * @param orientation Orientation de l'alignement
	 * @return Objet de type Alignment
	 */
	protected Alignment detectAlignment(Candy c, Sens orientation) {
		// Alignement resultat
		Alignment alignment = new Alignment(c,c);
		Candy currentCandy = new Candy(c);
		
		if (orientation == Sens.HORIZONTAL) {
			for(int k=0 ; c.getCol()+k+1 < this.getWidth();) {
				++k;
				currentCandy = grid[c.getRow()][c.getCol()+k];
				if(c.getColor() == currentCandy.getColor()) {
					alignment.orientation = Sens.HORIZONTAL;
					alignment.setEnd(currentCandy);
				}
				else {
					return alignment;
				}
			}
		}
		
		else if (orientation == Sens.VERTICAL) {
			for(int k=0; c.getRow()+k+1 < this.getHeight();) {
				++k;
				currentCandy = grid[c.getRow()+k][c.getCol()];
				if(c.getColor() == currentCandy.getColor()) {
					alignment.orientation = Sens.VERTICAL;
					alignment.setEnd(currentCandy);
				}
				else {
					return alignment;
				}
			}
		}
		
		return alignment;
	}
	
	/**
	 *	Méthode qui parcourt le plateau de jeu afin de faire jouer la gravité
	 */
	public void compacter() {
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

				}

				else if((this.getCandy(x,y).getColor()==0) && (x==0)) {
					/* remplacement aleatoire si la case n'etait pas dans l'ecran */
					this.getCandy(x,y).setRandomColor();
				}
				
			}
		}
	}

	/**
	 *	Méthode qui parcourt le plateau de jeu, et attribue une couleur vide aux bonbons à supprimer
	 */
	public void eclater() {
		int x,y;
		for(y=0; y<this.getWidth(); y++) {
			for(x=0; x<this.getHeight(); x++) {
				if(this.getCandy(x,y).getColor() == 0) {
					this.compacter();
				}
			}
		}
	}

}
