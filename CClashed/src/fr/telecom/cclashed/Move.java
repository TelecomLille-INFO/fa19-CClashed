package fr.telecom.cclashed;

/**
 * La classe Move représente un mouvement, c'est-à-dire un switch possible entre deux bonbons
 * @author TeamCClashed
 * 
 */
public class Move {

	/** Représente le premier bonbon du mouvement */
	private Candy candy1;
	/** Représente le second bonbon du mouvement */
	private Candy candy2;
	
	/**
	 * Constructeur de mouvement prenant en paramètres deux bonbons
	 * @param candy1 Premier bonbon
	 * @param candy2 Second bonbon
	 */
	public Move(Candy candy1, Candy candy2) {
		this.candy1 = new Candy(candy1);
		this.candy2 = new Candy(candy2);
	}
	
	/**
	 * Accesseur
	 * @return Premier bonbon associé au mouvement
	 */
	public Candy getCandy1() {	
		return candy1;
	}
	
	/**
	 * Accesseur
	 * @return Second bonbon associé au mouvement
	 */
	public Candy getCandy2() {	
		return candy2;
	}
	
	/**
	 * Constructeur par copie
	 * @param m Mouvement depuis lequel on se base
	 */
	public Move(Move m) {
		this.candy1 = new Candy(m.candy1);
		this.candy2 = new Candy(m.candy2);
	}
	
	/**
	 * Tester l'égalité de deux mouvements
	 * @param m Mouvement dont on veut tester l'égalité avec l'instance courante
	 * @return True si les deux mouvements sont égaux, false sinon
	 */
	public boolean isEqual(Move m) {
		/* On fait appel à la méthode equals de la classe Candy */
		if ((this.candy1.equals(m.candy1)) && (this.candy2.equals(m.candy2))) {
			return true;
		}
		else if ((this.candy1.equals(m.candy2)) && (this.candy2.equals(m.candy1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Afficher l'état d'un mouvement
	 * @return Chaîne de caractères représentant l'état d'un mouvement
	 */
	public String toString() {
		return "/----------\n| Affichage du mouvement :\n|\n|  [" + candy1.getRow() + "][" + candy1.getCol() + "] <---> [" + candy2.getRow() + "][" + candy2.getCol() + "]\n|\n----------/";
	}

}
