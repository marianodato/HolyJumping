package General;

import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

import General.BaseDatos;
import Interfaces.Mostrable;
import Interfaces.Movible;
import Objetos.Grial;
import Objetos.Hell;
import Objetos.Jesus;
import Objetos.Plataforma;
import Objetos.Punto;

public class HolyJumping extends PApplet {

	private int height=650;
	private int width=1200;

	Vector <Mostrable> vecmos;
	Vector <Movible> vecmov;
	Vector <Plataforma> vecplat; 
		
	Jesus j;
	Hell h;
	Grial g;
	int nivel=0;
	
	BaseDatos bd;

public void setup()
{ 	
	size(width, height);
	vecmos = new Vector<Mostrable>();
	vecmov = new Vector<Movible>();
	vecplat = new Vector<Plataforma>();
	
	try {
		System.out.println(j);
		while(j==null){nivel++;j = BaseDatos.CargarJesus(nivel,10,vecplat,this);}
		vecplat = BaseDatos.CargarPlataformas(nivel);
		h = BaseDatos.CargarHell(nivel,this);		
		j = BaseDatos.CargarJesus(nivel,h.getAlto(),vecplat,this);
		g = BaseDatos.CargarGrial(nivel,this, j);
	} catch (InstantiationException | IllegalAccessException| ClassNotFoundException e) {e.printStackTrace();}
	
	
	for(int i=0;i<vecplat.size();i++)vecmos.add(vecplat.get(i));	
	vecmos.add(g);
	vecmos.add(j);
	vecmos.add(h);
	vecmov.add(j);	
} 

public void setup(int nivel)
{ 	
	this.nivel = nivel;

	vecmos = new Vector<Mostrable>();
	vecmov = new Vector<Movible>();
	vecplat = new Vector<Plataforma>();
	
	try {
		vecplat = BaseDatos.CargarPlataformas(nivel);
		h = BaseDatos.CargarHell(nivel,this);
		j = BaseDatos.CargarJesus(nivel,h.getPos().getY(),vecplat,this);
		g = BaseDatos.CargarGrial(nivel,this, j);
		
	} catch (InstantiationException | IllegalAccessException| ClassNotFoundException e) {e.printStackTrace();}
	
	
	for(int i=0;i<vecplat.size();i++)vecmos.add(vecplat.get(i));	
	vecmos.add(g);
	vecmos.add(j);
	vecmos.add(h);
	vecmov.add(j);	
} 
 
public void draw()
{ 
	background(255);
	for(int i=0;i<vecmos.size();i++) vecmos.get(i).Mostrar(this);
	for(int i=0;i<vecmov.size();i++) vecmov.get(i).Mover(this);
	if(keyPressed) keyPressed();
} 
public void keyPressed()
{		 
	if (key == CODED) {
	    if (keyCode == UP && !j.isSaltando()) {
	    	j.Procesar('w');
	    } 
	    if (keyCode == RIGHT) {
	    	j.Procesar('d');
	    } 
	    else if (keyCode == LEFT) {
	    	j.Procesar('a');
	    } 
	}
	if (key == 's')
		try {
			bd.Salvaguardar(nivel, j);
		} catch (InstantiationException e) {e.printStackTrace();} 
		catch (IllegalAccessException e) {e.printStackTrace();} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
}

}