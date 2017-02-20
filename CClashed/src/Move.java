/**
	La classe Move représente un mouvement, c'est-à-dire un switch possible entre deux bonbons
*/
public class Move {

	/** Représente le premier bonbon du mouvement */
	private Candy candy1;
	/** Représente le second bonbon du mouvement */
	private Candy candy2;
	
	/**
		Constructeur de mouvement prenant en paramètres deux bonbons
		@param candy1 Premier bonbon
		@param candy2 Second bonbon
	*/
	public Move(Candy candy1, Candy candy2) {
		this.candy1 = new Candy(candy1);
		this.candy2 = new Candy(candy2);
	}
	
	/**
		Constructeur par copie
		@param m Mouvement depuis lequel on se base
	*/
	public Move(Move m) {
		this.candy1 = new Candy(m.candy1);
		this.candy2 = new Candy(m.candy2);
	}
	
	/**
		Tester l'égalité entre deux mouvements
		@param m Mouvement dont on veut tester l'égalité avec l'instance courante
		@return True si les deux mouvements sont égaux, false sinon
	*/
	public boolean equals(Move m) {
		/* On fait appel à la méthode equals de la classe Candy */
		if ((this.candy1.equals(m.candy1)) && (this.candy2.equals(m.candy2))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
		Afficher l'état d'un mouvement
	*/
	public String toString() {
		System.out.println("/----------\n| Affichage du mouvement :\n|");
		System.out.println("|  [" + candy1.getRow() + "][" + candy1.getCol() + "] <---> [" + candy2.getRow() + "][" + candy2.getCol() + "]\n|");
		System.out.println("----------/");
	}

}
