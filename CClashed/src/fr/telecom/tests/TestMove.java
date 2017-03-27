package fr.telecom.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.telecom.cclashed.Candy;
import fr.telecom.cclashed.Move;

public class TestMove {

	@Test
	public void testMoveCandyCandy() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move = new Move(bonbon1,bonbon2);
		assertTrue(bonbon1.equals(move.getCandy1()));
		assertTrue(bonbon2.equals(move.getCandy2()));
		assertFalse(bonbon1.equals(move.getCandy2()));
	}

	@Test
	public void testMoveMove() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move1 = new Move(bonbon1,bonbon2);
		Move move2 = new Move(move1);
		assertTrue(move1.isEqual(move2));
	}

	@Test
	public void testIsEqualMove() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move1 = new Move(bonbon1,bonbon2);
		Candy bonbon3 = new Candy(1,2,3);
		Candy bonbon4 = new Candy(3,2,1);
		Move move2 = new Move(bonbon3,bonbon4);
		Candy bonbon5 = new Candy(2,2,2);
		Candy bonbon6 = new Candy(3,2,1);
		Move move3 = new Move(bonbon5,bonbon6);
		assertTrue(move1.isEqual(move2));
		assertFalse(move1.isEqual(move3));
	}
	
	@Test
	public void testGetCandy1() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move = new Move(bonbon1,bonbon2);
		assertTrue(bonbon1.equals(move.getCandy1()));
		assertFalse(bonbon2.equals(move.getCandy1()));
	}

	@Test
	public void testGetCandy2() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move = new Move(bonbon1,bonbon2);
		assertTrue(bonbon2.equals(move.getCandy2()));
		assertFalse(bonbon1.equals(move.getCandy2()));
	}
	
	@Test
	public void testToString() {
		Candy bonbon1 = new Candy(1,2,3);
		Candy bonbon2 = new Candy(3,2,1);
		Move move = new Move(bonbon1,bonbon2);
		String expected = "/----------\n| Affichage du mouvement :\n|\n|  [2][3] <---> [2][1]\n|\n----------/";
		String unexpected = "test";
		assertEquals(expected, move.toString());
		assertNotEquals(unexpected, move.toString());
	}
}
