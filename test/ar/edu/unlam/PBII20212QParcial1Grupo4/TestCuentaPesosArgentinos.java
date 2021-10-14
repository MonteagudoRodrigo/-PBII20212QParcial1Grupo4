package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaPesosArgentinos {

	@Test
	public void alCrearUnaCuentaEnPesosArgentinosGuardaElSaldoInicial() {
		Double saldoEsperado = 1000.0;
		Double saldoInicial = 1000.0;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
	}

	@Test
	public void alDepositarMasDeDiezMilEnUnaCuentaDePesosArgentinosAplicaElInteresDefinido() {
		Double saldoInicial = 1000.0;
		Double saldoDeposito = 11000.0;
		Double saldoEsperado = saldoInicial + (saldoDeposito*1.03);
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		cuenta.depositar(saldoDeposito);
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void alDepositarMenosDeDiezMilEnUnaCuentaDePesosArgentinosNoAplicaElInteresDefinido() {
		Double saldoInicial = 1000.0;
		Double saldoDeposito = 9000.0;
		Double saldoEsperado = saldoInicial + saldoDeposito;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		cuenta.depositar(saldoDeposito);
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnSaldoEnCeroNoGeneraLaExtraccion() {
		Double saldoInicial = 1000.0;
		Double saldoExtraccion = 0.0;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		Boolean pudoExtraer = cuenta.extraer(saldoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnSaldoMayorACeroGeneraLaExtraccion() {
		Double saldoInicial = 1000.0;
		Double saldoExtraccion = 100.0;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		Boolean pudoExtraer = cuenta.extraer(saldoExtraccion);
		
		assertEquals(true, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnSaldoMayorAlSaldoActualNoGeneraLaExtraccion() {
		Double saldoInicial = 1000.0;
		Double saldoExtraccion = 20000.0;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		Boolean pudoExtraer = cuenta.extraer(saldoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
}
