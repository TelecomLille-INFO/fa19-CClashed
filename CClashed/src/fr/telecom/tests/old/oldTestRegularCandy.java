package fr.telecom.tests.old;

import fr.telecom.cclashed.RegularCandy;

public class oldTestRegularCandy {
	public static void main (String[] args) {
	
		/* Test du constructeur principal */
		RegularCandy bonbon1 = new RegularCandy(1, 1, 1);
		System.out.println(bonbon1);
		
		/* Test des setters */
		bonbon1.setColor(2);
		bonbon1.setRow(2);
		bonbon1.setCol(2);
		System.out.println(bonbon1);
		
		/* Test des getters */
		System.out.println("/--- Test des getters");
		System.out.println("| Color : " + bonbon1.getColor());
		System.out.println("| Row : " + bonbon1.getRow());
		System.out.println("| Col : " + bonbon1.getCol() + "\n");
		
		/* Test du constructeur par copie */
		RegularCandy bonbon1Copie = new RegularCandy(bonbon1);
		System.out.println(bonbon1Copie);
		
		/* Test d'égalité entre deux bonbons */
		if (bonbon1.equals(bonbon1Copie)) {
			System.out.println("| Bonbons égaux, réussite du test.\n");
		}
		else {
			System.out.println("| Bonbons inégaux, échec du test.\n");
		}
		
		/* Test d'inégalité entre deux bonbons */
		RegularCandy bonbon2 = new RegularCandy(0, 0, 0);
		if (bonbon2.equals(bonbon1)) {
			System.out.println("| Bonbons égaux, échec du test.\n");
		}
		else {
			System.out.println("| Bonbons inégaux, réussite du test.\n");
		}
	
	}
}
