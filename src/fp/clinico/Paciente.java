package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;


public record Paciente(Persona Persona, String codigoIngreso,
		LocalDateTime fechaHoraIngreso) {
	
	public Paciente{
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", fechaHora>LocalDate.now());

	}
	
	
	private String formatearFecha(LocalDateTime fechaHoraIngreso) {
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		return res;
	}
	private String formatearHora(LocalDateTime fechaHoraIngreso) {
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("HH-mm"));
		return res;
	}
	private Persona persona(){
		return
	}

}
//los comentarios y tengo mal las derivadas