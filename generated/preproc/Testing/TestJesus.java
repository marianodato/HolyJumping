package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Objetos.Punto;

public class TestJesus {

	@Test
	public void Jesus() 
	{
		Objetos.Jesus j= new Objetos.Jesus(new Punto(0,0),3,2,10,20);

		assertEquals ((double)0, (double)j.getPos().getX(),0.0);
		assertEquals ((double)0, (double)j.getPos().getY(),0.0);
		assertEquals ((double)2, (double)j.getAlto(),0.0);
		assertEquals ((double)3, (double)j.getAncho(),0.0);
		assertEquals ((double)10, (double)j.getSalto(),0.0);
		assertEquals ((double)20, (double)j.getHell(),0.0);
		assertEquals (false,j.isSaltando());
		assertEquals (true,j.getDer());
		assertEquals (true,j.getIzq());
		
		j.getPos().setX(10);
		j.getPos().setY(10);
		j.setAncho(100);
		j.setAlto(100);
		j.setHell(50);
		j.setSalto(25);
		j.setSaltando(true);
		
		assertEquals ((double)10, (double)j.getPos().getX(),0.0);
		assertEquals ((double)10, (double)j.getPos().getY(),0.0);
		assertEquals ((double)100, (double)j.getAlto(),0.0);
		assertEquals ((double)100, (double)j.getAncho(),0.0);
		assertEquals ((double)25, (double)j.getSalto(),0.0);
		assertEquals ((double)50, (double)j.getHell(),0.0);
		assertEquals (true,j.isSaltando());
	
	}

}
