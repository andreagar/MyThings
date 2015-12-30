package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

/** M�todos �tiles para base de datos.
 * Clase con m�todos est�ticos para gestionar una sola base de datos
 * @author Andoni Egu�luz Mor�n
 * Facultad de Ingenier�a - Universidad de Deusto
 */
public class BaseDeDatos {

	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection conexion( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			System.out.println( "Perfecta conexi�n con la BD!! Se ha podido conectar con " + nombreBD );
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexi�n!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexi�n!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Cierra la conexi�n con la Base de Datos
	 */
	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#conexion()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	// ------------------------------------
	// CREACI�N TABLAS
	// ------------------------------------
		
	/** Crea una tabla de los usuarios de la aplicaci�n en una base de datos (si no exist�a ya).
	 * Debe haberse inicializado la conexi�n correctamente.
	*/
	public static void crearTablaUsuario() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table tabla_usuarios " +
				"(nomLogIn string, nombreReal string, apellidos string" +
				", password string)");
			System.out.println("La tabla_usuario se ha creado.");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			System.out.println("La tabla_usuario ya existe.");
			// e.printStackTrace();  
		}
	}
	
	/**A�adir un nuevo usuario a la BD.
	 */
	public static void insertUsuario( String nomLogIn, String nomReal, String apellidos, String password ) {
		
		String sent = "insert into tabla_usuarios values(" +
				"'" + nomLogIn + "', " +
				"'" + nomReal + "', " +
				"'" + apellidos + "', " +
				"'" + password + "')";
		try {
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
			e.printStackTrace();
		}
	}
	
	
	/** Crea una tabla de las tareas de un usuario en una base de datos (si no exist�a ya).
	 * Debe haberse inicializado la conexi�n correctamente.
	*/
	public static void crearTablaTareas() {
		//de la de contacto no estoy muy segura de que est� bien!!!!!
		//y de lo de references tampoco!!!!
		if (statement==null) return;
		try {
			statement.executeUpdate("create table tabla_tareas " +
				"(nomLogIn string references tabla_usuarios (nomLogIn),id int, fecha_i date, fecha_f date, importancia int, localizacion string, tiempo_v int" +
				", descripcion string, invitado contacto)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}	
	
	
	/**A�adir una nueva tarea a la BD.
	 */
	public static void insertTarea( int id, Date fecha_i, Date fecha_f, String importancia, String localizacion,
			int tiempo, String descripcion, Contacto invitado) {
		
		String sent = "insert into tabla_tareas values(" +
				"'" + id + "', " +
				"'" + fecha_i + "', " +
				"'" + fecha_f + "', " +
				"'" + importancia + "', " +
				"'" + localizacion + "', " +
				"'" + tiempo + "', " +
				"'" + descripcion + "', " +
				"'" + invitado + "')";
		try {
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
			e.printStackTrace();
		}
	}
	
	/** Crea una tabla de los contactos de un usuario en una base de datos (si no exist�a ya).
	 * Debe haberse inicializado la conexi�n correctamente.
	*/
	public static void crearTablaContactos() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table fichero_multimedia " +
				"(nombre string, apellidos string, num_m int, email string, foto image)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
}
