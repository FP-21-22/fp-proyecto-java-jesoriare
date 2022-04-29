package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import fp.utiles.Checkers;


public record Paciente(Persona persona, String codigoIngreso,
		LocalDateTime fechaHoraIngreso) {



	public Paciente{
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.", fechaHoraIngreso.isBefore(LocalDateTime.now()) || fechaHoraIngreso.isEqual(LocalDateTime.now()));

	}
	
	
	private String fechaIngreso(LocalDateTime fechaHoraIngreso) {
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return res;
	}
	private String horaIngreso(LocalDateTime fechaHoraIngreso) {
		String res= fechaHoraIngreso.format(DateTimeFormatter.ofPattern("HH:mm"));
		return res;
	}
	
	public static Paciente of (String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		Persona p = Persona.of(nombre, apellidos, dni, fechaNacimiento);
        Paciente res = new Paciente(p, codigoIngreso, fechaHoraIngreso);
        return res;
    }
	
	
//	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
//		return new Paciente(Persona.of(nombre, apellidos, dni, fechaNacimiento), codigoIngreso, fechaHoraIngreso);
//	}

	
	public static Paciente of (Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
        Paciente res = new Paciente(persona, codigoIngreso, fechaHoraIngreso);
        return res;
    }
		

	

}
