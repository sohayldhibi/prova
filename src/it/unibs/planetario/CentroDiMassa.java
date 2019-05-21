package it.unibs.planetario;
public class CentroDiMassa {
	private double massa;
	private Posizione coordinateRelative;
	
	public CentroDiMassa(double massa, Posizione coordinateRelative) {
		this.massa=massa;
		this.coordinateRelative=coordinateRelative;
	}
	
	public double getMassa() {
		return massa;
	}
	
	public Posizione getCoordinateRelative() {
		return coordinateRelative;
	}	
	
	public String toString() {
		return "\n-->Il centro di massa ha massa: "+massa+" e coordinate: "+coordinateRelative+"\n";
	}

}
