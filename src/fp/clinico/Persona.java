package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.farmaceutico.Medicamento;
import fp.utiles.Checkers;


public record Persona(String nombre, String apellidos,
		String dni, LocalDate fechaNacimiento) {
	
	public Persona{
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual", fechaNacimiento.isBefore(LocalDate.now()));
		//tengo que ponerle la letra al check
		Checkers.check("El dni debe ser una cadena con ocho digitos y seguidos de una letra.", dni.length()==9); //&& isCharacter(dni) && isDigit(dni));

	}
	
//	public Boolean isCharacter(String codigo) {
//		Boolean res= false;
//		for(int i=9; i<=9; i++) {
//			res= Character.isAlphabetic(codigo.charAt(i));
//		}
//		return res;
//	}
//	
//	public Boolean isDigit(String codigo) {
//		Boolean res= false;
//		for(int i=0; i<=8; i++) {
//			res= Character.isDigit(codigo.charAt(i));
//			if(!res) {
//				break;
//			}
//		}
//		return res;
//	}
	
	public Integer getEdad() {
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}
	public int compareTo(Persona p) {
		Integer res=this.dni().compareTo(p.dni());
		return res;
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
