package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

/** Clase para gestionar el añadido y el LogIn de los usuarios.
 */
public class GestorUsuarios {

	HashSet<Usuarios> setUsuarios;

	/**Constructor.
	 */
	public GestorUsuarios(){		
		setUsuarios = new HashSet<Usuarios>();
	}
	
	/**Log In del usuario a la aplicación
	 * Comprobamos de si existe el usuario o no, para ello utilizamos un HashSet de Usuarios y comprobamos que
	 * el usuario y la password enviados coinciden.
	 * Si se entra como el usuario "admin" y con contraseña "admin" (no está en la BD), entra también dentro 
	 * de la aplicación.
	 * Si no existe, devolveremos un false que hará que salga un mensaje de que ese usuario no está registrado.
	 */
	public boolean Login (String usuario, String password){
		
		boolean entrar = false;
		
		//pasamos a un HashSet todos los usuarios registrados en la BD, para saber si existe
		try{
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn,password from tabla_usuarios");

			while(consulta.next()){ //meter los usuarios en la lista
				String nomLI= consulta.getString("nomLogIn");
				String pw= consulta.getString("password");
			
				Usuarios user = new Usuarios (nomLI,"","",pw);//creamos el usuario con esos parámetros 
				setUsuarios.add(user); //agregar usuario a la lista
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		//comprobamos que ese usuario con esa contraseña existe
		for (Usuarios u: setUsuarios){
			if ((usuario.equals(u.getNomLogIn())) && (password.equals(u.getPassword()))) {
				entrar = true;
			}
		}
		
		//usuario que siempre entra
		if (usuario.equals("admin") && password.equals("admin")){
			entrar = true;
		}
			
		return entrar;
	}
	
	
	/**Añadir un nuevo usuario a la BD
	 * Primero comprobar si existe el usuario, si existe lo añadimos a la BD
	 * Si no existe, devolveremos un false que hará que salga un mensaje de error.
	 */
	public boolean AñadirUsuario (String nomLI, String nombreR, String apell, String password) throws MiExcepcion{
		
		boolean NoExiste = true; //no está en la BD
		ResultSet consulta = null;
		//comprobar si existe o no
		try {
			Statement stmt = BaseDeDatos.getStatement();
			consulta = stmt.executeQuery("select nomLogIn,nombreReal from tabla_usuarios where nomLogIn="+nomLI+" and password= "+password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if (consulta != null) {
			NoExiste = false; //está en la BD-->existe
		}
		
		//enviarlo a la BD si NO existe
		if (NoExiste==true)
			BaseDeDatos.insertUsuario(nomLI, nombreR, apell, password);
		
		return NoExiste;
	}
	

}
