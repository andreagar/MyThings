package clases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorUsuariosTest {

	GestorUsuarios gestor;
	Usuarios usuario;
	
	@Before
	public void setUp() throws MiExcepcion {
		BaseDeDatos.conexion("MyThings.BD");
		gestor = new GestorUsuarios();
		usuario = new Usuarios();
	}
	
	//Chequeo añadir un usuario
		@Test 
		public void testAñadirUsuario() throws MiExcepcion, SQLException{
					
			try {
				gestor.AñadirUsuario("pepe3", "Pepe", "Bett", "pepito");
			} catch (MiExcepcion e1) {
				// TODO Auto-generated catch block
				System.out.println("miexcepcion");
			}
			catch (SQLException e2){
				e2.printStackTrace();
			}
			
			Statement stmt = BaseDeDatos.getStatement();
			String user = "";
			String contra = "";
			
			try {
				ResultSet consulta = stmt.executeQuery("select nomLogIn,password from tabla_usuarios where nomLogIn='pepe3' and password='pepito' ");
				if(consulta.next()){
					user = consulta.getString("nomLogIn");
					contra = consulta.getString("password");
					
					try{ //para eliminar el contacto de esta prueba ya que sino lo añade realmente a la BD
					stmt.executeUpdate("delete from tabla_usuarios where nomLogIn='pepe3' ");
					}catch(SQLException e){
						e.printStackTrace();
					}
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals("pepe3", user);
			assertEquals("pepito", contra);
		}
		
//	@Test public void Login() throws MiExcepcion{
//		gestor.AñadirUsuario("pepe3", "Pepe", "Bett", "pepito");
//		
//		gestor.Login("pepe3", "pepito");
//		
//	}
	
	@After
	public void tearDown(){
		BaseDeDatos.finConexion();
	}
}
