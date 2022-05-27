package fp.vacunas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Vacunaciones {
	//atributo
		private List<Vacunacion> vacunaciones;
		
		//constructores
		public Vacunaciones() {
			this.vacunaciones = new ArrayList<Vacunacion>();
		}
		
		public Vacunaciones(Collection<Vacunacion> lista){
			this.vacunaciones = new ArrayList<Vacunacion>(lista);
		}
		
		public Vacunaciones(Stream<Vacunacion> pe) {
			this.vacunaciones = pe.collect(Collectors.toList());
		}
		
		
		//operaciones con stream
		
		public void anyadeVacunacion(Vacunacion v) {
			vacunaciones.add(v);
		}
		
		public List<Vacunacion> vacunacionesEntreFechas(LocalDate fechaInicio, LocalDate fechaFinal){
			return vacunaciones.stream()
					.filter(x->x.fecha().isAfter(fechaInicio) && x.fecha().isBefore(fechaFinal))
					.toList();
		}
		
		public Boolean existeNumPersonasPautaCompletaPorEmcimaDe(String comunidad, Integer n) {
			return vacunaciones.stream()
					.anyMatch(x->x.comunidad().equals(comunidad) && n<x.numPersonas());
		}
		
//		public LocalDate diaMasVacunacionesEn(String comunidad) {
//			return vacunaciones.stream()
//					.filter(x->x.comunidad().equals(comunidad))
//					.sorted(Comparator.comparing(Vacunacion::fecha))
//					.limit(1);
//		}
		
		public Map<LocalDate, List<Vacunacion>>vacunacionesPorFecha(){
			return vacunaciones.stream()
					.collect(Collectors.groupingBy(Vacunacion::fecha));
		}
		
		public Map<String, Integer>maximoNumTotalVacunasPorComunidad() {
			return vacunaciones.stream()
					.collect(Collectors.groupingBy(Vacunacion::comunidad, Comparator.comparing(Vacunacion::getNumeroTotal)));
			
		}
		
}
