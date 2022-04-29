package fp.vacunacion.test;

import java.time.LocalDate;
import fp.vacunas.Vacunacion;

public class TestVacunacion {

	public static void main(String[] args) {
		Vacunacion v1= new Vacunacion(LocalDate.of(2021, 1, 04),"Andalucia",140295,0,0,0,0);
		System.out.println(v1);

	}

}
