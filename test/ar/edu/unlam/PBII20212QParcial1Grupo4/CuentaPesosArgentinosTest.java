package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaPesosArgentinosTest {

	@Test
	public void alCrearUnaCuentaEnPesosArgentinosDepositaElMontoInicial() {
		Double montoEsperado = 1000.0;
		Double montoInicial = 1000.0;
		
		Cuenta cuenta = new PesoArgentino(montoInicial);
		
		assertEquals(montoEsperado, cuenta.getSaldo());
	}

	@Test
	public void alDepositarMasDeDiezMilEnUnaCuentaDePesosArgentinosAplicaElInteresDefinido() {
		Double montoInicial = 1000.0;
		Double montoDeposito = 11000.0;
		Double montoEsperado = montoInicial + (montoDeposito*1.03);
		
		Cuenta cuenta = new PesoArgentino(montoInicial);
		cuenta.depositar(montoDeposito);
		
		assertEquals(montoEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void alDepositarMenosDeDiezMilEnUnaCuentaDePesosArgentinosNoAplicaElInteresDefinido() {
		Double montoInicial = 1000.0;
		Double montoDeposito = 9000.0;
		Double montoEsperado = montoInicial + montoDeposito;
		
		Cuenta cuenta = new PesoArgentino(montoInicial);
		cuenta.depositar(montoDeposito);
		
		assertEquals(montoEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnMontoEnCeroNoGeneraLaExtraccion() {
		Double montoInicial = 1000.0;
		Double montoExtraccion = 0.0;
		
		Cuenta cuenta = new PesoArgentino(montoInicial);
		Boolean pudoExtraer = cuenta.extraer(montoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnMontoMayorACeroGeneraLaExtraccion() {
		Double montoInicial = 1000.0;
		Double montoExtraccion = 100.0;
		
		Cuenta cuenta = new PesoArgentino(montoInicial);
		Boolean pudoExtraer = cuenta.extraer(montoExtraccion);
		
		assertEquals(true, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDePesosArgentinosUnMontoMayorAlSaldoActualNoGeneraLaExtraccion() {
		Double saldoInicial = 1000.0;
		Double saldoExtraccion = 20000.0;
		
		Cuenta cuenta = new PesoArgentino(saldoInicial);
		Boolean pudoExtraer = cuenta.extraer(saldoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
}
