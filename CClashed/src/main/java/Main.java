package main.java;

public class Main {

	public static void main(String[] args) {
		//Si vous voulez faire des tests à l'arrache, faites les ici !

		Board plateau = new Board();
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				plateau.addCandy(i, j);
			}
		}	
		System.out.println(plateau);
		
		System.out.println("Ajout Candy rouge en 2/4\n");
		Candy redCandy = new Candy(4,2,4);
		plateau.addCandy(redCandy);
		System.out.println(plateau);
	}
}
