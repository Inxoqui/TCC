package model;

public class Perfil {
	private int idPerfil;
	private String perfil;

	// OBJETOS
	public Perfil() {
		super();
	}

	public Perfil(int idPerfil, String perfil) {
		super();
		this.idPerfil = idPerfil;
		this.perfil = perfil;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
