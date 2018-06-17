package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.primitives.Vector;

public class VectorTest {
	@Test
	public void testcross2(){

		//ok editeing here
		double p1,p2,p3;
		p1 = -0.0;
		p2 = 1;
		p3 = 1;
		System.out.println(p1);
		if (p1==-0.0){ p1 = 0.0;}
		System.out.println(p1);
	}

	@Test
	public void testAdd(){
		
		Vector v1 = new Vector(1.0, 1.0, 1.0); 
		Vector v2 = new Vector(-1.0, -1.0, -1.0);
		
		v1.add(v2);
		assertTrue(v1.compareTo(new Vector(0.0,0.0,0.0)) == 0);
		
		v2.add(v1);
		assertTrue(v2.compareTo(v2) == 0);
		
	}
	
	@Test
	public void testSubtract(){
		
		Vector v1 = new Vector(1.0, 1.0, 1.0); 
		Vector v2 = new Vector(-1.0, -1.0, -1.0);
		
		v1.subtract(v2);
		assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);
		
		v2.subtract(v1);
		assertTrue(v2.compareTo(new Vector(-3.0,-3.0,-3.0)) == 0);
		
	}
	
	@Test
	public void testScaling(){
		Vector v1 = new Vector(1.0, 1.0, 1.0); 
		
		v1.scale(1);
		assertTrue(v1.compareTo(v1) == 0);
		
		v1.scale(2);
		assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);
		
		v1.scale(-2);
		assertTrue(v1.compareTo(new Vector(-4.0,-4.0,-4.0)) == 0);
	}
	
	@Test
	public void testDotProduct(){
		
		Vector v1 = new Vector(3.5,-5,10);		
		Vector v2 = new Vector(2.5,7,0.5);
		
		assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);
		System.out.println(v1.dotProduct(v2));
	}
	
	@Test
	public void testLength() {
		Vector v = new Vector(3.5,-5,10);		
		assertTrue(v.length() ==  Math.sqrt(12.25 + 25 + 100));
	}
	
	@Test
	public void testNormalize(){
		
		Vector v = new Vector(3.5,-5,10);
		v.normalize();

		assertEquals(1, v.length(),1e-10,"");
		
		v = new Vector(0,0,0);
		
		try {
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
			assertTrue(true);			
		}
		
	}
	
	@Test
	public void testCrossProduct(){
		
		Vector v1 = new Vector(3.5, -5.0, 10.0);		
		Vector v2 = new Vector(2.5,7,0.5);
		Vector v3 = v1.crossProduct(v2);

		assertEquals( 0, v3.dotProduct(v2), 1e-10);
		assertEquals( 0, v3.dotProduct(v1), 1e-10,"");
		
		Vector v4 = v2.crossProduct(v1);
		v3.add(v4);
		assertEquals(0, v3.length(), 1e-10);
		
	}
	
}
