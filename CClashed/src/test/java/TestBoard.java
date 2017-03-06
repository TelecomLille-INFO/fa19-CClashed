package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Board;
import main.java.Candy;

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
		fail("Not yet implemented");
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
	public void testNewAlignmentDetection(){
		Board board = new Board();
		Candy candy0 = new Candy(1,0,0);
		Candy candy1= new Candy(1,0,1);
		Candy candy2= new Candy(1,0,2);
		Candy candy3= new Candy(1,0,3);
		board.addCandy(0, 4);
		board.addCandy(0, 5);
		board.addCandy(0, 6);
		board.addCandy(0, 7);
		for (int i=1;i<board.getHeight();i++){
			for(int j=0;j<board.getWidth();j++){
				board.addCandy(i, j);
			}
		}
		board.addCandy(candy0);
		board.addCandy(candy1);
		board.addCandy(candy2);
		board.addCandy(candy3);
		board.newAlignmentDetection();
		assertTrue(candy0.isaSupprimer());
		assertTrue(candy1.isaSupprimer());
		assertTrue(candy2.isaSupprimer());
		assertTrue(candy3.isaSupprimer());
	}

}
