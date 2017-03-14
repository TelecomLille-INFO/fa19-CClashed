package fr.telecom.cclashed;

public class Main {

	public static void main(String[] args) {
		//Si vous voulez faire des tests à l'arrache, faites les ici !

		Board plateau = new Board();
		
		/*for(int j = 2; j<5;++j){
			Candy c = new Candy(3,3,j);
			plateau.addCandy(c);
		}*/
		
		System.out.println(plateau);
		
		do{
			plateau.detectAlignments();
			plateau.eclater();
			System.out.println(plateau);
			plateau.detectAlignments();
		}while(plateau.checkTurnHasEnded()!=true);
		
		/*System.out.println("Ajout Candy rouge en 2/4\n");
		Candy redCandy = new Candy(4,2,4);
		plateau.addCandy(redCandy);
		System.out.println(plateau);*/
		
		
	}
}
