package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.Alignment;
import main.java.Candy;
import main.java.Sens;

public class TestAlignment {

	@Test
	public void testAlignment(){
		Candy candy1 = new Candy(1,1);
		Candy candy2 = new Candy(1,3);
		Alignment al = new Alignment(candy1,candy2);
		assertEquals(al.getStart(),candy1);
		assertEquals(al.getEnd(),candy2);
	}
	
	@Test
	public void testIsWithinAnother() {
		Candy candy1 = new Candy(1,1);
		Candy candy2 = new Candy(1,3);
		Candy candy3 = new Candy(1,4);
		Alignment al1 = new Alignment (candy1,candy2);
		al1.orientation=Sens.HORIZONTAL;
		Alignment al2 = new Alignment (candy1,candy3);
		al2.orientation=Sens.HORIZONTAL;
		List<Alignment> alignmentList = new ArrayList<Alignment>();
		alignmentList.add(al2);
		assertEquals(al1.isWithinAnother(alignmentList),true);
	}
	
	@Test
	public void testGetStart(){
		Candy candy1 = new Candy(1,1);
		Candy candy2 = new Candy(1,3);
		Alignment al = new Alignment(candy1,candy2);
		assertEquals(al.getStart(),candy1);
	}
	
	@Test
	public void testGetEnd(){
		Candy candy1 = new Candy(1,1);
		Candy candy2 = new Candy(1,3);
		Alignment al = new Alignment(candy1,candy2);
		assertEquals(al.getEnd(),candy2);
	}

	@Test
	public void testNewAlignmentDetection(){
		fail("not yet implemented");
	}
}
