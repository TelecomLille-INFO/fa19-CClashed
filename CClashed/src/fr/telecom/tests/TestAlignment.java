package fr.telecom.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.telecom.cclashed.Alignment;
import fr.telecom.cclashed.Candy;

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
