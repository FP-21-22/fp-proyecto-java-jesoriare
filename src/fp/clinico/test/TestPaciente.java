package fp.clinico.test;

import java.time.LocalDateTime;
import fp.clinico.*;

public class TestPaciente {
	public static void main(String[] args) {
		Persona p1= Persona.parse("Juan, Garcia Rodriguez, 12755078Z, 20/03/1965");
		Paciente pa1= new Paciente(p1,"code1", LocalDateTime.of(2022, 4, 21, 16,31));
		System.out.println(pa1);
		}
	

}
