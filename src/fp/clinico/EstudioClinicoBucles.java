package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EstudioClinicoBucles implements EstudioClinico {
	List<PacienteEstudio> ls;


	public EstudioClinicoBucles(List<PacienteEstudio> leeFichero) {
		// TODO Auto-generated constructor stub
		ls = new ArrayList<>();
	}

	@Override
	public Integer numeroPacientes() {
		// TODO Auto-generated method stub
		Integer res;
		res= ls.size();
		return res;
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		this.ls.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//this.ls.add(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.ls.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub
		return this.ls.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		// TODO Auto-generated method stub
		this.ls.clear();

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		// TODO Auto-generated method stub
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		//
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();		
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
			for(String e:aux) {
				PacienteEstudio p = PacienteEstudio.parse(e);
				res.add(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
		
		
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
