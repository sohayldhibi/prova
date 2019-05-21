package it.unibs.planetario;


public class Satellite extends CorpoCeleste
{
	private double raggioOrbita;
	
public Satellite(String id, String nome, Posizione coordinateRelative, double massa)
{
	super(id,nome,coordinateRelative,massa);
}


public double getRaggioOrbita() {
	return raggioOrbita;
}
	 

public String toString() {

          return "Il satellite " + super.toString();

}

}