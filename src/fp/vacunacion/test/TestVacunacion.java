package fp.vacunacion.test;

import java.time.LocalDate;
import fp.vacunacion.*;

public class TestVacunacion {

	public static void main(String[] args) {
		Vacunacion v1= Vacunacion(LocalDate.of(2021, 1, 04),"Andalucía",140295,0,0,0,0);
		System.out.println(v1);

	}

}
