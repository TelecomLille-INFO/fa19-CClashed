package main.java;
import java.util.ArrayList;
import java.util.List;


public class Alignment {
	
	protected Candy start;
	protected Candy end;
	protected Sens orientation=Sens.NONE;
	
	public Alignment(){}
	
	public Alignment(Candy candyStart, Candy candyEnd){
		this.start=candyStart;
		this.end=candyEnd;
	}
	
	
	public Candy getStart() {
		return start;
	}

	public void setStart(Candy start) {
		this.start = start;
	}

	public Candy getEnd() {
		return end;
	}

	public void setEnd(Candy end) {
		this.end = end;
	}

	/* Fonction qui crée une liste des alignements à un instant T
	 * 
	 * Cette liste sera comparee a la liste precedente qfin de detecter si de nouveaux alignements ont ete generes
	 * Les nouveaux alignements correspondront a ceu generes par le deplacement d'un bonbon
	 * Nous pourrons l'utiliser autant de fois que necessaire pendant un tour
	 *
	 *  @param Un objet board
	 *  @return Une ArrayList d'objets Alignment
	 * */
	static List<Alignment> newAlignmentDetection (Board board){ 
    
		List<Alignment> alignmentList = new ArrayList<Alignment>();
        int k;
        
        for (int i=0 ; i<board.getHeight(); i++)
        {
            for(int j=0 ; j<board.getWidth(); j++)
            {
                k=1;
 
                while(i+k<board.getWidth() && board.grid[i][j].color == board.grid[i+k][j].color) // Tant que la case qui suit i est du meme type on continue (alignement horizontal)
                {
                    k = k+1; //
                }
 
                if(k>2) // Si k est superieur a  2 alors il y a un alignement
                {
                    Alignment a = new Alignment();
                    a.orientation=Sens.HORIZONTAL;
                    a.start=board.grid[i][j];
                    a.end=board.grid[i+k][j];
                    if(isWithinAnother(a,alignmentList)==false){
                    	alignmentList.add(a);
                    }
                }
 
                k=1;
                while(j+k<board.getHeight() && board.grid[i][j].color == board.grid[i][j+k].color)  // Tant que la case qui suit i est du meme type on continue (alignement vertical)
                {
                {
                    k = k+1;// Si k est superieur a  2 alors il y a un alignement
                }
 
                if(k>2)
                {
                	Alignment a = new Alignment();
                	a.orientation=Sens.VERTICAL;
                    a.start=board.grid[i][j];
                    a.end=board.grid[i][j+k];
                    if(isWithinAnother(a,alignmentList)==false){ //si l'alignement ne fait pas partie d'un alignement plus grand on l'ajoute à la liste
                    	alignmentList.add(a);
                    }
                   
                }
 
            }
        }
        
        }
		return alignmentList;
    }
	
	/*Fonction qui detecte si un alignement fait partie d'un alignement plus grand
	 * 
	 * @param Un objet Alignment et une ArrayList d'Alignment
	 * @return true or false
	 * */
	public static boolean isWithinAnother(Alignment a , List<Alignment> alignmentList){
		
		boolean res = false;
		for (Alignment al:alignmentList){
			if(a.orientation==al.orientation){
				if(a.start.col>=al.start.col && a.end.col<=al.start.col && a.start.row==al.start.row && a.end.row==al.end.row){
					res = true;
				}
				if(a.start.row>=al.start.row && a.end.row<=al.start.row && a.start.col==al.start.col && a.end.col==al.end.col){
					res = true;
				}
					
			};
		}
		return res;
	}

}
