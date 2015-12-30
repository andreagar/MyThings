package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class GestorTareas {

	/**Constructor.
	 */
	public GestorTareas(){}
	
	/**Añadir una nueva tarea a la BD
	 */
	public void AñadirTarea (int id, Date fecha_i, Date fecha_f, String importancia, String localizacion,
			int tiempo, String descripcion, Contacto invitado, String password) {
		BaseDeDatos.insertTarea(id, fecha_i, fecha_f, importancia, localizacion, tiempo, descripcion, invitado);
	}
	
	
	//tenemos que saber q cuando se elige una tarea su id
	public void ModificarTarea (){
		
	}
	
	public void EliminarTarea(){
		
	}
}