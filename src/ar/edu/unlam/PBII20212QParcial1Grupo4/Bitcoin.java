package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Bitcoin extends Cuenta implements Venta, Compra {

	private static final Double FEE_BLOCKCHAIN_EN_DOLARES = 4.27;

	public Bitcoin(Double monto, Double cotizacion) {
		super();
		
		this.depositar(monto);
		this.cotizacionSobreDolar = 50.000;
	}

	@Override
	public Boolean extraer(Double monto) {
		return super.extraer(monto - 2*FEE_BLOCKCHAIN_EN_DOLARES);
	}

	public Boolean comprar(Cuenta cuentaDebito, Double montoAComprar) {
		if(montoAComprar > FEE_BLOCKCHAIN_EN_DOLARES) {
			Double montoADebitar = montoAComprar * cotizacionSobreDolar;
			
			if (cuentaDebito.getSaldo() * cuentaDebito.cotizacionSobreDolar >= montoADebitar) {
				cuentaDebito.extraer(montoADebitar);
				this.depositar(montoAComprar);
				return true;
			}
		}
		return false;
	}

	public Boolean vender(Cuenta cuentaCredito, Double montoAVender) {
		if (montoAVender > 0 && montoAVender <= saldo) {
			Double montoACredito = montoAVender * cotizacionSobreDolar;
			this.extraer(montoACredito);
			cuentaCredito.depositar(montoACredito / cuentaCredito.cotizacionSobreDolar);
			return true;
		}
		return false;
	}
	
}
