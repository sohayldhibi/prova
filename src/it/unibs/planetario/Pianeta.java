package it.unibs.planetario;

import java.util.ArrayList;

import it.unibs.fp.mylib.*;


public class Pianeta extends CorpoCeleste
{
	
	private double raggioOrbita;
	private static ArrayList<Satellite> elencoSatelliti = new ArrayList<Satellite>();
	
public Pianeta(String id, String nome, Posizione coordinateRelative, double massa)
{
	super(id,nome,coordinateRelative,massa);
}


public static void menuSatellite(int scelta) {
	//il menu del satelitte mi permette di svolgere diverse azioni con esso
	
		switch (scelta) {
		
		case 1:
			aggiungiSatellite();
			break;
			
		case 2:
			String id1=InputDati.leggiStringa("Inserisci id del satellite da rimuovere");
			rimuoviSatellite(id1);
			break;
			
		case 3:
			mostraSatelliti();
			break;
			
		case 4: 
			
			MenuPrincipale.entraSistemaStellare(null);
			
		default:
			System.out.println("Scelta non valida");
			break;
		}
		
	
	}
	

public ArrayList<Satellite> getArrayListSatelliti(){

    return elencoSatelliti;

}
	
	private static void aggiungiSatellite() 
	{
		//permette di creare un nuovo satellite collegato al pianeta
		 
		Satellite nuovo=CreaOggetti.creaSatellite();
		elencoSatelliti.add(nuovo);
		
	}
	
	private static void rimuoviSatellite(String idDaRimuovere) 
	{
		//permette di eliminare un satelitte precedentemente creato grazie all'id inserito, che viene confrontato per capire il 
		//giusto elemento dell'array list da eliminare
		
		boolean trovato=false;
		for(int i=0;i<elencoSatelliti.size();i++)
		{
			if(elencoSatelliti.get(i).getId().compareToIgnoreCase(idDaRimuovere)==0)
			{
				trovato=true;
				elencoSatelliti.remove(i);
				i=elencoSatelliti.size();
			}
			
		}
		if(trovato)
			System.out.println("Il Satellite è stato rimosso con successo\n");
		else
			System.out.println("Il Satellite non è stato trovato\n");
		
	}
	
	public static void mostraSatelliti()
	{
		//permette di visualizzare tutti i satelliti relativi ad un determinato pianeta
		for(int i=0;i<elencoSatelliti.size();i++)
		{
			System.out.println("\t\t\t"+(i+1)+" Satellite \t"+elencoSatelliti.get(i).getId()+", Coordinate: "+ elencoSatelliti.get(i).getCoordinateRelative());
		}
	}


public double getRaggioOrbita() {
	return raggioOrbita;
}

public String toString() {

    return "Il pianeta " + super.toString();

}

}
