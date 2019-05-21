package it.unibs.planetario;



public class Stella extends CorpoCeleste
{
public Stella(String id, String nome, Posizione coordinateRelative, double massa)
{
	super(id,nome,coordinateRelative,massa);
}

public String toString() {


    return "La stella "+super.toString();

}

}

