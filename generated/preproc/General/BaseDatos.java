package General;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;

import processing.core.PApplet;

import Objetos.Grial;
import Objetos.Hell;
import Objetos.Jesus;
import Objetos.Plataforma;
import Objetos.Punto;

import com.mysql.jdbc.*;

public class BaseDatos 
{
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	public void BaseDatos()
	{
		// Creo una conexion
		Connection conn = null;
		// Creo una instruccion
		Statement stmt = null;
		// Creo un set de resultados
		ResultSet rs = null;
	}
		
	public static Jesus CargarJesus(int id,float hell,Vector<Plataforma>vplat,PApplet p) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Jesus j = null;
		try {
			// Creo una nueva instancia de driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Obtengo la conexión
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/phpmyadmin?user=root&password=root");
			// Instanción la instrucción
			stmt = conn.createStatement();
			// Cargo un set de resultados ejecutando la instrucción
			rs = stmt.executeQuery("SELECT * FROM Jesus WHERE Nnivel="+id);

			// Mientras pueda recorrer la tabla
			while (rs.next())
			{
				j = new Jesus(new Punto(rs.getInt("posx"),rs.getInt("posy")-5),20,40,150,p.height-hell,vplat,p);
			}
			
			// Cuando terminé, siempre cierro la conexión
			conn.close();
			
		}
		catch (SQLException ex)
		{
			return null;
		}
		return j;
	}
	
	public static Vector<Plataforma> CargarPlataformas(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Vector<Plataforma> vecplat=new Vector<Plataforma>();
		try {
			// Creo una nueva instancia de driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Obtengo la conexión
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/phpmyadmin?user=root&password=root");
			// Instanción la instrucción
			stmt = conn.createStatement();
			// Cargo un set de resultados ejecutando la instrucción
			rs = stmt.executeQuery("SELECT * FROM Plataforma WHERE Nnivel="+id);

			// Mientras pueda recorrer la tabla
			while (rs.next())
			{
				vecplat.add(new Plataforma((new Punto(rs.getInt("posx"),rs.getInt("posy"))),rs.getInt("ancho"),5));
			}
			
			// Cuando terminé, siempre cierro la conexión
			conn.close();
			
		}
		catch (SQLException ex){
		}
		return vecplat;
	}
	
	public static Grial CargarGrial(int id,PApplet p, Jesus j) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Grial g=null;
		try {
			// Creo una nueva instancia de driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Obtengo la conexión
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/phpmyadmin?user=root&password=root");
			// Instanción la instrucción
			stmt = conn.createStatement();
			// Cargo un set de resultados ejecutando la instrucción
			rs = stmt.executeQuery("SELECT * FROM Grial WHERE Nnivel="+id);

			// Mientras pueda recorrer la tabla
			while (rs.next())
			{
				g = new Grial(new Punto(rs.getInt("posx"),rs.getInt("posy")),15,30,p, j,id);

			}
			
			// Cuando terminé, siempre cierro la conexión
			conn.close();
			
		}
		catch (SQLException ex){
		}
		return g;
	}
	
	public static Hell CargarHell(int id,PApplet p) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Hell h=null;
		try {
			// Creo una nueva instancia de driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Obtengo la conexión
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/phpmyadmin?user=root&password=root");
			// Instanción la instrucción
			stmt = conn.createStatement();
			// Cargo un set de resultados ejecutando la instrucción
			rs = stmt.executeQuery("SELECT * FROM Hell WHERE Nnivel="+id);

			// Mientras pueda recorrer la tabla
			while (rs.next())
			{			
				h = new Hell(new Punto(0,p.height-rs.getInt("posy")),p.width,p.height-rs.getInt("posy"));
			}
			
			// Cuando terminé, siempre cierro la conexión
			conn.close();
			
		}
		catch (SQLException ex){
		}
		return h;
	}
	
	public static void Salvaguardar(int id, Jesus j) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		try {
			// Creo una nueva instancia de driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Obtengo la conexión
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/phpmyadmin?user=root&password=root");
			// Instanción la instrucción
			stmt = conn.createStatement();
			// Cargo un set de resultados ejecutando la instrucción
			stmt.execute("UPDATE Jesus SET posx ="+j.getPos().getX()+",posy="+j.getPos().getY()+" WHERE Nnivel="+id);	
			for(int i = id-1;id>0;id--){
				stmt.execute("DELETE FROM JESUS WHERE Nnivel = "+i);
			}
			// Cuando terminé, siempre cierro la conexión
			conn.close();
			System.out.println("SAVE SUCCESFUL!");
		}catch (SQLException ex){
			// Si hubo algún error que me muestre el detalle
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}



