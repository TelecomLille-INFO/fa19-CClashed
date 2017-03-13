package main.java;

public class Main {

	public static void main(String[] args) {
		//Si vous voulez faire des tests à l'arrache, faites les ici !

		Board plateau = new Board();
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				Candy c = new Candy(i,j);
				plateau.addCandy(c);
			}
		}	
		
		
		for(int j = 2; j<5;++j){
			Candy c = new Candy(3,3,j);
			plateau.addCandy(c);
		}
		
		System.out.println(plateau);
		
		do{
			plateau.newAlignmentDetection2();
			plateau.eclater();
			System.out.println(plateau);
		}while(plateau.checkTurnHasEnded()!=true);
		
		/*System.out.println("Ajout Candy rouge en 2/4\n");
		Candy redCandy = new Candy(4,2,4);
		plateau.addCandy(redCandy);
		System.out.println(plateau);*/
		
		
	}
}
