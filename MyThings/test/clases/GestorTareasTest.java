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
	
	//Chequeo de modificar una tarea
		@Test 
		public void testModificarTarea() throws Exception{
			
			GestorUsuarios user = new GestorUsuarios();
			
			user.AñadirUsuario("yo", "yo", "yo", "yo");
			
			user.Login("yo", "yo");
		
			gestor.AñadirTarea(1, "11/11/11", "12/12/12","Alta" , "Donosti", 15, "playa", "a");
			
			Statement stmt = BaseDeDatos.getStatement();
				tarea.setId(1);
				tarea.setFecha_i("11/11/11");
				tarea.setFecha_f("12/12/12");
				tarea.setImportancia("Alta");
				tarea.setLocalizacion("Donosti");
				tarea.setTiempo_v(15);
				tarea.setDescripcion("playa");
			
			gestor.ModificarTarea("12/11/13", "10/11/13", "Media", "Bilbo", 0, "bbk", tarea);
			String fI = "";
			String fF = "";
			String importancia = "";
			String localizacion = "";
			String tiempo = "";
			String descripcion = "";
			
			try {
				ResultSet consulta = stmt.executeQuery("select fecha_i,fecha_f,importancia, localizacion, tiempo_v, descripcion   from tabla_usuarios where nomLogIn='pepe3' and password='pepito' ");
				if(consulta.next()){
					fI = consulta.getString("fecha_i");
					fF = consulta.getString("fecha_f");
					importancia = consulta.getString("importancia");
					localizacion = consulta.getString("localizacion");
					tiempo = consulta.getString("tiempo_v");
					descripcion = consulta.getString("descripcion");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals("12/11/13", fI);
			assertEquals("10/11/13", fF);
			assertEquals("Media", importancia);
			assertEquals("Bilbo", localizacion);
			assertEquals("0", tiempo);
			assertEquals("bbk",	descripcion);
			
		}	
	
	@After
	public void tearDown(){
		BaseDeDatos.finConexion();
	}
	
}
