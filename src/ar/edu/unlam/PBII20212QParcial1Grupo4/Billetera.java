package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Billetera {
	private String nombre;
	private String apellido;
	private Integer dni;
	private Cuenta cuentas[];
	private final static Integer MAXIMOS_DE_CUENTAS=3;
	
	public Billetera(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuentas = new Cuenta [MAXIMOS_DE_CUENTAS];
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public Cuenta[] getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}
}
