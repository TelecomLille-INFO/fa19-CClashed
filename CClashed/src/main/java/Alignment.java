package main.java;
import java.util.ArrayList;
import java.util.List;


public class Alignment {
	
	protected Candy start;
	protected Candy end;
	public Sens orientation=Sens.NONE;
	
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

	/* Fonction qui cr�e une liste des alignements � un instant T
	 * 
	 * Cette liste sera comparee a la liste precedente qfin de detecter si de nouveaux alignements ont ete generes
	 * Les nouveaux alignements correspondront a ceu generes par le deplacement d'un bonbon
	 * Nous pourrons l'utiliser autant de fois que necessaire pendant un tour
	 *
	 *  @param Un objet board
	 *  @return Une ArrayList d'objets Alignment
	 * */
	/*static List<Alignment> newAlignmentDetection (Board board){ 
    
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
                    if(a.isWithinAnother(alignmentList)==false){
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
                    if(a.isWithinAnother(alignmentList)==false){ //si l'alignement ne fait pas partie d'un alignement plus grand on l'ajoute � la liste
                    	alignmentList.add(a);
                    }
                   
                }
 
            }
        }
        
        }
		return alignmentList;
    }*/
	
	/*Fonction qui detecte si un alignement fait partie d'un alignement plus grand
	 * 
	 * @param une ArrayList d'Alignment
	 * @return true or false
	 * */
	public boolean isWithinAnother(List<Alignment> alignmentList){
		
		boolean res = false;
		for (Alignment al:alignmentList){
			if(this.orientation==Sens.HORIZONTAL){
				if(al.orientation==Sens.HORIZONTAL && this.start.getCol()>=al.start.getCol() && this.end.getCol()<=al.end.getCol() && this.start.getRow()==al.start.getRow() && this.end.getRow()==al.end.getRow()){
					res = true;
				}
							
			}
			if(this.orientation==Sens.VERTICAL){
				if(al.orientation==Sens.VERTICAL && this.start.getRow()>=al.start.getRow() && this.end.getRow()<=al.end.getRow() && this.start.getCol()==al.start.getCol() && this.end.getCol()==al.end.getCol()){
					res = true;
				}
			}
		}
		return res;
	}

		
	
}