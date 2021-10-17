package ar.edu.unlam.PBII20212QParcial1Grupo4;

public class Banco {
	public Billetera billeteras[];
	
	public Billetera[] getBilleteras() {
		return billeteras;
	}

	public Boolean agregarBilletera(Billetera billeteraAAgregar) {
		return agregarBilleteraAArrayDeBilleteras(billeteraAAgregar);
	}
	
	// Agrega un billetera al final del array de billetera
	private Boolean agregarBilleteraAArrayDeBilleteras(Billetera nuevaBilletera) {
		if(billeteras == null) {
			this.billeteras = new Billetera[] { nuevaBilletera };
		} else {
			Billetera[] nuevoArrayDeBilleteras = new Billetera[billeteras.length + 1];
			
			for (int i = 0; i < billeteras.length; i++) {
				nuevoArrayDeBilleteras[i] = billeteras[i];
			}
			if(billeteraYaExiste(nuevaBilletera)) return false;
			nuevoArrayDeBilleteras[billeteras.length] = nuevaBilletera;
			
			this.billeteras = nuevoArrayDeBilleteras;
		}
		return true;
	}

	private Boolean billeteraYaExiste(Billetera nuevaBilletera) {
		for (Integer i = 0; i < billeteras.length; i++) {
			if (billeteras[i].getDni().equals(nuevaBilletera.getDni())) {
				return true;
			}
		}
		return false;
	}
}
