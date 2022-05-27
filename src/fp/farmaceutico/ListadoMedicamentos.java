package fp.farmaceutico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoMedicamentos {
	//atributo
	private List<Medicamento> medicamentos;
			
	//constructores
	public ListadoMedicamentos() {
		this.medicamentos = new ArrayList<Medicamento>();
	}
			
	public ListadoMedicamentos(Collection<Medicamento> lista){
		this.medicamentos = new ArrayList<Medicamento>(lista);
	}
			
	public ListadoMedicamentos(Stream<Medicamento> pe) {
		this.medicamentos = pe.collect(Collectors.toList());
	}
	
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipo, LocalDate fecha) {
		return medicamentos.stream()
				.anyMatch(x->x.getTipoMedicamento().equals(tipo) && x.getFechaCatalogo().isAfter(fecha));
	}
	public String nombreMedicamentosPuntuacionMayorA(Double puntuacion) {
		return medicamentos.stream()
				.filter(x->x.getPuntuacion()>puntuacion)
				.map(Medicamento::getNombreMedicamento)
				.distinct()
				.toString();
	}
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipo) {
		return medicamentos.stream()
				.filter(x->x.getTipoMedicamento().equals(tipo))
				.max(Comparator.comparing(Medicamento::getIndiceSomatico))
				.toString();
	}
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia() {
		return medicamentos.stream()
				.collect(Collectors.groupingBy(Medicamento::getTipoMedicamento, Collectors.averagingDouble(x->x.getPuntuacion())));
	}
	public LocalDate fechaCatalogoMasFrecuente() {
		Map<LocalDate, Long> aux = this.medicamentos.stream()
				.collect(Collectors.groupingBy(Medicamento::getFechaCatalogo, Collectors.counting()));
		return aux.entrySet().stream()
				.max(Comparator.comparing(x->x.getValue()))
				.get()
				.getKey();
	}

}
