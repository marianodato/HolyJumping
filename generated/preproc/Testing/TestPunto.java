package Testing;
import static org.junit.Assert.*;

import org.junit.Test;

import Objetos.Punto;


public class TestPunto {

	@Test
	public void Punto() 
	{
		Punto p = new Punto(3,7);
		
		assertEquals ((double)3, (double)p.getX(),0.0);
		assertEquals ((double)7, (double)p.getY(),0.0);
		p.setX(0);
		p.setY(0);
		
		assertEquals ((double)0, (double)p.getX(),0.0);
		assertEquals ((double)0, (double)p.getY(),0.0);
		
		
	}

}
