package Objetos;

import processing.core.PApplet;

public class Hell extends Objeto{

	public Hell(Punto pos, float ancho, float alto) {
		super(pos, ancho, alto);
	}

	public void Mostrar(PApplet p)
	{
		p.fill(p.random(150,250),0,0);
		p.rect(0,this.getPos().getY(),p.width,this.getAlto());
	}

}
