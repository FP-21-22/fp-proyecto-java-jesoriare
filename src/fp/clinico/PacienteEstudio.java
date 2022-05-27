package fp.clinico;


import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, 
		Double edad, Boolean hipertension, Boolean enfermedadCorazon, 
		TipoResidencia tipoResidencia, Double nivelGlucosa) {
	
	
	public Boolean getFactorRiesgo() {
		if(edad>40 && hipertension==true)
			return true;
		else
			return false;
			
	}
	
	public PacienteEstudio{
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad>=0 && edad<=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", nivelGlucosa>0);
	}
	public int compareTo(PacienteEstudio o) {
		// 
		Integer res = this.edad().compareTo(o.edad());
		if(res == 0) {
			res = this.id().compareTo(o.id());
		}		
		return res;
	}
	
	public static PacienteEstudio of(String id, String genero, 
			Double edad, Boolean hipertension, Boolean enfermedadCorazon, 
			TipoResidencia tipoResidencia, Double nivelGlucosa) {
			return new PacienteEstudio(id,genero,edad,hipertension,enfermedadCorazon, tipoResidencia, nivelGlucosa);
		}
	public static PacienteEstudio parse(String cadena) {
		String[] cad = cadena.split(";");
		String id= cad[0].trim();
		String genero= cad[1].trim();
		Double edad= Double.valueOf(cad[2].trim());
		Boolean hipertension= Boolean.valueOf(cad[3].trim());
		Boolean enfermedadCorazon= Boolean.valueOf(cad[4].trim());
		TipoResidencia tipoResidencia = TipoResidencia.valueOf(cad[5].trim());
		Double nivelGlucosa = Double.valueOf(cad[6].trim());
		return new PacienteEstudio(id,genero,edad,hipertension,enfermedadCorazon, tipoResidencia, nivelGlucosa);
	}

}
