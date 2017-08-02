package br.com.ramon.xml.test;

public class Horarios {

	private String diaSemana;
	private String horarioInicio;
	private String horarioFim;
	
	
	public Horarios(String diaSemana, String horarioInicio, String horariofim) {
		this.diaSemana = diaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horariofim;
	}


	public String getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}


	public String getHorarioInicio() {
		return horarioInicio;
	}


	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}


	public String getHorariofim() {
		return horarioFim;
	}


	public void setHorariofim(String horariofim) {
		this.horarioFim = horariofim;
	}


	@Override
	public String toString() {
		return "Horarios [diaSemana=" + diaSemana + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim
				+ "]";
	}
	
	
	
}
