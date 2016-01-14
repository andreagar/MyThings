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
	
	public boolean AñadirContactoLaboral (String nombre, String apell, String email, String movil, String imagen, String empresa,
			String cargo, String tfno_empresa) throws MiExcepcion{
		
		boolean NoExiste = true; //NO está en la BD
		String usuario = frmLogin.txtUsuario.getText();
		try{ //COMPROBAR SI EXISTE ESE USUARIO
			
			//HACEMOS LA CONSULTA
			BaseDeDatos.getConnection();
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select email from tabla_contLaboral where email='" +email+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("El contacto ya existe.");
			} else {
				BaseDeDatos.insertContactoLaboral(nombre, apell, email, movil, imagen, empresa, cargo, tfno_empresa, usuario);
				System.out.println("Contacto añadido.");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return NoExiste;
	}
	
	public ResultSet SeleccionarTareas(){
		
		String usuario = frmLogin.txtUsuario.getText();
		ResultSet consulta=null;
			
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "select * from tabla_contPersonal where nomLogIn = '" + usuario +"'";
			consulta = stmt.executeQuery(query);
		return consulta;
		}catch(Exception e){
		}
		return consulta;
	}
	
	public ResultSet SeleccionarTareas1(){
		
		String usuario = frmLogin.txtUsuario.getText();
		ResultSet consulta=null;
			
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "select * from tabla_contLaboral where nomLogIn = '" + usuario +"'";
			consulta = stmt.executeQuery(query);
		return consulta;
		}catch(Exception e){
		}
		return consulta;
	}
	
	public boolean ModificarContPersonal (String nombre, String apell, String email, String movil, String imagen, 
			String domicilio, String tfno_domicilio, String fecha_n, Personal cont){
		
		String usuario = frmLogin.txtUsuario.getText();
		boolean cambiar = false;
		try{
			Statement stmt = BaseDeDatos.getStatement();
			
			String mvl= Integer.toString(cont.getNum_m());
			String tfno= Integer.toString(cont.getNum_d());
			
			
			String query = "select email from tabla_contPersonal where nomLogIn='" + usuario +"' "
					+ "and nombre='" + cont.getNombre() + "' "
					+ "and apell='" + cont.getApellidos() + "' "
					+ "and movil='" + mvl + "' "
					+ "and imagen='" + cont.getFoto() + "' "
					+ "and domicilio='" + cont.getDomicilio() + "' "
					+ "and tfno_domicilio='" + tfno + "' "
					+ "and fecha_n='" + cont.getNacimiento() + "' "; 
			System.out.println(query);
			ResultSet consulta = stmt.executeQuery(query);
			
			if(consulta.next()){
				String query2 = "update tabla_contPersonal set "
						+ "nombre='" + nombre + "' "
						+ ", apell='" + apell + "' "
						+ ", email='" + email + "' "
						+ ", movil='" + movil + "' "
						+ ", imagen='" + imagen + "' "
						+ ", domicilio='" + domicilio + "' "
						+ ", tfno_domicilio='" + tfno_domicilio + "' "
						+ ", fecha_n='" + fecha_n + "' where email='" + consulta.getString("email") +"' ";
				System.out.println(query2);
				cambiar=true;
				ResultSet cambio = stmt.executeQuery(query2);
			}
		}catch (SQLException e){
		}
		return cambiar;
	}
	
	public void EliminarContactoPersonal(String nombre, String apell, String email, String movil, String imagen, 
			String domicilio, String tfno_domicilio, String fecha_n){
		
		String usuario = frmLogin.txtUsuario.getText();
		
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "delete from tabla_tareas where nomLogIn='" + usuario +"' "
					+ "nombre='" + nombre + "' "
					+ ", apell='" + apell + "' "
					+ ", email='" + email + "' "
					+ ", movil='" + movil + "' "
					+ ", imagen='" + imagen + "' "
					+ ", domicilio='" + domicilio + "' "
					+ ", tfno_domicilio='" + tfno_domicilio + "' "
					+ ", fecha_n='" + fecha_n + "'";
			System.out.println(query);
			ResultSet consulta = stmt.executeQuery(query);
			
			if (consulta.next()){			
				System.out.println("El contacto se ha eliminado");
			}else{
				System.out.println("No se ha eliminado");
			}
		}catch (SQLException e){
		}	
	}	
}
