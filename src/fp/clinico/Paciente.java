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
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return res;
	}
	private String formatearHora(LocalDateTime fechaHoraIngreso) {
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("HH:mm"));
		return res;
	}
	
	public static Paciente of (String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
        Persona persona = Persona.of(nombre, apellidos, dni, fechaNacimiento);
        Paciente res = new Paciente(persona, codigoIngreso, fechaHoraIngreso);
        return res;
    }
	public static Paciente of (Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
        Paciente res = new Paciente(persona, codigoIngreso, fechaHoraIngreso);
        return res;
    }
		

	

}
