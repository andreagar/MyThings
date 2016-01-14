package clases;
import java.util.Date;

public class Personal extends Contacto{

	private String domicilio;
	private int num_d;
	private String nacimiento;
	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	/**
	 * @return the num_d
	 */
	public int getNum_d() {
		return num_d;
	}
	/**
	 * @param num_d the num_d to set
	 */
	public void setNum_d(int num_d) {
		this.num_d = num_d;
	}
	/**
	 * @return the nacimiento
	 */
	public String getNacimiento() {
		return nacimiento;
	}
	/**
	 * @param nacimiento the nacimiento to set
	 */
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	
}
