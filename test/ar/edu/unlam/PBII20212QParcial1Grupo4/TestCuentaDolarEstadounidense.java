package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaDolarEstadounidense {

	@Test
	public void alCrearUnaCuentaEnDolaresEstadounidensesDepositaElMontoInicial() {
		Double montoEsperado = 1050.0;
		Double montoInicial = 1000.0;
		
		Cuenta cuenta = new DolarEstadounidense(montoInicial);
		
		assertEquals(montoEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void alExtraerEnUnaCuentaDeDolaresEstadounidensesUnMontoEnCeroNoGeneraLaExtraccion() {
		Double montoInicial = 1000.0;
		Double montoExtraccion = 0.0;
		
		Cuenta cuenta = new DolarEstadounidense(montoInicial);
		Boolean pudoExtraer = cuenta.extraer(montoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDeDolaresEstadounidensesUnMontoMayorACeroGeneraLaExtraccion() {
		Double montoInicial = 1000.0;
		Double montoExtraccion = 100.0;
		
		Cuenta cuenta = new DolarEstadounidense(montoInicial);
		Boolean pudoExtraer = cuenta.extraer(montoExtraccion);
		
		assertEquals(true, pudoExtraer);
	}
	
	@Test
	public void alExtraerEnUnaCuentaDeDolaresEstadounidensesUnMontoMayorAlSaldoActualNoGeneraLaExtraccion() {
		Double saldoInicial = 1000.0;
		Double saldoExtraccion = 20000.0;
		
		Cuenta cuenta = new DolarEstadounidense(saldoInicial);
		Boolean pudoExtraer = cuenta.extraer(saldoExtraccion);
		
		assertEquals(false, pudoExtraer);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesNoPermiteComprarMasDeMil() {
		Double montoInicial = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra = 2000.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra);
		
		assertEquals(false, compraValida);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesPermiteHastaMil() {
		Double montoInicial = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra = 1000.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra);
		
		assertEquals(true, compraValida);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesAceptaUnaCompraMenorAMil() {
		Double montoInicial = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra = 10.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra);
		
		assertEquals(true, compraValida);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesAceptaMasDeUnaCompraEnUnMismoMesSiLaSumaDeEllasDaMenorAMil() {
		Double montoInicial = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra_1 = 500.0;
		Double saldoCompra_2 = 500.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		cuenta.comprar(cuentaPesos, saldoCompra_1);
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra_2);
		
		assertEquals(true, compraValida);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesNoPermiteMasDeUnaCompraEnUnMismoMesSiLaSumaDeEllasDaMayorAMil() {
		Double montoInicial = 300000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra_1 = 500.0;
		Double saldoCompra_2 = 600.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		cuenta.comprar(cuentaPesos, saldoCompra_1);
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra_2);
		
		assertEquals(false, compraValida);
	}
	
	@Test
	public void alComprarEnUnaCuentaDeDolaresEstadounidensesNoPermiteHacerloSiNoTenemosElSuficienteFondoEnLaCuentaDePesosArgentinos() {
		Double montoInicial = 10.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 900.0;
		Double saldoCompra = 1000.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean compraValida = cuenta.comprar(cuentaPesos, saldoCompra);

		assertEquals(false, compraValida);
	}
	
	@Test
	public void alVenderEnUnaCuentaDeDolaresEstadounidensesDebesTenerUnSaldoMayorOIgualAlMontoDeVenta() {
		Double montoInicial = 10.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 1000.0;
		Double montoVenta = 500.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean ventaValida = cuenta.vender(cuentaPesos, montoVenta);

		assertEquals(true, ventaValida);
	}
	
	@Test
	public void alVenderEnUnaCuentaDeDolaresEstadounidensesNoLoPermiteSiTenesUnSaldoMenorAlMontoDeVenta() {
		Double montoInicial = 10.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicial);
		
		Double saldoInicial = 10.0;
		Double montoVenta = 500.0;
		
		DolarEstadounidense cuenta = new DolarEstadounidense(saldoInicial);
		
		Boolean ventaValida = cuenta.vender(cuentaPesos, montoVenta);

		assertEquals(false, ventaValida);
	}
}
