package ar.edu.unlam.PBII20212QParcial1Grupo4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DolarEstadounidense extends Cuenta implements Compra, Venta {
	private final static Double INTERES = 1.05;
	private final static Double LIMITE_COMPRA = 1000.0;
	private Integer mesUltimaCompra;
	private Double saldoParcial;

	public DolarEstadounidense(Double saldo) {
		super(saldo);
		this.saldoParcial = 0.00;
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

	public Boolean vender(PesoArgentino cuentaCredito, Double montoAVender) {
		if (montoAVender <= saldo && montoAVender > 0) {
			this.extraer(montoAVender);
			cuentaCredito.depositar(montoAVender * cuentaCredito.getCotizacionDolar());

			return true;
		}
		return false;
	}

	public Boolean comprar(PesoArgentino cuentaDebito, Double montoAComprar) {
		Boolean compraValida = false;
		if (montoAComprar > LIMITE_COMPRA || montoAComprar <= 0) {
			
			return false;
		}

		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Integer month = localDate.getMonthValue();

		if (cuentaDebito.getSaldo() >= montoAComprar * cuentaDebito.getCotizacionDolar()) {
			if (this.mesUltimaCompra == 0 || this.mesUltimaCompra > 0 && this.mesUltimaCompra != month) {
				this.mesUltimaCompra = month;
				saldoParcial = montoAComprar;
				compraValida = true;
				
			} else if (this.mesUltimaCompra > 0 && this.mesUltimaCompra == month && (saldoParcial+montoAComprar)< 1000) {
				saldoParcial += montoAComprar;
				compraValida = true;
			}
			if(compraValida) {
			cuentaDebito.extraer(montoAComprar * cuentaDebito.getCotizacionDolar());
			this.depositar(montoAComprar);
			return true;
			}
		}

		return false;
	}

}