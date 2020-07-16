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
	
	BaseDatos bd;

public void setup()
{ 	
	size(width, height);
	
	vecmos = new Vector<Mostrable>();
	vecmov = new Vector<Movible>();
	vecplat = new Vector<Plataforma>();
	
	/*try {
		vecplat = BaseDatos.CargarPlataformas(1);
		h = BaseDatos.CargarHell(1,this);
		g = BaseDatos.CargarGrial(1,this);
		j = BaseDatos.CargarJesus(1,h.getPos().getY(),vecplat,this);
		
	} catch (InstantiationException | IllegalAccessException| ClassNotFoundException e) {e.printStackTrace();}
	*/
	
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
}

}