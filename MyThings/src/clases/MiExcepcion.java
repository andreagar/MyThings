package clases;

public class MiExcepcion extends Exception{

	/** Clase para las excepciones que vamos a utilizar en el proyecto
	 */
	
	private static final long serialVersionUID = 1L;

	public String YaExiste(){
		return "NOMBRE DE USUARIO no disponible.";
	}
	
	public String NoDatos(){
		return "No hay datos."; 
	}
	
	public String SinSeleccionar(){
		return "No se ha seleccionado nada.";
	}
	
	public String NoExiste(){
		return "El usuario o contraseña no son correctos. Compruebe sus credenciales.";
	}
	
}
