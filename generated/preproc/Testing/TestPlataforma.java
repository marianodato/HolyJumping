package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Objetos.Punto;

public class TestPlataforma {

	@Test
	public void Plataforma() 
	{
		Objetos.Plataforma p= new Objetos.Plataforma(new Punto(0,0), 3, 2);

		assertEquals ((double)0, (double)p.getPos().getX(),0.0);
		assertEquals ((double)0, (double)p.getPos().getY(),0.0);
		assertEquals ((double)2, (double)p.getAlto(),0.0);
		assertEquals ((double)3, (double)p.getAncho(),0.0);
		
		p.getPos().setX(10);
		p.getPos().setY(10);
		p.setAncho(100);
		p.setAlto(100);
		
		assertEquals ((double)10, (double)p.getPos().getX(),0.0);
		assertEquals ((double)10, (double)p.getPos().getY(),0.0);
		assertEquals ((double)100, (double)p.getAlto(),0.0);
		assertEquals ((double)100, (double)p.getAncho(),0.0);
	}

}
