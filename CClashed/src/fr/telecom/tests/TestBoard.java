package fr.telecom.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.telecom.cclashed.Board;
import fr.telecom.cclashed.Candy;

public class TestBoard {

	@Test
	public void testBoard() {
		Board board = new Board();
		assertEquals(8, board.getHeight());
		assertEquals(8, board.getWidth());
	}

	@Test
	public void testGetHeight() {
		Board board = new Board();
		assertEquals(8, board.getHeight());
	}

	@Test
	public void testSetHeight() {
		Board board = new Board();
		board.setHeight(12);
		assertEquals(12, board.getHeight());
	}

	@Test
	public void testGetWidth() {
		Board board = new Board();
		assertEquals(8, board.getWidth());
	}

	@Test
	public void testSetWidth() {
		Board board = new Board();
		board.setWidth(4);
		assertEquals(4, board.getWidth());
	}

	@Test
	public void testAddCandyIntInt()
	{
		Board board = new Board();
		board.addCandy(2, 3);
		assertNotNull(board.getCandy(2, 3));
	}
	
	@Test
	public void testAddCandyCandy()
	{
		Board board = new Board();
		Candy candy = new Candy(4,3);
		board.addCandy(candy);
		assertNotNull(board.getCandy(4, 3));
	}
	
	@Test
	public void testGetCandy()
	{
		Board board = new Board();
		board.addCandy(2, 3);
		assertEquals(3,board.getCandy(2, 3).getCol());
	}

	@Test
	public void testCheckTurnHasEnded() {
		Board plateau = new Board();
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				Candy c = new Candy(1,i,j);
				plateau.addCandy(c);
			}
		}
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				assertTrue(plateau.checkTurnHasEnded());
			}
		}
		Candy c = new Candy(2,3);
		c.setASupprimer(true);
		plateau.addCandy(c);
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				assertFalse(plateau.checkTurnHasEnded());
			}
		}
		
	}

	@Test
	public void testCheckMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCheckGameHasEnded()
	{
		Board board = new Board();
		assertTrue(board.checkGameHasEnded());
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDetectAlignments()
	{
		Board plateau = new Board();
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				Candy c = new Candy(1,i,j);
				plateau.addCandy(c);
			}
		}
		
		plateau.detectAlignments();
		for(int i = 0; i<plateau.getHeight();++i)
		{
			for(int j = 0; j<plateau.getWidth();++j)
			{
				assertTrue(plateau.getCandy(i, j).getASupprimer());
			}
		}
		Candy c = new Candy(2,0,7);
		plateau.addCandy(c);
		plateau.detectAlignments();
		assertFalse(plateau.getCandy(0, 7).getASupprimer());
	}

	@Test
	public void testCompacter(){
		Board plateau = new Board();
		for(int i = 0; i<plateau.getHeight();++i){
			for(int j = 0; j<plateau.getWidth();++j){
				Candy c = new Candy(1,i,j);
				plateau.addCandy(c);
			}
		}
		
		Candy c = new Candy(0,0,0);
		plateau.addCandy(c);
		plateau.compacter();
		assertNotEquals(c.getColor(),0);
		Candy c1 = new Candy(2,0,0);
		Candy c2 = new Candy(1,1,0);
		Candy c3 = new Candy(0,2,0);
		plateau.addCandy(c1);
		plateau.addCandy(c2);
		plateau.addCandy(c3);
		plateau.compacter();
		assertEquals(c3.getColor(),1);
		assertEquals(c2.getColor(),2);
		assertNotEquals(c1.getColor(),2);
				
	}
	
	@Test
	public void testEclater(){
		
	}

}
