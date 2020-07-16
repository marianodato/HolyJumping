package Objetos;

import processing.core.PImage;
import Interfaces.Mostrable;

public abstract class Objeto implements Mostrable
{
	Punto pos;
	float ancho,alto;
	PImage img;
	
	
	public Punto getPos() {
		return pos;
	}


	public void setPos(Punto pos) {
		this.pos = pos;
	}

	public float getAncho() {
		return ancho;
	}


	public void setAncho(float ancho) {
		this.ancho = ancho;
	}


	public float getAlto() {
		return alto;
	}


	public void setAlto(float alto) {
		this.alto = alto;
	}


	void Mostrar(){}


	public Objeto(Punto pos, float ancho, float alto) {
		this.pos = pos;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	
	
}