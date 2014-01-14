package model;

public class directionArbre {
	private String nomDirection;
	private int idDirection, idDG;
	
	public directionArbre(int idDirection, String nomDirection, int idDG){
		super();
		this.idDirection=idDirection;
		this.nomDirection=nomDirection;
		this.idDG=idDG;
	}

	public directionArbre(){
		super();
		
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
