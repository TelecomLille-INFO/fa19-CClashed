package main.java;
import java.util.ArrayList;
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
	private List<Move> possibleMoves;

	/**
		Constructeur de plateau
	 */
	public Board() {
		this.height = 8;
		this.width = 8;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
		/* A voir comment on initialise le tableau et la liste */
	}

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		grid = new Candy[height][width];
		possibleMoves = new ArrayList<Move>();
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
	 * Chercher moves possibles sur le plateau de jeu
	 */
	public void findPossibleMoves(){
		possibleMoves.clear();
		//TODO
	}

	/**
	 *	Effectuer un mouvement sur le plateau de jeu
	 *	@param m Mouvement a effectuer
	 */
	public void executeMove(Move m) {
		System.out.println("Appel de la methode executeMove(Move m) de la classe Board");
	}

	/**
	 * Verifier condition d'arret de partie
	 * @return Booleen indiquant si la partie est terminee
	 */
	public Boolean checkGameHasEnded()
	{
		return possibleMoves.isEmpty();
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
	
	public void newAlignmentDetection2(){
		//Liste des alignements à remplir
		List<Alignment> alignements = new ArrayList<Alignment>();
		
		//Parcours vertical
		for(int i = 0; i<this.getHeight(); ++i)
		{
			//Parcours horizontal
			for(int j = 0; j<this.getWidth();++j)
			{
				Candy currentCandy = grid[i][j];
				// On checke si le Candy est deja dans un alignement vertical...
				if(!currentCandy.isWithinAlignment(Sens.VERTICAL, alignements))
				{
					// Si non on detecte les eventuels alignements
					Alignment vAlign = detectVerticalAlignment(currentCandy);
					if(vAlign.orientation == Sens.VERTICAL)
					{
						alignements.add(vAlign);
					}
				}
				// ... ou horizontal
				else if(!currentCandy.isWithinAlignment(Sens.HORIZONTAL, alignements))
				{
					// Si non on detecte les eventuels alignements
					Alignment hAlign = detectHorizontalAlignment(currentCandy);
					if(hAlign.orientation == Sens.HORIZONTAL)
					{
						alignements.add(hAlign);
					}
				}
			}
		}
		
		// On a notre liste d'alignements, on n'a plus qu'a la parcourir pour set les Candy a supprimer
		if(!alignements.isEmpty())
		{
			for(Alignment al:alignements)
			{
				deleteCandysInAlignment(al);
			}
		}
	}
	
	/**
	 *	Marquer les Candys a supprimer d'un alignement
	 *	@param Alignement a parcourir
	 */
	protected void deleteCandysInAlignment(Alignment al)
	{
		if(al.orientation.equals(Sens.VERTICAL))
		{
			int x = al.getStart().getCol();
			int yStart = al.getStart().getRow();
			int yEnd = al.getEnd().getRow();
			for(int i = 0; i <= yEnd-yStart; ++i)
			{
				grid[yStart+i][x].setaSupprimer(true);
			}
		}
		else if(al.orientation.equals(Sens.HORIZONTAL))
		{
			int y = al.getStart().getRow();
			int xStart = al.getStart().getCol();
			int xEnd = al.getEnd().getCol();
			for(int i = 0; i <= xEnd-xStart; ++i)
			{
				grid[y][xStart+i].setaSupprimer(true);
			}
		}
	}
	
	/**
	 *	Detecter un alignement vertical a partir d'un Candy
	 *	@param Candy a analyser
	 *	@return Alignment resultat
	 */
	protected Alignment detectVerticalAlignment(Candy c)
	{
		// Alignement resultat
		Alignment verticalAlignment = new Alignment(c,c);
		Candy currentCandy = new Candy(c);
		for(int k = 0; c.getRow()+k+1 < this.getHeight();)
		{
			++k;
			currentCandy = grid[c.getRow()+k][c.getCol()];
			if(c.getColor() == currentCandy.getColor())
			{
				verticalAlignment.setEnd(currentCandy);
				verticalAlignment.orientation = Sens.VERTICAL;
			}
			else
				return verticalAlignment;
		}
		return verticalAlignment;
	}
	
	/**
	 *	Detecter un alignement horizontal a partir d'un Candy
	 *	@param Candy a analyser
	 *	@return Alignment resultat
	 */
	protected Alignment detectHorizontalAlignment(Candy c)
	{
		// Alignement resultat
		Alignment horizontalAlignment = new Alignment(c,c);
		Candy currentCandy = new Candy(c);
		for(int k = 0; c.getCol()+k+1 < this.getWidth();)
		{
			++k;
			currentCandy = grid[c.getRow()][c.getCol()+k];
			if(c.getColor() == currentCandy.getColor())
			{
				horizontalAlignment.setEnd(currentCandy);
				horizontalAlignment.orientation = Sens.HORIZONTAL;
			}
			else
				return horizontalAlignment;
		}
		return horizontalAlignment;
	}

	public void newAlignmentDetection (){ 

		int k;

		for (int j=0 ; j<this.getWidth(); j++)
		{
			for(int i=0 ; i<this.getHeight(); i++)
			{
				k=1;

				while(i+k<this.getHeight() && this.grid[i][j].color == this.grid[i+k][j].color) // Tant que la case qui suit i est du meme type on continue (alignement horizontal)
				{
					k = k+1; //
				}

				if(k>=2) // Si k est superieur ou egal a  2 alors il y a un alignement
				{

					int cpt=i;
					while(i+k>=i){
						if(this.grid[i+k][j].isaSupprimer()==false){
							this.grid[i+k][j].setaSupprimer(true);

						}
						k--;
					}


				}

				k=1;

				while(j+k<this.getWidth() && this.grid[i][j].color == this.grid[i][j+k].color)  // Tant que la case qui suit i est du meme type on continue (alignement vertical)
				{
					k = k+1;
				}

				if(k>=2)// Si k est superieur ou egal a  2 alors il y a un alignement
				{


					while(j+k>=j){
						if(this.grid[i][j+k].isaSupprimer()==false){
							this.grid[i][j+k].setaSupprimer(true);

						}
						k--;
					}
				}


			}

		}

	}

}
