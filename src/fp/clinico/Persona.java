package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;


public record Persona(String nombre, String apellidos,
		String dni, LocalDate fechaNacimiento) {
	
	public Persona{
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual", fechaNacimiento.isBefore(LocalDate.now()));
		//tengo que ponerle la letra al check
		Checkers.check("El dni debe ser una cadena con ocho digitos y seguidos de una letra.", dni.length()==9);

	}
	
	public Integer getEdad() {
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}
	
	public static Persona of(String nombre, String apellidos,
		String dni, LocalDate fechaNacimiento) {
		Persona res= new Persona(nombre, apellidos, dni, fechaNacimiento);
		return res;
	}
	public static Persona parse(String cadena) {
		String[] cad = cadena.split(",");
		String nombre= cad[0].trim();
		String apellidos= cad[1].trim();
		String dni= cad[2].trim();
		LocalDate fechaNacimiento = LocalDate.parse(cad[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Persona(nombre, apellidos, dni, fechaNacimiento);
	}

	
	
	
	

}
