package clases;

import java.io.Serializable;

public class Usuarios implements Serializable{
	
	/**
	 * Clase para los usuarios registrados en la aplicación
	 * @param nomLogIn		El nombre con el que se registró el usuario y no puede haber dos usuarios con el mismo
	 * @param nombreReal 	El nombre real del usuario (y otros usuarios pueden tener el mismo)
	 * @param apellidos		Apellidos del usuario
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String nomLogIn; //clave primaria
	private String nombreReal; //nombre real
	private String apellidos;
	private String password;
	
	public Usuarios(){}
	
	public Usuarios(String nomLogIn, String nombreReal, String apellidos, String password) {
		super();
		this.nomLogIn = nomLogIn;
		this.nombreReal = nombreReal;
		this.apellidos = apellidos;
		this.password = password;
	}

	public String getNomLogIn() {
		return nomLogIn;
	}
	public void setNomLogIn(String nomLogIn) {
		this.nomLogIn = nomLogIn;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
