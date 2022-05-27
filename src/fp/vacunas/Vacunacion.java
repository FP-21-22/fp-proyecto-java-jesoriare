package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad,
		Integer pfizer, Integer moderna, Integer astrazeneca,
		Integer janssen, Integer numPersonas) {
	
	public Vacunacion{
		Checkers.check("La fecha debe ser posterior al 01/01/20021", fecha.isAfter(LocalDate.of(2021, 01, 01)));
	}
	public Integer getNumeroTotal() {
		return pfizer+moderna+astrazeneca;
	}
	
	public static Vacunacion parsee(String cadena) {
		String[] cad = cadena.split(";");
		LocalDate fecha = LocalDate.parse(cad[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad= cad[1].trim();
		Integer pfizer = Integer.parseInt(cad[2]);
		Integer moderna = Integer.parseInt(cad[3]);
		Integer astrazeneca = Integer.parseInt(cad[4]);
		Integer janssen = Integer.parseInt(cad[5]);
		Integer numPersonas = Integer.parseInt(cad[6]);
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numPersonas);
	}
	

}