package fp.clinico.test;

import fp.clinico.PacienteEstudio;

public class TestPacienteEstudio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacienteEstudio pe1= PacienteEstudio.parse("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(pe1);

	}

}
