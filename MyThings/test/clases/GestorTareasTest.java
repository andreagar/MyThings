package clases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorTareasTest {

	GestorTareas gestor;
	Tareas tarea;
	
	@Before
	public void setUp() throws MiExcepcion {
		BaseDeDatos.conexion("MyThings.BD");
		gestor = new GestorTareas();
		tarea = new Tareas();
	}
	
	//Chequeo añadir un usuario
		@Test 
		public void testModificarTarea() throws MiExcepcion, SQLException{
			
			gestor.AñadirTarea(1, "11/11/11", "12/12/12","Alta" , "Donosti", 15, "playa", "a");
			
			tarea.setId(1);
			tarea.setFecha_i("11/11/11");
			tarea.setFecha_f("12/12/12");
			tarea.setImportancia("Alta");
			tarea.setLocalizacion("Donosti");
			tarea.setTiempo_v(15);
			tarea.setDescripcion("playa");
			
			gestor.ModificarTarea("12/11/13", "10/11/13", "Media", "Bilbo", 0, "bbk", tarea);
		}	
	
	@After
	public void tearDown(){
		BaseDeDatos.finConexion();
	}
	
}
