package Objetos;

import processing.core.PApplet;

public class Plataforma extends Objeto {

	public Plataforma(Punto pos, float ancho, float alto) {
		super(pos, ancho, alto);
	}

	public void Mostrar(PApplet p)
	{
		p.fill(p.random(0,255),p.random(0,255),p.random(0,255));
		p.rect(this.getPos().getX(),this.getPos().getY(),this.getAncho(),this.getAlto());
	}
}
