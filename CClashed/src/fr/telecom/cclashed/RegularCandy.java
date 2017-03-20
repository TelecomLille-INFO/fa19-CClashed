package fr.telecom.cclashed;

/**
 * La classe RegularCandy représente un bonbon classique, elle hérite de la classe Candy
 * @author TeamCClashed
 * 
 */
public class RegularCandy extends Candy {

	/**
	 * Constructeur de bonbon classique prenant en paramètres la couleur, la ligne et la colonne
	 * @param color Couleur
	 * @param row Ligne
	 * @param col Colonne
	 */
	public RegularCandy(int color, int row, int col) {
		/* On utilise le constructeur de la classe mère */
		super(color, row, col);		
	}
	
	/**
	 * Constructeur par copie de bonbon classique
	 * @param c Bonbon classique depuis lequel on se base
	 */
	public RegularCandy(RegularCandy c) {
		super(c);
	}

}
