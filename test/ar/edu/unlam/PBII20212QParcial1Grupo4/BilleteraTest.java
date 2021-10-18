package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class BilleteraTest {

	@Test
	public void queSePuedaAgregar3CuentasDeDistintoTipo() {
		Billetera wallet = new Billetera("Juan", "Perez", 12345678);
		
		PesoArgentino cuenta1 = new PesoArgentino(0.0);
		DolarEstadounidense cuenta2 = new DolarEstadounidense(0.0);
		Bitcoin cuenta3 = new Bitcoin(0.0);
		
		wallet.agregarCuenta(cuenta1);
		wallet.agregarCuenta(cuenta2);
		wallet.agregarCuenta(cuenta3);
		
		Cuenta[] valorEsperado = { cuenta1, cuenta2, cuenta3 };
		Cuenta[] valorObtenido = wallet.getCuentas();
		
		assertArrayEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaAgregar2CuentasDelTipoPesos() {
		Billetera wallet = new Billetera("Juan", "Perez", 12345678);
		
		PesoArgentino cuenta1 = new PesoArgentino(0.0);
		PesoArgentino cuenta2 = new PesoArgentino(0.0);
		
		wallet.agregarCuenta(cuenta1);
		wallet.agregarCuenta(cuenta2);
		
		Cuenta[] valorEsperado = { cuenta1 };
		Cuenta[] valorObtenido = wallet.getCuentas();
		
		assertArrayEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaAgregar2CuentasDelTipoDolares() {
		Billetera wallet = new Billetera("Juan", "Perez", 12345678);
		
		DolarEstadounidense cuenta1 = new DolarEstadounidense(0.0);
		DolarEstadounidense cuenta2 = new DolarEstadounidense(0.0);
		
		wallet.agregarCuenta(cuenta1);
		wallet.agregarCuenta(cuenta2);
		
		Cuenta[] valorEsperado = { cuenta1 };
		Cuenta[] valorObtenido = wallet.getCuentas();
		
		assertArrayEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaAgregar2CuentasDelTipoBitcoin() {
		Billetera wallet = new Billetera("Juan", "Perez", 12345678);
		
		Bitcoin cuenta1 = new Bitcoin(0.0);
		Bitcoin cuenta2 = new Bitcoin(0.0);
		
		wallet.agregarCuenta(cuenta1);
		wallet.agregarCuenta(cuenta2);
		
		Cuenta[] valorEsperado = { cuenta1 };
		Cuenta[] valorObtenido = wallet.getCuentas();
		
		assertArrayEquals(valorEsperado, valorObtenido);
	}

}
