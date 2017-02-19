/**
	La classe Candy représente un bonbon sous sa forme la plus abstraite.
*/
public class Candy {

	/** Représente la couleur d'un bonbon. */
	protected int color;
	/** Représente le numéro de ligne d'un bonbon sur le plateau de jeu. */
	protected int row;
	/** Représente le numéro de colonne d'un bonbon sur le plateau de jeu. */
	protected int col;
	
	/**
		Constructeur de bonbon prenant en paramètres la couleur, la ligne et la colonne.
		@param color Couleur.
		@param row Ligne.
		@param col Colonne.
	*/
	public Candy(int color, int row, int col) {
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	/**
		Constructeur par copie.
		@param c Bonbon depuis lequel on se base.
	*/
	public Candy(Candy c) {
		this.color = c.color;
		this.row = c.row;
		this.col = c.col;
	}
	
	/**
		Tester l'égalité entre deux bonbons.
		@param c Bonbon dont on veut tester l'égalité avec l'instance courante.
		@return True si les deux bonbons sont égaux, false sinon.
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
		Afficher l'état d'un bonbon.
	*/
	public String toString() {
		System.out.println("/----------\n| Affichage du bonbon :\n|\n| Id couleur = " + color + "\n| N° ligne  = " + row + "\n| N° colonne = " + col + "\n|\n----------/");
	}

}
