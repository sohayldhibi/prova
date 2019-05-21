package it.unibs.planetario;

import it.unibs.fp.mylib.*;


public class PlanetariumMain {

		
	public static void main(String[] args) {
		//dichiaro i vari componenti del menù per creare un sistema stellare
		final String MENU_PRINCIPALE = "MENU PRINCIPALE SISTEMA STELLARE";
		final String[] VOCI= {" - AGGIUNGERE SISTEMA STELLARE ",
				" - RIMUOVERE SISTEMA STELLARE", 
				" - ENTRARE NEL MENU DEL SISTEMA STELLARE PER AGGIUNGERE CORPI CELESTI ", 
				" - PER VISUALIZZARE TUTTI I SISTEMI STELLARI",
				" - RICERCARE IL PERCORSO DI UN CORPO CELESTE",
				"-  CALCOLARE IL CENTRO DI MASSA DEL SISTEMA STELLARE "};
		
		int sceltaAzione=0;
		
		//creo un menù per poter scegliere cosa fare all'interno del sistema stellare, e permetto che la scelta possa essere 
		//ripetuta più volte
		
		MyMenu menu= new MyMenu(MENU_PRINCIPALE, VOCI);
		do {
			
			sceltaAzione=menu.scegli();
			MenuPrincipale.sceltaMenu(sceltaAzione);
		}while(sceltaAzione!=0);
	
		
		}
	}

	
	

