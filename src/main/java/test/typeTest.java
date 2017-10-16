package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import test.type.Point;

public class typeTest {

	type t=new type();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxPoints() {
		Point[] ps=new Point[3];
		ps[0]=new Point();
		ps[1]=new Point(1,1);
		ps[2]=new Point(1,-1);
		int count=t.maxPoints(ps);
		assertEquals(2, count);
	}

	@Test
	public void testReverseWords() {

		String c=t.reverseWords("hello world!");
		assertEquals("!dlrow olleh", c);
	}

}
