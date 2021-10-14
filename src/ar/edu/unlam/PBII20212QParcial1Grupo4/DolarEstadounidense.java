package ar.edu.unlam.PBII20212QParcial1Grupo4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DolarEstadounidense extends Cuenta implements Compra, Venta {
	private final static Double INTERES = 1.05;
	private final static Double LIMITE_COMPRA = 1000.0;
	private Integer mesUltimaCompra;
	private Double saldoParcial;

	public DolarEstadounidense(Double monto) {
		super();
		
		this.depositar(monto);
		this.mesUltimaCompra = 0;
		this.saldoParcial = 0.00;
	}

	@Override
	public void depositar(Double monto) {
		super.depositar(monto * INTERES);
	}

	@Override
	public Boolean extraer(Double monto) {
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

		if (cuentaDebito.getSaldo() >= montoAComprar * cuentaDebito.getCotizacionDolar()) {
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Integer month = localDate.getMonthValue();
			
			if (this.mesUltimaCompra == 0 || this.mesUltimaCompra > 0 && this.mesUltimaCompra != month) {
				this.mesUltimaCompra = month;
				saldoParcial = montoAComprar;
				
				compraValida = true;
				
			} else if (this.mesUltimaCompra > 0 && this.mesUltimaCompra == month && (saldoParcial+montoAComprar) <= LIMITE_COMPRA) {
				saldoParcial += montoAComprar;
				
				compraValida = true;
			}
			
			if(compraValida) {
				cuentaDebito.extraer(montoAComprar * cuentaDebito.getCotizacionDolar());
				super.depositar(montoAComprar);
				return true;
			}
		}

		return false;
	}

}