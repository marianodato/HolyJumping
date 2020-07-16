package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Objetos.Punto;

public class TestGrial {

	@Test
	public void Grial() 
	{
		Objetos.Grial g = new Objetos.Grial();
		assertEquals ((double)0, (double)g.getPos().getX(),0.0);
		assertEquals ((double)0, (double)g.getPos().getY(),0.0);
		assertEquals ((double)10, (double)g.getAlto(),0.0);
		assertEquals ((double)20, (double)g.getAncho(),0.0);
		g.getPos().setX(10);
		g.getPos().setY(10);
		g.setAncho(100);
		g.setAlto(100);
		
		assertEquals ((double)10, (double)g.getPos().getX(),0.0);
		assertEquals ((double)10, (double)g.getPos().getY(),0.0);
		assertEquals ((double)100, (double)g.getAlto(),0.0);
		assertEquals ((double)100, (double)g.getAncho(),0.0);
	}

}
