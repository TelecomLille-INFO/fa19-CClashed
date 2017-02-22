package main.java;
/**
	La classe Move represente un mouvement, c'est-a-dire un switch possible entre deux bonbons
*/
public class Move {

	/** Represente le premier bonbon du mouvement */
	private Candy candy1;
	/** Represente le second bonbon du mouvement */
	private Candy candy2;
	
	/**
	*	Constructeur de mouvement prenant en parametres deux bonbons
	*	@param candy1 Premier bonbon
	*	@param candy2 Second bonbon
	*/
	public Move(Candy candy1, Candy candy2) {
		this.candy1 = new Candy(candy1);
		this.candy2 = new Candy(candy2);
	}
	
	/**
	*	Accesseur
	*	@return Premier bonbon associe au mouvement
	*/
	public Candy getCandy1()
	{	
		return candy1;
	}
	
	/**
	*	Accesseur
	*	@return Second bonbon associe au mouvement
	*/
	public Candy getCandy2()
	{	
		return candy2;
	}
	
	/**
	*	Constructeur par copie
	*	@param m Mouvement depuis lequel on se base
	*/
	public Move(Move m) {
		this.candy1 = new Candy(m.candy1);
		this.candy2 = new Candy(m.candy2);
	}
	
	/**
	*	Tester l'egalite entre deux mouvements
	*	@param m Mouvement dont on veut tester l'egalite avec l'instance courante
	*	@return True si les deux mouvements sont egaux, false sinon
	*/
	public boolean equals(Move m) {
		/* On fait appel a la methode equals de la classe Candy */
		if ((this.candy1.equals(m.candy1)) && (this.candy2.equals(m.candy2))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	*	Afficher l'etat d'un mouvement
	*	@return Chaine de caracteres representant l'etat d'un mouvement
	*/
	public String toString() {
		return "/----------\n| Affichage du mouvement :\n|\n|  [" + candy1.getRow() + "][" + candy1.getCol() + "] <---> [" + candy2.getRow() + "][" + candy2.getCol() + "]\n|\n----------/";
	}

}
