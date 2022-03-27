package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;


public record Persona(String nombre, String apellidos,
		String dni, LocalDate fechaNacimiento) {
	
	public Persona{
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual", fechaNacimiento.isAfter(LocalDate.now()));
		Checkers.check("El dni debe ser una cadena con ocho dígitos y seguidos de una letra.", dni.length()==9);

	}
	
	public Integer getEdad() {
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}
	//poner bien el dni y los comenrarios poner
	
	
	
	

}
