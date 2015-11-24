package clases;

public class MiExcepcion extends Exception{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String YaExiste(){
		
		return "El usuario ya estaba dado de alta.";
	}
	
	public String NoDatos(){
		return "No hay datos.";
		
	}
	
	public String NoExiste(){
		return "El usuario no existe.";
	}
	
}
