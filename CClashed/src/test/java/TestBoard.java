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
	public void testToString() {
		fail("Not yet implemented");
	}

}
