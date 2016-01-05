package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorContactos { //modificar los atributos  TODO!

	/**Añadir un nuevo contacto a la BD
	 * Primero comprobar si existe el contacto, si no existe lo añadimos a la BD
	 * Si existe, devolveremos un false que hará que salga un mensaje de error.
	 */
	public boolean AñadirContactoPersonal (String nomLI, String nombreR, String apell, String password) throws MiExcepcion{
		
		boolean NoExiste = true; //NO está en la BD

		try{ //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			BaseDeDatos.getConnection();
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn from tabla_usuarios where nomLogIn='" +nomLI+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("El usuario ya existen.");
			} else {
				BaseDeDatos.insertUsuario(nomLI, nombreR, apell, password);
				System.out.println("Usuario añadido.");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return NoExiste;
	}
	
	public boolean AñadirContactoLaboral (String nomLI, String nombreR, String apell, String password) throws MiExcepcion{
		
		boolean NoExiste = true; //NO está en la BD

		try{ //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			BaseDeDatos.getConnection();
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select nomLogIn from tabla_usuarios where nomLogIn='" +nomLI+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("El usuario ya existen.");
			} else {
				BaseDeDatos.insertUsuario(nomLI, nombreR, apell, password);
				System.out.println("Usuario añadido.");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return NoExiste;
	}
}
