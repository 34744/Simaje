package model;

public class direction {
	private String nomDirection;
	private int idDirection, idDG;
	
	public direction(int idDirection, String nomDirection, int idDG){
		super();
		this.idDirection=idDirection;
		this.nomDirection=nomDirection;
		this.idDG=idDG;
	}

	public String getNomDirection() {
		return nomDirection;
	}

	public void setNomDirection(String nomDirection) {
		this.nomDirection = nomDirection;
	}

	public int getIdDirection() {
		return idDirection;
	}

	public void setIdDirection(int idDirection) {
		this.idDirection = idDirection;
	}

	public int getIdDG() {
		return idDG;
	}

	public void setIdDG(int idDG) {
		this.idDG = idDG;
	}
}
