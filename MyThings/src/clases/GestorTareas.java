package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ventanas.frmAltaUsuario;
import ventanas.frmLogin;

public class GestorTareas {

	/**Constructor.
	 */
	public GestorTareas(){}
	
	/**Añadir una nueva tarea a la BD
	 */
	public void AñadirTarea (int id, Date fecha_i, Date fecha_f, String importancia, String localizacion,
			int tiempo, String descripcion) {
		BaseDeDatos.insertTarea(id, fecha_i, fecha_f, importancia, localizacion, tiempo, descripcion);
	}
	
	
	//tenemos que saber q cuando se elige una tarea su id
	public void ModificarTarea (){
		
	}
	
	public void EliminarTarea(){
		
	}

	public ArrayList<Tareas> ArrayTareas() {
		String usuario = frmLogin.txtUsuario.getText();  //hemos cambiado txtNomLogIn a static
		BaseDeDatos.getConnection();
		Statement stmt = BaseDeDatos.getStatement();
		ArrayList array = new ArrayList();
		ResultSet consulta = null;
		try{
		consulta = stmt.executeQuery("select * from tabla_tareas where "
				+ "nomLogIn='"+usuario+"' ");
		ResultSetMetaData rsmd = consulta.getMetaData();
		int columnas = rsmd.getColumnCount();
		
		while(consulta.next()){
			HashMap fila = new HashMap();
			array.add(fila);
			
			for (int i=1;i<=columnas; i++){
				fila.put(rsmd.getColumnName(i), consulta.getObject(i));
			}
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
	}
		
		return array;
		
		
	
	}
}