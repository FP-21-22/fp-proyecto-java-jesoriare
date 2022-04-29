package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FactoriaMedicamento {
	public static Medicamento parseM(String cadena) {
		String[] cad = cadena.split(",");
		String nombreMedicamento = cad[0].trim();
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(cad[1].trim());
		String codigoEnfermedad = cad[2].trim();
		String farmaceutica = cad[3].trim();
		Double puntuacion = Double.parseDouble(cad[4].trim());
		Integer indiceSomatico = Integer.parseInt(cad[5]);
		LocalDate fechaCatalogo = LocalDate.parse(cad[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamento, tipoMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fechaCatalogo);
	}
	
	
	public static List<Medicamento> leeFichero(String nombreFichero){
		//
		List<Medicamento> res = new ArrayList<Medicamento>();		
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Hay que saltarse la primera línea
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				Medicamento v = parseM(e);
				res.add(v);
			}
			cont++;
		}		
		return res;
	}

}
