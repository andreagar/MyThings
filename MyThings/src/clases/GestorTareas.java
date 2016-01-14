package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import ventanas.frmAltaUsuario;
import ventanas.frmLogin;

public class GestorTareas {

	
	/**Constructor.
	 */
	public GestorTareas(){}
	
	/**Añadir una nueva tarea a la BD
	 */

	public boolean AñadirTarea (int id, String fecha_i, String fecha_f, String importancia, String localizacion,
			int tiempo, String descripcion, String usuario) {
		
		boolean NoExiste = true; //NO está en la BD

		try{ //COMPROBAR SI EXISTE LA TAREA
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select id from tabla_tareas where id='" +id+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("La tarea ya existe.");
			} else {
				BaseDeDatos.insertTarea(id, fecha_i, fecha_f, importancia, localizacion, tiempo, descripcion,usuario);
				System.out.println("Usuario añadido.");
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return NoExiste;
	}
	
	
	public void ModificarTarea (){
		
	}
	
	public void EliminarTarea(String fechaI, String fechaF, String imp, String loc, String tiempo, String desc){
		
		String usuario = frmLogin.txtUsuario.getText();
		
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "delete from tabla_tareas where nomLogIn='" + usuario +"' "
					+ "and fecha_i='" + fechaI + "' "
					+ "and fecha_f='" + fechaF + "' "
					+ "and importancia='" + imp + "' "
					+ "and localizacion='" + loc + "' "
					+ "and tiempo_v=" + tiempo + " "
					+ "and descripcion'" + desc + "' ";
			System.out.println(query);
			ResultSet consulta = stmt.executeQuery(query);
			
			if (consulta.next()){			
				System.out.println("la tarea se ha eliminado");
			}else{
				System.out.println("no se ha eliminado");
			}
		}catch (SQLException e){
		}	
	}	
	
	public ResultSet SeleccionarTareas(){
		
		String usuario = frmLogin.txtUsuario.getText();
		ResultSet consulta=null;
			
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "select * from tabla_tareas where nomLogIn = '" + usuario +"'";
			consulta = stmt.executeQuery(query);
		return consulta;
		}catch(Exception e){
		}
		return consulta;
	}
}
