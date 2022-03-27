package fp.farmaceutico;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class Medicamento {
	private String nombreMedicamento;
	private TipoMedicamento tipoMedicamento;
	private String codigoEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		super();
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
		Checkers.check("La puntación tiene que ser mayor estricta que cero", puntuacion<=0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indiceSomatico<1000);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015",fechaCatalogo.isBefore(LocalDate.of(2015, 1, 1)));
	
	
	
	}
	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}
	public void setCodigoEnfermedad(String codigoEnfermedad) {
		this.codigoEnfermedad = codigoEnfermedad;
	}
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	public void setIndiceSomatico(Integer indiceSomatico) {
		this.indiceSomatico = indiceSomatico;
	}
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}
	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		this.fechaCatalogo = fechaCatalogo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((farmaceutica == null) ? 0 : farmaceutica.hashCode());
		result = prime * result + ((nombreMedicamento == null) ? 0 : nombreMedicamento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (farmaceutica == null) {
			if (other.farmaceutica != null)
				return false;
		} else if (!farmaceutica.equals(other.farmaceutica))
			return false;
		if (nombreMedicamento == null) {
			if (other.nombreMedicamento != null)
				return false;
		} else if (!nombreMedicamento.equals(other.nombreMedicamento))
			return false;
		return true;
	}
	
	//orden natural me falta
	
	
}
