package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Bitcoin extends Cuenta implements Venta, Compra {

	private static final Double FEE_BLOCKCHAIN = 0.015;

	public Bitcoin(Double saldo, Double cotizacion) {
		super(saldo);
		
	}

	@Override
	public Boolean extraer(Double monto) {
		return super.extraer(monto - 2*FEE_BLOCKCHAIN);
	}

	public Boolean comprar(PesoArgentino cuentaDebito, Double montoAComprar) {
		if(montoAComprar > FEE_BLOCKCHAIN) {
			Double montoADebitar = montoAComprar * cuentaDebito.getCotizacionBitcoin();
			
			if (cuentaDebito.getSaldo() * cuentaDebito.getCotizacionBitcoin() >= montoADebitar) {
				cuentaDebito.extraer(montoADebitar);
				this.depositar(montoAComprar);
				return true;
			}
		}
		return false;
	}

	public Boolean vender(PesoArgentino cuentaCredito, Double montoAVender) {
		if (montoAVender > 0 && montoAVender <= saldo) {
			Double montoACredito = montoAVender * cuentaCredito.getCotizacionBitcoin();
			this.extraer(montoACredito);
			cuentaCredito.depositar(montoACredito / cuentaCredito.getCotizacionBitcoin());
			return true;
		}
		return false;
	}


}
