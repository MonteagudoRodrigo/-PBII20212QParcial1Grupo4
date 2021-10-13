package ar.edu.unlam.PBII20212QParcial1Grupo4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DolarEstadounidense extends Cuenta implements Compra, Venta {
	private final static Double INTERES = 1.05;
	private final static Double LIMITE_COMPRA = 1000.0;
	private Integer mesUltimaCompra;

	public DolarEstadounidense(Double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositar(Double monto) {

		super.depositar(monto * INTERES);

	}

	@Override
	public Boolean extraer(Double monto) {
		// TODO Auto-generated method stub
		return super.extraer(monto);
	}

	public Boolean vender(Cuenta cuentaCredito, Double montoAVender) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean comprar(Cuenta cuentaDebito, Double montoAComprar) {
		if (montoAComprar > LIMITE_COMPRA || montoAComprar <= 0) {
			return false;
		}
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Integer month = localDate.getMonthValue();
		
		
		if (cuentaDebito.getSaldo() >= montoAComprar * cuentaDebito.cotizacion) {
			if (this.mesUltimaCompra > 0)

				this.mesUltimaCompra = month;
			cuentaDebito.extraer(montoAComprar * cuentaDebito.cotizacion);
			super.depositar(montoAComprar);
			return true;
		}

		return false;
	}

}