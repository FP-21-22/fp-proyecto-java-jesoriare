package fp.vacunacion.test;

import fp.vacunas.FactoriaVacunas;

public class TestFactoriaVacunacion {

	public static void main(String[] args) {
		
		System.out.println(FactoriaVacunas.leeFichero("data/ccaa_vacunas_3.csv"));
	}
}
