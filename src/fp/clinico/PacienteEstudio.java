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
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad<=0 && edad>=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", nivelGlucosa<0);
	}
	public PacienteEstudio(String id, Double edad) {
		this("",id, edad);
	}
//representacion como cadena de pacienteestudio y orden y cmentarios
}
