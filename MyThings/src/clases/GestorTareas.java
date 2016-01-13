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

	public boolean AñadirTarea (int id, Date fecha_i, Date fecha_f, String importancia, String localizacion,
			int tiempo, String descripcion, String usuario) {
		
		boolean NoExiste = true; //NO está en la BD

		try{ //COMPROBAR SI EXISTE LA TAREA
			
			//HACEMOS LA CONSULTA
			//BaseDeDatos.conexion("MyThings.BD");
			Statement stmt = BaseDeDatos.getStatement();
			ResultSet consulta = stmt.executeQuery("select id from tabla_tareas where id='" +id+ "'");
			
			if(consulta.next()){ //Si al hacer la consulta encuentra un registro identico, asigna 'false' a NoExiste
				NoExiste = false;
				System.out.println("La tarea ya existe.");
			} else {
				BaseDeDatos.insertTarea(id, fecha_i, fecha_f, importancia, localizacion, tiempo, descripcion,usuario);
				System.out.println("Usuario añadido.");
			}
			//BaseDeDatos.finConexion();
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return NoExiste;
	}
	
	
	//tenemos que saber q cuando se elige una tarea su id
	public void ModificarTarea (){
		
	}
	
	public void EliminarTarea(){
		
	}	
	
	public ArrayList<Tareas> SeleccionarTareas(){
		
		String usuario = frmLogin.txtUsuario.getText();
		
		ArrayList<Tareas> listaTareas = new ArrayList<Tareas>();
		Tareas tarea = new Tareas();
			
		try{
			Statement stmt = BaseDeDatos.getStatement();
			String query = "select * from tabla_tareas where nomLogIn = '" + usuario +"'";
			//String query = "select * from tabla_tareas";
			//System.out.println(query);
			ResultSet consulta = stmt.executeQuery(query);
			
//			System.out.println("es usuario es: "+usuario);
//			if (consulta.next()){
//				System.out.println("Tenemos resultado");
//				//consulta.first();
//				System.out.println(consulta.getString("descripcion"));
//			}				
//			else{
//				System.out.println("No tenemos resultado");	
//			}
			
			while (consulta.next()){
				
				System.out.println("entra dentro de la consulta");
//				System.out.println("Aqui estamos");
//				System.out.println(consulta.getString("descripcion"));
//				System.out.println(consulta.getString("nomLogIn"));
				
					tarea.setId(consulta.getInt("id"));
					tarea.setFecha_i(consulta.getDate("fecha_i"));
					tarea.setFecha_f(consulta.getDate("fecha_f") );
					tarea.setImportancia(consulta.getString("importancia")); 
					tarea.setLocalizacion(consulta.getString("localizacion"));
					tarea.setTiempo_v((consulta.getInt("tiempo_v")));
					tarea.setDescripcion(consulta.getString("descripcion"));
						
				listaTareas.add(tarea);
				System.out.println("la tarea se ha hecho perdectamente :D");
			}
		}catch (SQLException e){
		}
		return listaTareas;
	}
}