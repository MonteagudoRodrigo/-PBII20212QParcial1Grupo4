package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class PesoArgentino extends Cuenta{
	//TODO: Hernán Albornoz
	
	private final static Double MINIMO_DEPOSITO_PARA_INTERES=10000.00; 
	private final static Double INTERES=1.03;
	
	public PesoArgentino(Double saldo) {
		super(saldo);
		this.cotizacionSobreDolar = 0.01;
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
