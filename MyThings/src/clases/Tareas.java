package clases;
import java.util.ArrayList;
import java.util.Date;

public class Tareas {

	private Date fecha_i;
	private Date fecha_f;
	private int importancia;
	private String localizacion;
	private int tiempo_v;
	private String descripcion;
	private ArrayList<Contacto> invitado;
	/**
	 * @return the fecha_i
	 */
	public Date getFecha_i() {
		return fecha_i;
	}
	/**
	 * @param fecha_i the fecha_i to set
	 */
	public void setFecha_i(Date fecha_i) {
		this.fecha_i = fecha_i;
	}
	/**
	 * @return the fecha_f
	 */
	public Date getFecha_f() {
		return fecha_f;
	}
	/**
	 * @param fecha_f the fecha_f to set
	 */
	public void setFecha_f(Date fecha_f) {
		this.fecha_f = fecha_f;
	}
	/**
	 * @return the importancia
	 */
	public int getImportancia() {
		return importancia;
	}
	/**
	 * @param importancia the importancia to set
	 */
	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}
	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}
	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	/**
	 * @return the tiempo_v
	 */
	public int getTiempo_v() {
		return tiempo_v;
	}
	/**
	 * @param tiempo_v the tiempo_v to set
	 */
	public void setTiempo_v(int tiempo_v) {
		this.tiempo_v = tiempo_v;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the invitado
	 */
	public ArrayList<Contacto> getInvitado() {
		return invitado;
	}
	/**
	 * @param invitado the invitado to set
	 */
	public void setInvitado(ArrayList<Contacto> invitado) {
		this.invitado = invitado;
	}
	
	
}
