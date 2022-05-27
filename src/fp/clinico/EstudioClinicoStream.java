package fp.clinico;

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
