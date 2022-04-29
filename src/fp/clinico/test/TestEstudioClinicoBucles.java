package fp.clinico.test;

import fp.clinico.EstudioClinicoBucles;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstudioClinicoBucles ecb1 = new EstudioClinicoBucles();
		lee(ecb1);
	}
	private static void lee(EstudioClinicoBucles estudio) {
		System.out.println(estudio.leeFichero("data/estudio_clinico.csv"));
	}
}
