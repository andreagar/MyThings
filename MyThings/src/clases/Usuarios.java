package clases;

import java.io.Serializable;

public class Usuarios implements Serializable{
	
	/**
	 * Clase para los usuarios registrados en la aplicación
	 * @param nomLogIn		El nombre con el que se registró el usuario y no puede haber dos usuarios con el mismo
	 * @param nombreReal 	El nombre real del usuario (y varios pueden tener el mismo)
	 * @param apellidos		Apellidos del usuario
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String nomLogIn; //clave primaria
	private String nombreReal; //nombre real
	private String apellidos;
	private String password;
	
	public Usuarios(){
		
	}
	
	
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
	
//	//PARA QUE NO SE REPITA (LOS Q CREA AUTOMATICAMENTE)
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((nomLogIn == null) ? 0 : nomLogIn.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Usuarios other = (Usuarios) obj;
//		if (nomLogIn == null) {
//			if (other.nomLogIn != null)
//				return false;
//		} else if (!nomLogIn.equals(other.nomLogIn))
//			return false;
//		return true;
//	}
	

	//LOS QUE UTILIZAMOS CON JAVIER CERRO
	
	public int hashCode(){
		return this.getNomLogIn().hashCode();
	}
	
	public boolean equals(Object o){
		Usuarios a = (Usuarios) o;
		return this.getNomLogIn().equals(a.getNomLogIn());
	}
	

}
