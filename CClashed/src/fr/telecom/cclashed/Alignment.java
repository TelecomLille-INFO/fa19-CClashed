package fr.telecom.cclashed;

/**
 * La classe Alignment représente un alignement de bonbons
 * @author TeamCClashed
 */
public class Alignment {
	
	/** Représente le premier bonbon de l'alignement */
	protected Candy start;
	/** Représente le dernier bonbon de l'alignement */
	protected Candy end;
	/** Représente la longueur de l'alignement */
	private int length;
	/** Représente l'orientation de l'alignement */
	public Sens orientation=Sens.NONE;
	
	/**
	 * Constructeur par défaut d'Alignement.
	 */
	public Alignment() {
		this.length = 0;
	}
	
	/**
	 * Constructeur d'Alignement prenant en paramètres le premier et le dernier bonbon
	 * @param candyStart Premier bonbon de l'alignement
	 * @param candyEnd Dernier bonbon de l'alignement
	 */
	public Alignment(Candy candyStart, Candy candyEnd) {
		this.start = candyStart;
		this.end = candyEnd;
		this.length = 0;
	}
	
	/**
	 * Constructeur d'Alignement prenant en paramètres le premier bonbon, le dernier bonbon et l'orientation
	 * @param candyStart Premier bonbon de l'alignement
	 * @param candyEnd Dernier bonbon de l'alignement
	 * @param orientation Orientation de l'alignement
	 */
	public Alignment(Candy candyStart, Candy candyEnd, Sens orientation) {
		this.start = candyStart;
		this.end = candyEnd;
		this.orientation = orientation;
		calculateLength();
	}
	
	/**
	 * Méthode permettant le calcul de la longueur de l'alignement courant
	 */
	private void calculateLength() {
		if(orientation == Sens.VERTICAL) {
			this.length = (this.end.getRow() - this.start.getRow()) + 1;
		}
		else if(orientation == Sens.HORIZONTAL)	{
			this.length = (this.end.getCol() - this.start.getCol()) + 1;
		}
		else {
			this.length = 0;
		}
	}
	
	/**
	 * Accesseur
	 * @return Entier représentant la longueur de l'alignement
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Accesseur
	 * @return Premier bonbon de l'alignement
	 */
	public Candy getStart() {
		return start;
	}

	/**
	 * Mutateur
	 * @param start Candy représentant le premier bonbon de l'alignement
	 */
	public void setStart(Candy start) {
		this.start = start;
		calculateLength();
	}

	/**
	 * Accesseur
	 * @return Dernier bonbon de l'alignement
	 */
	public Candy getEnd() {
		return end;
	}

	/**
	 * Mutateur
	 * @param end Candy représentant le dernier bonbon de l'alignement
	 */
	public void setEnd(Candy end) {
		this.end = end;
		calculateLength();
	}
	
	/**
	 * Afficher l'état d'un alignement
	 * @return Chaîne de caractères représentant l'état d'un alignement
	 */
	public String toString() {
		String res = "Alignement : C1["+ this.start.getCol() + "," + this.start.getRow() + "] <--> C2[" + this.end.getCol() + "," + this.end.getRow()+ "] | L:" + this.length + " | O:" + this.orientation + "\n";
		return res;
	}
}
