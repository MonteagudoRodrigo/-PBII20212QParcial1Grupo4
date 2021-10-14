package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Bitcoin extends Cuenta implements Venta, Compra {

	private static final Double FEE_BLOCKCHAIN = 0.015;

	public Bitcoin(Double monto) {
		super();
		
		this.depositar(monto);
	}

	@Override
	public Boolean extraer(Double monto) {
		return super.extraer(monto - 2 * FEE_BLOCKCHAIN);
	}

	public Boolean comprar(PesoArgentino cuentaDebito, Double montoAComprar) {
		if (montoAComprar > FEE_BLOCKCHAIN) {

			if (cuentaDebito.getSaldo() >= montoAComprar * cuentaDebito.getCotizacionBitcoin()) {
				cuentaDebito.extraer(montoAComprar * cuentaDebito.getCotizacionBitcoin());
				this.depositar(montoAComprar);
				return true;
			}
		}
		return false;
	}

	public Boolean vender(PesoArgentino cuentaCredito, Double montoAVender) {
		if (montoAVender > 0 && montoAVender <= saldo) {
			this.extraer(montoAVender);
			cuentaCredito.depositar(montoAVender * cuentaCredito.getCotizacionBitcoin());
			return true;
		}
		return false;
	}

}
