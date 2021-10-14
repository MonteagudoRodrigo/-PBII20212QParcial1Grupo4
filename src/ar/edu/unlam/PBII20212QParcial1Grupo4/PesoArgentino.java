package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class PesoArgentino extends Cuenta{
	//TODO: Hernán Albornoz
	
	private final static Double MINIMO_DEPOSITO_PARA_INTERES=10000.00; 
	private final static Double INTERES=1.03;
	private Double cotizacionDolar;
	private Double cotizacionBitcoin;
	
	public PesoArgentino(Double saldo) {
		super(saldo);
		
		this.cotizacionDolar = 185.00;
		this.cotizacionBitcoin = 9000000.00;
	}
	
	public Double getCotizacionDolar() {
		return cotizacionDolar;
	}



	public Double getCotizacionBitcoin() {
		return cotizacionBitcoin;
	}


	@Override
	public void depositar(Double monto) {
		Double resultadoMonto=monto;
		if(monto>=MINIMO_DEPOSITO_PARA_INTERES) {
			resultadoMonto*=INTERES;
		}
		super.depositar(resultadoMonto);
	}

	
	
}
