package fp.farmaceutico.test;
import java.time.LocalDate;

import fp.farmaceutico.*;
public class TestMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medicamento m1= new Medicamento("Medicamento QAC", "Farmaceutica FOX");
		System.out.println(m1);
		m1.setFechaCatalogo(LocalDate.of(2001, 4, 21));
		System.out.println(m1);
	}

}
