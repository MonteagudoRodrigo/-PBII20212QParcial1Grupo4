package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaBitcoin {
	@Test
	public void alCrearUnaCuentaEnBitcoinDepositaElMontoInicial() {
		Double montoEsperado = 1.0;
		Double montoInicial = 1.0;
		
		Cuenta cuenta = new Bitcoin(montoInicial);
		
		assertEquals(montoEsperado, cuenta.getSaldo());
	}

	@Test
	public void alComprarEnUnaCuentaEnBitcoinSeDebeRequerirUnMontoMayorAlFeeDeLaBlockchain() {
		Double montoInicialPesos = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicialPesos);
		
		Double montoInicial = 1.0;
		Double montoCompra = 0.015;
		
		Bitcoin cuenta = new Bitcoin(montoInicial);
		Boolean compraValida = cuenta.comprar(cuentaPesos, montoCompra);
		
		assertEquals(false, compraValida);
	}
	
	@Test
	public void alExtraerEnUnaCuentaEnBitcoinNoLoPermiteSiElSaldoAExtraerEsMayorAlFeeDeLaBlockchainMultiplicadoPorDos() {		
		Double montoInicial = 0.02;
		Double montoExtraccion = 0.015;
		
		Bitcoin cuenta = new Bitcoin(montoInicial);
		Boolean extraccionValida = cuenta.extraer(montoExtraccion);
		
		assertEquals(false, extraccionValida);
	}

	@Test
	public void alExtraerEnUnaCuentaEnBitcoinEsPosbileSiElSaldoAExtraerEsMayorAlFeeDeLaBlockchainMultiplicadoPorDos() {		
		Double montoInicial = 1.0;
		Double montoExtraccion = 0.03;
		
		Bitcoin cuenta = new Bitcoin(montoInicial);
		Boolean extraccionValida = cuenta.extraer(montoExtraccion);
		
		assertEquals(true, extraccionValida);
	}
	
	@Test
	public void alVenderEnUnaCuentaEnBitcoinQuedaReflejadoEnElSaldoCorrectamente() {
		Double montoInicialPesos = 185000.0;
		PesoArgentino cuentaPesos = new PesoArgentino(montoInicialPesos);
		
		Double montoInicial = 0.5;
		Double saldoVenta = 0.5;
		Double saldoEsperado = 0.0;
		
		Bitcoin cuenta = new Bitcoin(montoInicial);
		cuenta.vender(cuentaPesos, saldoVenta);
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
	}
}
