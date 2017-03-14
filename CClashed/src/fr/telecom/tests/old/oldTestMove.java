package fr.telecom.tests.old;

import fr.telecom.cclashed.Move;
import fr.telecom.cclashed.RegularCandy;

public class oldTestMove {
	public static void main (String[] args) {
	
		/* Test du constructeur principal */
		RegularCandy bonbon1 = new RegularCandy(1, 1, 1);
		RegularCandy bonbon2 = new RegularCandy(1, 1, 2);
		Move mouvement1 = new Move(bonbon1, bonbon2);
		System.out.println(mouvement1);
		
		/* Test du constructeur par copie */
		Move mouvement1Copie = new Move(mouvement1);
		System.out.println(mouvement1Copie);
		
		/* Test d'égalité entre deux mouvements */
		if (mouvement1.equals(mouvement1Copie)) {
			System.out.println("| Mouvements égaux, réussite du test.\n");
		}
		else {
			System.out.println("| Mouvements inégaux, échec du test.\n");
		}
		
		/* Test d'inégalité entre deux mouvements */
		RegularCandy bonbon3 = new RegularCandy(2, 1, 1);
		RegularCandy bonbon4 = new RegularCandy(2, 1, 2);
		Move mouvement2 = new Move(bonbon3, bonbon4);
		if (mouvement2.equals(mouvement1)) {
			System.out.println("| Mouvements égaux, échec du test.\n");
		}
		else {
			System.out.println("| Mouvements inégaux, réussite du test.\n");
		}
	
	}
}
