package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamento;
public class TestFactoriaMedicamento {

	public static void main(String[] args) {
		
		System.out.println(FactoriaMedicamento.leeFichero("data/medicamentos.csv"));
	}
}