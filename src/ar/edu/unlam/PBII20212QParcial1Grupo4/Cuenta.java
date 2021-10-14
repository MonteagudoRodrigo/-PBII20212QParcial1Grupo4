package ar.edu.unlam.PBII20212QParcial1Grupo4;

abstract public class Cuenta {
	public Double saldo;
	
	

	public Cuenta() {
		this.saldo = 0.0;
	}
	
	public void depositar(Double monto) {
		if(monto > 0) {
			this.saldo += monto;
		}
	}
	
	public Boolean extraer(Double monto) {
		if (this.saldo >= monto && monto > 0) {
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
	
	public TipoCuenta getTipo(){
		return null;
	}
}
