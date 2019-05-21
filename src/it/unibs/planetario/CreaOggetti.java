package it.unibs.planetario;

import it.unibs.fp.mylib.InputDati;

public class CreaOggetti {
	
	public static int contatoreS_S=1;
	public static int contatoreStelle=1;
	public static int contatorePianeti=1;
	public static int contatoreSatelliti=1;
	
	public static SistemaStellare creaSistemaStellare()
	{
	String newid="S_S"+contatoreS_S++;
	System.out.println(" ID SISTEMA STELLARE: " + newid);
	String newnome=InputDati.leggiStringaNonVuota("NOME SISTEMA STELLARE:");
	Posizione newCoordinateAssolute=creaPosizione();
	Stella newstella=creaStella();
	
		
		
	return new SistemaStellare( newid, newnome, newstella, newCoordinateAssolute);		
	}
	
	public static Stella creaStella()
	{

		String newid="Ste"+contatoreStelle++;
		System.out.println(" ID STELLA: " + newid);
		String newnome=InputDati.leggiStringaNonVuota("NOME STELLA: ");
		Posizione newCoordinateRelative=creaPosizione();
		double newmassa=InputDati.leggiDoubleConMinimo("MASSA STELLA: ", 0.0);
			
			
		return new Stella( newid, newnome, newCoordinateRelative, newmassa);
	}

	
	public static Pianeta creaPianeta()
	{

		String newid="Pia"+contatorePianeti++;
		System.out.println(" ID PIANETA: " + newid);
		String newnome=InputDati.leggiStringaNonVuota("NOME PIANETA: ");
		Posizione newCoordinateRelative=creaPosizione();
		double newmassa=InputDati.leggiDoubleConMinimo("MASSA PIANETA: ", 0.0);
			
			
		return new Pianeta( newid, newnome, newCoordinateRelative, newmassa);
	}
	
	public static Satellite creaSatellite()
	{

		String newid="Sat"+contatoreSatelliti++;
		System.out.println(" ID SATELLITE: " + newid);
		String newnome=InputDati.leggiStringaNonVuota("NOME SATELLITE: ");
		Posizione newCoordinateRelative=creaPosizione();
		double newmassa=InputDati.leggiDoubleConMinimo("MASSA SATELLITE: ", 0.0);
			
			
		return new Satellite( newid, newnome, newCoordinateRelative, newmassa);
	}
	
	public static Posizione creaPosizione()
	{
		
		double newX=InputDati.leggiDouble("COORDINATA X:");
		double newY=InputDati.leggiDouble("COORDINATA Y:");
			
		return new Posizione( newX, newY);
	}
	

	public static CentroDiMassa calcolaCDM(SistemaStellare sistemaStellare ) 
	{
		double massaTotale;
		double coordinataXPonderata;
		double coordinataYPonderata;
		Posizione coordinateCDM;
		
		massaTotale=sistemaStellare.getStella().getMassa();
		coordinataXPonderata=sistemaStellare.getStella().getMassa()*sistemaStellare.getStella().getCoordinateRelative().getX();
		coordinataYPonderata=sistemaStellare.getStella().getMassa()*sistemaStellare.getStella().getCoordinateRelative().getY();
		
		for(int i=0;i<sistemaStellare.getArrayListPianeti().size();i++)
		{
			massaTotale=massaTotale+sistemaStellare.getArrayListPianeti().get(i).getMassa();
			coordinataXPonderata=coordinataXPonderata+sistemaStellare.getArrayListPianeti().get(i).getMassa()*sistemaStellare.getArrayListPianeti().get(i).getCoordinateRelative().getX();
			coordinataYPonderata=coordinataYPonderata+sistemaStellare.getArrayListPianeti().get(i).getMassa()*sistemaStellare.getArrayListPianeti().get(i).getCoordinateRelative().getY();

			for(int j=0;j<sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().size();j++)
			{
				massaTotale=massaTotale+sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().get(j).getMassa();
				coordinataXPonderata=coordinataXPonderata+sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().get(j).getMassa()*sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().get(j).getCoordinateRelative().getX();
				coordinataYPonderata=coordinataYPonderata+sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().get(j).getMassa()*sistemaStellare.getArrayListPianeti().get(i).getArrayListSatelliti().get(j).getCoordinateRelative().getY();
			}
		}
	coordinateCDM=new Posizione(coordinataXPonderata/massaTotale,coordinataYPonderata/massaTotale);
		
	return  new CentroDiMassa(massaTotale,coordinateCDM);
	}
	
	}