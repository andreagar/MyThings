package clases;
import java.util.ArrayList;
import java.util.Date;

public class Tareas {

	private int id; //clave primaria
	private String fecha_i;
	private String fecha_f;
	private String importancia;
	private String localizacion;
	private int tiempo_v;
	private String descripcion;
	
	public Tareas(){
	}
	
//	public Tareas(Date fecha_i, Date fecha_f, String importancia, String localizacion, int tiempo_v,
//			String descripcion) {
//		super();
//		this.fecha_i = fecha_i;
//		this.fecha_f = fecha_f;
//		this.importancia = importancia;
//		this.localizacion = localizacion;
//		this.tiempo_v = tiempo_v;
//		this.descripcion = descripcion;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_i() {
		return fecha_i;
	}
	public void setFecha_i(String fecha_i) {
		this.fecha_i = fecha_i;
	}
	public String getFecha_f() {
		return fecha_f;
	}
	public void setFecha_f(String fecha_f) {
		this.fecha_f = fecha_f;
	}
	public String getImportancia() {
		return importancia;
	}
	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public int getTiempo_v() {
		return tiempo_v;
	}
	public void setTiempo_v(int tiempo_v) {
		this.tiempo_v = tiempo_v;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
