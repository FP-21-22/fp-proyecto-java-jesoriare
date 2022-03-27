package fp.vacunas;

import java.time.LocalDate;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad,
		Integer pfizer, Integer moderna, Integer astazeneca,
		Integer janssen, Integer numPersonas) {
	
	public Vacunacion{
		Checkers.check("La fecha debe ser posterioir al 01/02/20021", fecha<"01/02/2021");
	}

}
