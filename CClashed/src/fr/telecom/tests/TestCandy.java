package fr.telecom.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.telecom.cclashed.Alignment;
import fr.telecom.cclashed.Candy;
import fr.telecom.cclashed.Sens;

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
	public void testIsWithinAlignment(){
		Candy candyStart = new Candy(1,0,0);
		Candy candyEnd = new Candy(1,0,2);
		Candy candyToTest = new Candy(1,0,1);
		Alignment align = new Alignment(candyStart, candyEnd);
		align.orientation = Sens.HORIZONTAL;
		List<Alignment> alignments = new ArrayList<Alignment>();
		alignments.add(align);
		assertTrue(candyToTest.isWithinAlignment(Sens.HORIZONTAL, alignments));
		
		candyEnd = new Candy(1,2,0);
		candyToTest = new Candy(1,1,0);
		Alignment align2 = new Alignment(candyStart, candyEnd);
		align2.orientation = Sens.VERTICAL;
		alignments.add(align2);
		assertTrue(candyToTest.isWithinAlignment(Sens.VERTICAL, alignments));
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
