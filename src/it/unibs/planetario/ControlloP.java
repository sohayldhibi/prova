package it.unibs.planetario;

import java.util.ArrayList;

public class ControlloP {

	private static final int CONTROLLO_USCITA = 0;

	public static boolean  ËPresenteSistemaStellare(String id, ArrayList<SistemaStellare> elencoSistemi) {
		if(id.equals(CONTROLLO_USCITA)) {
			PlanetariumMain.main(null);
		}else {
			for(int i=0;  i<elencoSistemi.size();i++) {
			if(elencoSistemi.get(i).getId().equals(id)) {
				return true;
				}
			}
		
		}
		System.out.println(" L'id inserito non Ë stato trovato, se vuoi tornare al menu precedente inserisci 0");
		return false;
		}

	public static boolean  ËPresentePianeta(String id, ArrayList<Pianeta> elencoSatelliti) {
		if(id.equals(CONTROLLO_USCITA)) {
			MenuPrincipale.entraSistemaStellare(null);
		}else {
			for(int i=0;  i<elencoSatelliti.size();i++) {
			if(elencoSatelliti.get(i).getId().equals(id)) {
				return true;
				}
			}
		
		}
		System.out.println(" L'id inserito non Ë stato trovato, se vuoi tornare al menu precedente inserisci 0");
		return false;
		
		
	
		
	
		}

	}

