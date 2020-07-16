package Objetos;

import java.util.Vector;

import processing.core.PApplet;
import processing.core.PImage;
import sun.org.mozilla.javascript.internal.ast.Jump;
import Interfaces.Mostrable;
import Interfaces.Movible;
import Interfaces.Tecleable;
import Objetos.Plataforma;

public class Jesus extends Objeto implements Tecleable, Movible
{
	private float salto,piso,velsalto,velplat,posanterior,i,hell;
	private boolean saltando,bajando,der,izq,moverder,moverizq;
	private Vector<Plataforma> vpl;				//Vector de plataformas
	private Plataforma pactual;
	
	public Jesus(Punto pos, float ancho, float alto, float _salto, float _hell, Vector<Plataforma> _vpl, PApplet p) 
	{
		super(pos, ancho, alto);
		salto = _salto;
		saltando = false;
		bajando = false;
		posanterior = pos.getY();
		i = 0;
		der = true;
		izq = true;
		moverizq = false;
		moverder = false;
		hell = _hell;
		vpl = _vpl;
		pactual = vpl.get(0);
		img = p.loadImage("I:\\HolyJumping\\HolyJumping\\HolyJumping\\data\\jesus.jpg");
	}

	public Jesus(Punto pos, float ancho, float alto, float _salto, float _hell) 
	{
		super(pos, ancho, alto);
		salto = _salto;
		saltando = false;
		bajando = false;
		posanterior = pos.getY();
		i = 0;
		der = true;
		izq = true;
		moverizq = false;
		moverder = false;
		hell = _hell;
		}
	
	public float getPosAnt() {return posanterior;}
	public float getSalto() {return salto;}
	public void setSalto(float salto) {this.salto = salto;}
	public void setvpl(Plataforma p) {this.vpl.add(p);}
	public boolean getDer() {return der;}
	public float getHell() {return hell;}
	public void setHell(float hell) {this.hell = hell;}
	public boolean getIzq() {return izq;}
	public boolean isSaltando() {return saltando;}
	public void setSaltando(boolean saltando) {this.saltando = saltando;}

	public void Procesar(char c)
	{
		if(c == 'w'){posanterior = this.getPos().getY(); saltando = true;}
		//Mueve izquierda
		if(c == 'a'){moverizq = true;
		//Mueve derecha
		}else if (c == 'd'){moverder = true;}
	}
	
	
	public void Mostrar(PApplet p)
	{
		p.image(img,this.getPos().getX(),this.getPos().getY(),this.getAncho(),this.getAlto());
		
	}

	public void Mover(PApplet p) 
	{
		if(moverizq)
		{
			this.getPos().setX(this.getPos().getX() - 2);
			i++;
			if(i == 5){i=0;moverizq=false;}
		}else if(moverder)
		{
			this.getPos().setX(this.getPos().getX() + 2);
			i++;
			if(i == 5){i=0;moverder=false;}
		}
		
		
		if(saltando && !bajando)
		{
			this.getPos().setY(this.getPos().getY() - 5);

			if(this.getPos().getY() <= posanterior - salto) bajando = true;

		}
		else if(bajando && saltando)
		{
			this.getPos().setY(this.getPos().getY() + 5);	
			
			//Muevo Plataformas
			for(int i=0; i<vpl.size();i++)
			{		
			//Si me poso en una
				if((this.getPos().getY() + getAlto() <= vpl.get(i).getPos().getY()									//
					&& this.getPos().getY() + getAlto()+ 5 > vpl.get(i).getPos().getY())							//Y
					&& ((this.getPos().getX() + getAncho() >= vpl.get(i).getPos().getX()							//
					&& this.getPos().getX() + getAncho() <= vpl.get(i).getPos().getX() + vpl.get(i).getAncho()) 	//
					||(this.getPos().getX() >= vpl.get(i).getPos().getX()											//
					&& this.getPos().getX() <= vpl.get(i).getPos().getX() + vpl.get(i).getAncho())) && bajando)		//X
				{
					posanterior = this.getPos().getY() + getAlto();
					pactual = vpl.get(i);
					this.getPos().setY(vpl.get(i).getPos().getY() - getAlto());
					saltando = false;
					bajando = false;			
				}
			}		
		}
		
		if((this.getPos().getX() > pactual.getPos().getX()+pactual.getAncho() 
				|| this.getPos().getX() + this.getAncho()<pactual.getPos().getX())){saltando = true;bajando = true;}
		
		if(this.getPos().getY() > p.height-hell) p.exit();
		if(this.getPos().getY() < 0){this.getPos().setY(1);bajando = true;}	
	 	if(this.getPos().getX() - 2 <= 0){this.getPos().setX(1);izq = false;}
	 	else izq = true;
		if(this.getPos().getX()+this.getAncho() + 2 >= p.width){this.getPos().setX(p.width-this.getAncho()-1);der = false;}	
		else der = true;
	}
}