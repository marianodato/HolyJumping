package Objetos;

import processing.core.PApplet;

public class Grial extends Objeto {

	public Grial(Punto pos, float ancho, float alto,PApplet p) {
		super(pos, ancho, alto);
		img = p.loadImage("I:\\HolyJumping\\HolyJumping\\HolyJumping\\data\\antorcha.jpg");
	}
	
	public Grial() {super(new Punto(0,0), 20, 10);}
	
	public void Mostrar(PApplet p)
	{
		p.image(img,this.getPos().getX(),this.getPos().getY(),this.getAncho(),this.getAlto());
	}
}
