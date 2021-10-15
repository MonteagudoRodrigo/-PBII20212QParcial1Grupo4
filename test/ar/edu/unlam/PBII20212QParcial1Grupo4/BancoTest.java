package ar.edu.unlam.PBII20212QParcial1Grupo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class BancoTest {

	@Test
	public void queSeAgreguenCorrectamenteBilleteras() {
		Banco bcra = new Banco();
		Billetera wallet1 = new Billetera("Juan", "Perez", 12345678);
		Billetera wallet2 = new Billetera("Juan", "Perez", 12345679);
		
		bcra.agregarBilletera(wallet1);
		bcra.agregarBilletera(wallet2);
		
		Billetera[] resultadoEsperado = {wallet1, wallet2};
		Billetera[] resultadoObtenido = bcra.getBilleteras();

		assertArrayEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queNoSeAgregueMasDe1BilleteraConElMismoTitular() {
		Banco bcra = new Banco();
		Billetera wallet1 = new Billetera("Juan", "Perez", 12345678);
		Billetera wallet2 = new Billetera("Juan", "Perez", 12345678);
		
		bcra.agregarBilletera(wallet1);
		Boolean resultadoObtenido = bcra.agregarBilletera(wallet2);
		
		assertFalse(resultadoObtenido);
	}

}
