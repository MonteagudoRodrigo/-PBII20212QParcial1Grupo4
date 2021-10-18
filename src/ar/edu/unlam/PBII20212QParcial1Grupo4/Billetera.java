package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Billetera {
	private String nombre;
	private String apellido;
	private Integer dni;
	private Cuenta cuentas[];

	public Billetera(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
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

	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public Boolean agregarCuenta(Cuenta cuentaAAgregar) {
		return agregarCuentaAArrayDeCuentas(cuentaAAgregar);
	}
	
	// Agrega un cuenta al final del array de cuentas
	private Boolean agregarCuentaAArrayDeCuentas(Cuenta nuevaCuenta) {
		if(cuentas == null) {
			this.cuentas = new Cuenta[] {nuevaCuenta};
		} else {
			Cuenta[] nuevoArrayDeCuentas = new Cuenta[cuentas.length + 1];
			
			for (int i = 0; i < cuentas.length; i++) {
				nuevoArrayDeCuentas[i] = cuentas[i];
			}
			if(yaEsisteTipoDeCuentaEnBilletera(nuevaCuenta)) return false;
			nuevoArrayDeCuentas[cuentas.length] = nuevaCuenta;
			
			this.cuentas = nuevoArrayDeCuentas;
		}
		return true;
	}

	private Boolean yaEsisteTipoDeCuentaEnBilletera(Cuenta nuevaCuenta) {
		for (Integer i = 0; i < cuentas.length; i++) {
			if (cuentas[i].getTipo() == nuevaCuenta.getTipo()) {
				return true;
			}
		}
		return false;
	}
}
