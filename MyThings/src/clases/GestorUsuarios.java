package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

/** Clase para gestionar el a�adido y el LogIn de los usuarios.
 */
public class GestorUsuarios {

	/**Constructor.
	 */
	public GestorUsuarios(){}
	
	/**Log In del usuario a la aplicaci�n
	 * Comprobamos de si/no existe el usuario, para saberlo hacemos una consulta con el nombre de usuario y password.
	 * Si no existe, devolveremos un false que har� que salga un mensaje de que ese usuario no est� registrado.
	 * @throws Exception 
	 */
	public boolean Login (String usuario, String password) throws MiExcepcion, Exception{
		
		boolean entrar = false;
		
		 //consultamos que ese usuario con esa contrase�a existan
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn,password from tabla_usuarios where "
					+ "nomLogIn='"+usuario+"' and password='"+password+"' ");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'true' a entrar
	            entrar=true;
	            System.out.println("El usuario y contrase�a coinciden --> entrar en la app.");
			} else {
				throw new MiExcepcion() ;
			}
		
		
		return entrar;
	}
	
	
	/**A�adir un nuevo usuario a la BD
	 * Primero comprobar si existe el usuario, si no existe lo a�adimos a la BD
	 * Si existe, devolveremos un false que har� que salga un mensaje de error.
	 * @throws SQLException 
	 */
	public boolean A�adirUsuario (String nomLI, String nombreR, String apell, String password) throws MiExcepcion, SQLException{
		
		boolean NoExiste = true; //NO est� en la BD

	 //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn from tabla_usuarios where nomLogIn='" +nomLI+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				throw new MiExcepcion();
			} else {
				BaseDeDatos.insertUsuario(nomLI, nombreR, apell, password);
				System.out.println("Usuario a�adido.");
			}
		
		return NoExiste;
	}


}
