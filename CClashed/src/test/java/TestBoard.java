package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Board;

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
