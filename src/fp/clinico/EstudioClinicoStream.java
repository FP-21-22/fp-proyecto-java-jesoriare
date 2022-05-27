package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoStream {
	//atributo
	private Set<PacienteEstudio> ecs;
	
	//constructores
	public EstudioClinicoStream() {
		this.ecs = new HashSet<PacienteEstudio>();
	}
	
	public EstudioClinicoStream(Collection<PacienteEstudio> lista){
		this.ecs = new HashSet<PacienteEstudio>(lista);
	}
	
	public EstudioClinicoStream(Stream<PacienteEstudio> pe) {
		this.ecs = pe.collect(Collectors.toSet());
	}
	
	//operaciones stream
	public Integer numeroPacientes() {
		// TODO Auto-generated method stub
		Integer res;
		res= ecs.size();
		return res;
	}

	public void incluyePaciente(PacienteEstudio paciente) {
		this.ecs.add(paciente);

	}

	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//this.ls.add(pacientes);

	}

	public void eliminaPaciente(PacienteEstudio paciente) {
		this.ecs.remove(paciente);

	}

	public Boolean estaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub
		return this.ecs.contains(paciente);
	}

	public void borraEstudio() {
		// TODO Auto-generated method stub
		this.ecs.clear();

	}

	public EstudioClinico of(String nombreFichero) {
		// TODO Auto-generated method stub
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
	}

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
	
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		return ecs.stream()
				.allMatch(x->x.tipoResidencia().equals(tipo));
	}
	
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		return ecs.stream()
				.anyMatch(x->x.tipoResidencia().equals(tipo));
	}
	
	public Integer numeroPacientesFactorRiesgo() {
		Long aux =  ecs.stream()
				.filter(x->x.getFactorRiesgo())
				.map(x->x.id())
				.count();
		return aux.intValue();
	}
	
	public Double edadMediaPacientesConFactorDeRiesgo() {
		return ecs.stream()
				.filter(x->x.getFactorRiesgo())
				.mapToDouble(x->x.edad())
				.average()
				.getAsDouble();
	}
	
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad){
		return ecs.stream()
				.filter(x->x.edad()>edad)
				.toList();
	}
	
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad){
		return ecs.stream()
				.filter(x->x.edad()>edad)
				.collect(Collectors.groupingBy(PacienteEstudio::genero));
	}
	
	public Map<String, Long> numeroPacientesPorGenero(){
		return ecs.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.counting()));
	}
	
	public Map<String, Double> edadMediaPacientesPorGenero(){
		return ecs.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.averagingDouble(x->x.edad())));
	}

}
