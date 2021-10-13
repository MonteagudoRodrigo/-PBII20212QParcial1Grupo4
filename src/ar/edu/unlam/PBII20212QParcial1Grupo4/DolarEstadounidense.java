package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class DolarEstadounidense extends Cuenta implements Compra,Venta{

	public DolarEstadounidense(Double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositar(Double monto) {
if(monto >= 1) {
	saldo += (monto *1.05);
}else {
	super.depositar(monto);
}
		
	}

	@Override
	public Boolean extraer(Double monto) {
		// TODO Auto-generated method stub
		return super.extraer(monto);
	}
	
	@Override
	public Boolean vender(Double monto) {
		
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Boolean comprar(Double monto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
