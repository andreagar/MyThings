package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

/** Clase para gestionar el añadido y el LogIn de los usuarios.
 */
public class GestorUsuarios {

	/**Constructor.
	 */
	public GestorUsuarios(){}
	
	/**Log In del usuario a la aplicación
	 * Comprobamos de si/no existe el usuario, para saberlo hacemos una consulta con el nombre de usuario y password.
	 * Si no existe, devolveremos un false que hará que salga un mensaje de que ese usuario no está registrado.
	 * @throws Exception 
	 */
	public boolean Login (String usuario, String password) throws MiExcepcion, Exception{
		
		boolean entrar = false;
		
		 //consultamos que ese usuario con esa contraseña existan
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn,password from tabla_usuarios where "
					+ "nomLogIn='"+usuario+"' and password='"+password+"' ");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'true' a entrar
	            entrar=true;
	            System.out.println("El usuario y contraseña coinciden --> entrar en la app.");
			} else {
				throw new MiExcepcion() ;
			}
		
		
		return entrar;
	}
	
	
	/**Añadir un nuevo usuario a la BD
	 * Primero comprobar si existe el usuario, si no existe lo añadimos a la BD
	 * Si existe, devolveremos un false que hará que salga un mensaje de error.
	 * @throws SQLException 
	 */
	public boolean AñadirUsuario (String nomLI, String nombreR, String apell, String password) throws MiExcepcion, SQLException{
		
		boolean NoExiste = true; //NO está en la BD

	 //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn from tabla_usuarios where nomLogIn='" +nomLI+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				throw new MiExcepcion();
			} else {
				BaseDeDatos.insertUsuario(nomLI, nombreR, apell, password);
				System.out.println("Usuario añadido.");
			}
		
		return NoExiste;
	}


}
