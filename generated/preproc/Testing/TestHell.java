package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Objetos.Punto;

public class TestHell {

	@Test
	public void Hell()
	{
	
		Objetos.Hell h= new Objetos.Hell(new Punto(0,0), 3, 2);

		assertEquals ((double)0, (double)h.getPos().getX(),0.0);
		assertEquals ((double)0, (double)h.getPos().getY(),0.0);
		assertEquals ((double)2, (double)h.getAlto(),0.0);
		assertEquals ((double)3, (double)h.getAncho(),0.0);
		
		h.getPos().setX(10);
		h.getPos().setY(10);
		h.setAncho(100);
		h.setAlto(100);
		
		assertEquals ((double)10, (double)h.getPos().getX(),0.0);
		assertEquals ((double)10, (double)h.getPos().getY(),0.0);
		assertEquals ((double)100, (double)h.getAlto(),0.0);
		assertEquals ((double)100, (double)h.getAncho(),0.0);
		}

	}


