package clases;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ventanas.frmLogin;

public class GestorContactos { 

	/**Añadir un nuevo contacto a la BD
	 * Primero comprobar si existe el contacto, si no existe lo añadimos a la BD
	 * Si existe, devolveremos un false que hará que salga un mensaje de error.
	 */
	public boolean AñadirContactoPersonal (String nombre, String apell, String email, String movil, String imagen, 
			String domicilio, String tfno_domicilio, String fecha_n) throws MiExcepcion{
		
		boolean NoExiste = true; //NO está en la BD
		String usuario = frmLogin.txtUsuario.getText();
		try{ //COMPROBAR SI EXISTE EL CONTACTO
			
			//HACEMOS LA CONSULTA
			BaseDeDatos.getConnection();
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select email from tabla_contPersonal where email='" +email+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("El contacto ya existe.");
			} else {
				BaseDeDatos.insertContactoPersonal(nombre, apell, email, movil, imagen, domicilio, tfno_domicilio, fecha_n, usuario);
				System.out.println("Contacto añadido.");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return NoExiste;
	}
	
	public boolean AñadirContactoLaboral (String nombre, String apell, String email, String movil, Blob imagen, String empresa,
			String cargo, String tfno_empresa, String nomLogIn) throws MiExcepcion{
		
		boolean NoExiste = true; //NO está en la BD

		try{ //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			BaseDeDatos.getConnection();
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select email from tabla_contLaboral where email='" +email+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("El contacto ya existe.");
			} else {
				BaseDeDatos.insertContactoLaboral(nombre, apell, email, movil, imagen, empresa, cargo, tfno_empresa, nomLogIn);
				System.out.println("Contacto añadido.");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return NoExiste;
	}
}
