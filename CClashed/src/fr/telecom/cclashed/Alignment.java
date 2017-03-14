package fr.telecom.cclashed;

/**
*	La classe Alignment n'est pas commentée
*/
public class Alignment {
	
	protected Candy start;
	protected Candy end;
	private int length;
	public Sens orientation=Sens.NONE;
	
	public Alignment(){
		length = 0;
	}
	
	public Alignment(Candy candyStart, Candy candyEnd){
		this.start=candyStart;
		this.end=candyEnd;
		length = 0;
	}
	
	public Alignment(Candy candyStart, Candy candyEnd, Sens orientation){
		this.start=candyStart;
		this.end=candyEnd;
		this.orientation = orientation;
		calculateLength();
	}
	
	private void calculateLength()
	{
		if(orientation == Sens.VERTICAL)
		{
			length = end.getRow() - start.getRow();
		}
		else if(orientation == Sens.HORIZONTAL)
		{
			length = end.getCol() - start.getCol();
		}
	}
	
	public int getLength()
	{
		return length;
	}
	
	public Candy getStart() {
		return start;
	}

	public void setStart(Candy start) {
		this.start = start;
		calculateLength();
	}

	public Candy getEnd() {
		return end;
	}

	public void setEnd(Candy end) {
		this.end = end;
		calculateLength();
	}
}
