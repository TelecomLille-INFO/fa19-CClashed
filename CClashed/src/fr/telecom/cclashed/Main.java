package fr.telecom.cclashed;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Si vous voulez faire des tests à l'arrache, faites les ici !

		Board plateau = new Board();
		
		/*for(int j = 2; j<5;++j){
			Candy c = new Candy(3,3,j);
			plateau.addCandy(c);
		}*/
		//do{
			System.out.println(plateau);
			List<Alignment> currentAlignments = plateau.detectAlignments();
			for(Alignment al:currentAlignments)
			{
				System.out.println(al);
			}
			plateau.deleteCandiesInAlignments(currentAlignments);
			plateau.eclater();
		//}while(!plateau.checkTurnHasEnded());
	
		System.out.println(plateau);
		
		/*System.out.println("Ajout Candy rouge en 2/4\n");
		Candy redCandy = new Candy(4,2,4);
		plateau.addCandy(redCandy);
		System.out.println(plateau);*/
		
		
	}
}
