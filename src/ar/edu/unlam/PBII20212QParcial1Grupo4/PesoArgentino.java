package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class PesoArgentino extends Cuenta{	
	private final static Double MINIMO_DEPOSITO_PARA_INTERES=10000.00; 
	private final static Double INTERES=1.03;
	
	public PesoArgentino(Double monto) {
		super();
		
		this.depositar(monto);
		
		this.cotizacionSobreDolar = 0.01;
	}
	
	@Override
	public void depositar(Double monto) {
		Double resultadoMonto = monto;
		if(monto > PesoArgentino.MINIMO_DEPOSITO_PARA_INTERES) {
			resultadoMonto *= PesoArgentino.INTERES;
		}
		
		super.depositar(resultadoMonto);
	}

	
	
}
