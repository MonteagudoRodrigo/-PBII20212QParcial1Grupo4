package ar.edu.unlam.PBII20212QParcial1Grupo4;

abstract public class Cuenta {
	public Double saldo;

	public void depositar(Double monto) {
		this.saldo += monto;
	}
	
	public Boolean extraer(Double monto) {
		if (this.saldo >= monto) {
			this.saldo -= monto;
			
			return true;
		}
		
		return false;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
