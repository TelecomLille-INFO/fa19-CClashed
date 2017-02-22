package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Candy;

public class TestCandy {

	@Test
	public void testCandyIntInt() {
		Candy bonbon = new Candy(2,3);
		int row = bonbon.getRow();
		int col = bonbon.getCol();
		assertEquals(2, row);
		assertEquals(3, col);
	}

	@Test
	public void testCandyIntIntInt() {
		Candy bonbon = new Candy(1,3,4);
		int color = bonbon.getColor();
		int row = bonbon.getRow();
		int col = bonbon.getCol();
		assertEquals(1, color);
		assertEquals(3, row);
		assertEquals(4, col);
	}

	@Test
	public void testCandyCandy() {
		Candy bonbon = new Candy(2,4,7);
		Candy newBonbon = new Candy(bonbon);
		assertTrue(bonbon.equals(newBonbon));
	}

	@Test
	public void testGetColor() {
		Candy bonbon = new Candy(1,3,4);
		assertEquals(1, bonbon.getColor());
	}

	@Test
	public void testSetColor() {
		Candy bonbon = new Candy(1,3,4);
		bonbon.setColor(3);
		assertEquals(3, bonbon.getColor());
	}

	@Test
	public void testGetRow() {
		Candy bonbon = new Candy(1,3,4);
		assertEquals(3, bonbon.getRow());
	}

	@Test
	public void testSetRow() {
		Candy bonbon = new Candy(1,3,4);
		bonbon.setRow(2);
		assertEquals(2, bonbon.getRow());
	}

	@Test
	public void testGetCol() {
		Candy bonbon = new Candy(1,3,4);
		assertEquals(4, bonbon.getCol());
	}

	@Test
	public void testSetCol() {
		Candy bonbon = new Candy(1,3,4);
		bonbon.setCol(5);
		assertEquals(5, bonbon.getCol());
	}

	@Test
	public void testEqualsCandy() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(1,2,3);
		Candy bonbon3 = new Candy(3,2,1);
		assertTrue(bonbon1.equals(bonbon2));
		assertFalse(bonbon1.equals(bonbon3));
	}

	@Test
	public void testToString() {
		Candy bonbon = new Candy(1,2,3);
		String expected = "/----------\n| Affichage du bonbon :\n|\n| Id couleur = 1\n| N° ligne = 2\n| N° colonne = 3\n|\n----------/";
		String unexpected = "test";
		assertEquals(expected,bonbon.toString());
		assertNotEquals(unexpected, bonbon.toString());
	}
}
