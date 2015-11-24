package clases;

public class Excepcion extends Exception{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String Informar(){
		
		return "El usuario ya estaba dado de alta.";
	}
	
	public String NoDatos(){
		return "No hay datos";
	}
}
