package fp.clinico.test;
import fp.clinico.*;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1= Persona.parse("Juan, Garcia Rodriguez, 12755078Z, 20/03/1965");
		System.out.println(p1);

	}

}
