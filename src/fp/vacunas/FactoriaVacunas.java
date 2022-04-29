package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunas {
	public static List<Vacunacion> leeFichero(String nombreFichero){
		//
		List<Vacunacion> res = new ArrayList<Vacunacion>();		
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
				Vacunacion v = Vacunacion.parsee(e);
				res.add(v);
			}
			cont++;
		}		
		return res;
	}

}
