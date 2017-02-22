package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.RegularCandy;

public class TestRegularCandy {

	@Test
	public void testRegularCandyIntIntInt() {
		RegularCandy bonbon = new RegularCandy(2, 3, 1);
		int color = bonbon.getColor();
		int row = bonbon.getRow();
		int col = bonbon.getCol();
		assertEquals(2, color);
		assertEquals(3, row);
		assertEquals(1, col);
	}

	@Test
	public void testRegularCandyRegularCandy() {
		RegularCandy bonbon = new RegularCandy(2,4,7);
		RegularCandy newBonbon = new RegularCandy(bonbon);
		assertTrue(bonbon.equals(newBonbon));
	}

}
