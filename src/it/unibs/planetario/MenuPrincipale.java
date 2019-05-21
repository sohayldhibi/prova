package it.unibs.planetario;

import java.util.*;
import it.unibs.fp.mylib.*;

public class MenuPrincipale {
	public static ArrayList<SistemaStellare> elencoSistemiStellari = new ArrayList<SistemaStellare>();

	static void sceltaMenu(int selezione) {
		switch (selezione) {
		case 1:
			// permette di creare un nuovo sistema stellare
			MenuPrincipale.aggiungiSistemaStellare();
			break;

		case 2:
			// permette di eliminare un sistema stellare
			System.out.println("Inserisci id  da rimuovere");
			String id1 = InputDati.leggiStringa("");
			rimuoviSistemaStellare(id1);
			break;
		case 3:
			// permette di visualizzare gli elementi di un sistema stellare
			String id2;

			do {

				id2 = InputDati.leggiStringa("Inserisci id S. Stellare in cui vuoi entrare");

			} while (ControlloP.ËPresenteSistemaStellare(id2, elencoSistemiStellari) == false);

			entraSistemaStellare(id2);
			break;
		case 4:
			// permette di visualizzare tutti i sistemi stellari esistenti
			mostraSistemiStellari();
			break;

		case 5:
			// permette di visualizzare il percorso di un qualsiasi corpo celeste
			// conoscendone l'id

			String id3 = InputDati.leggiStringa("Inserisci L'id del corpo celeste di cui vuoi conboscere il percorso ");
			ricercaPercorso(id3);
			break;
		case 6:
			// permette di trovare il centro di massa del sistema stellare
			String id4;

			id4 = InputDati
					.leggiStringa("Inserisci l'id del Sistema Stellare di cui vuoi calcolare il centro di massa");
			trovaCentroDiMassa(id4);

		default:
			break;
		}
	}

	private static SistemaStellare aggiungiSistemaStellare() {
		// mi permette di creare un nuovo sistema stellare richiamando il costruttore
		SistemaStellare sistemaStellare1 = CreaOggetti.creaSistemaStellare();
		elencoSistemiStellari.add(sistemaStellare1);
		return sistemaStellare1;
	}

	private static void rimuoviSistemaStellare(String idDaRimuovere) {
		// rimuove il sistema inserito in base all'ID

		boolean trovato = false;
		for (int i = 0; i < elencoSistemiStellari.size(); i++) {
			if (elencoSistemiStellari.get(i).getId().compareToIgnoreCase(idDaRimuovere) == 0) {
				trovato = true;
				elencoSistemiStellari.remove(i);
				i = elencoSistemiStellari.size();

			}

		}

		if (trovato)
			System.out.println("Il Sistema Stellare Ë stato rimosso con successo\n");
		else
			System.out.println("Il Sistema Stellare non Ë stato trovato\n");
	}

	public static void mostraSistemiStellari() {
		// permette di visualizzare a video tutti i sistemi stellari precedentemente
		// inseriti

		System.out.println("I sistemi solari presenti sono :");

		for (int i = 0; i < elencoSistemiStellari.size(); i++) {
			System.out.println((i + 1) + "\t" + elencoSistemiStellari.get(i).getId() + ", nome: "
					+ elencoSistemiStellari.get(i).getNome() + ", Coordinate assolute: "
					+ elencoSistemiStellari.get(i).getCoordinateAssolute());
			elencoSistemiStellari.get(i).mostraPianeti();
		}

	}

	public static void mostraCollisioni(String id) {

		boolean trovato = false;
		for (int i = 0; i < elencoSistemiStellari.size(); i++) {
			if (elencoSistemiStellari.get(i).getId().compareToIgnoreCase(id) == 0) {
				trovato = true;
				elencoSistemiStellari.get(i).calcolaCollisioni();
				i = elencoSistemiStellari.size();

			}

		}

		if (!trovato)
			System.out.println("Il Sistema Stellare non Ë stato trovato\n");

	}

	private static void ricercaPercorso(String id) {
		boolean trovato = false;
		boolean sole = false;
		int indiceSS = -1, indiceP = -1, indiceSat = -1;
		for (int i = 0; i < elencoSistemiStellari.size() && !trovato; i++) {

			if (elencoSistemiStellari.get(i).getId().equals(id)) {
				trovato = true;
				indiceP = -1;
				indiceSat = -1;
				indiceSS = i;

			}
			if (elencoSistemiStellari.get(i).getStella().getId().equals(id)) {
				trovato = true;
				indiceP = -1;
				indiceSat = -1;
				indiceSS = i;
				sole = true;
			}
			for (int j = 0; j < elencoSistemiStellari.get(i).getArrayListPianeti().size() && !trovato; j++) {

				if (elencoSistemiStellari.get(i).getArrayListPianeti().get(j).getId().equals(id)) {
					trovato = true;
					indiceSat = -1;
					indiceP = j;
					indiceSS = i;
				}
				for (int k = 0; k < elencoSistemiStellari.get(i).getArrayListPianeti().get(j).getArrayListSatelliti()
						.size() && !trovato; k++) {
					if (elencoSistemiStellari.get(i).getArrayListPianeti().get(j).getArrayListSatelliti().get(k).getId()
							.equals(id)) {
						trovato = true;
						indiceSat = k;
						indiceP = j;
						indiceSS = i;
					}
				}
			}
		}
		if (!trovato) {
			System.out.println("Non Ë stato trovato");
		} else {
			if (indiceSat == -1) {
				if (indiceP == -1) {
					if (sole == true) {
						System.out.println("->Sistema Stellare " + elencoSistemiStellari.get(indiceSS).getId()
								+ " con nome " + elencoSistemiStellari.get(indiceSS).getNome());
						System.out.println("->Stella " + elencoSistemiStellari.get(indiceSS).getStella().getId()
								+ " con nome " + elencoSistemiStellari.get(indiceSS).getStella().getId());

					} else {
						System.out.println("->Sistema Stellare " + elencoSistemiStellari.get(indiceSS).getId()
								+ " con nome " + elencoSistemiStellari.get(indiceSS).getNome());
					}
				} else {
					System.out.println("->Sistema Stellare " + elencoSistemiStellari.get(indiceSS).getId()
							+ " con nome " + elencoSistemiStellari.get(indiceSS).getNome());
					System.out.println("->Stella " + elencoSistemiStellari.get(indiceSS).getStella().getId()
							+ " con nome " + elencoSistemiStellari.get(indiceSS).getStella().getId());
					System.out.println("->Pianeta "
							+ elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP).getId()
							+ " con nome "
							+ elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP).getId());
				}
			} else {
				System.out.println("->Sistema Stellare " + elencoSistemiStellari.get(indiceSS).getId() + " con nome "
						+ elencoSistemiStellari.get(indiceSS).getNome());
				System.out.println("->Stella " + elencoSistemiStellari.get(indiceSS).getStella().getId() + " con nome "
						+ elencoSistemiStellari.get(indiceSS).getStella().getId());
				System.out.println("->Pianeta "
						+ elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP).getId() + " con nome "
						+ elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP).getId());
				System.out.println("->Satellite "
						+ elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP).getArrayListSatelliti()
								.get(indiceSat).getId()
						+ " con nome " + elencoSistemiStellari.get(indiceSS).getArrayListPianeti().get(indiceP)
								.getArrayListSatelliti().get(indiceSat).getNome());
			}

		}

	}
	

	public static void trovaCentroDiMassa(String id) {

		// trova il sistema inserito in base all'ID

		boolean trovato = false;
		int indiceSS = 0;
		for (int i = 0; i < elencoSistemiStellari.size() && !trovato; i++) {
			if (elencoSistemiStellari.get(i).getId().compareToIgnoreCase(id) == 0) {
				trovato = true;
				elencoSistemiStellari.get(i)
						.setCentroDiMassaSistemaStellare(CreaOggetti.calcolaCDM(elencoSistemiStellari.get(i)));
				indiceSS = i;
			}

		}

		if (trovato)
			System.out.println(elencoSistemiStellari.get(indiceSS).getCentroDiMassaSistemaStellare());
		else
			System.out.println("Il Sistema Stellare non Ë stato trovato\n");
	}

	public static void entraSistemaStellare(String id) {

		// menu che permette di poter interagire con il sistema stellare per potere
		// aggiungere elementi, rimuoverli, ecc
		final String MENU_PRINCIPALE = "MENU PRINCIPALE STELLA";
		for (int i = 0; i < elencoSistemiStellari.size(); i++) {
			if (elencoSistemiStellari.get(i).getId().equals(id)) {
				System.out.println(elencoSistemiStellari.toString());
			}
		}

		final String[] VOCI = { " - AGGIUNGERE PIANETA ", " - RIMUOVERE PIANETA", " -  MOSTRARE UN PRECISO PIANETA ",
				" -  MOSTRARE TUTTI I PIANETI DI QUEL SISTEMA STELLARE", " - TORNARE AL MENU PRINCIPALE" };

		int sceltaAzione = 0;
		MyMenu menu = new MyMenu(MENU_PRINCIPALE, VOCI);

		do {
			sceltaAzione = menu.scegli();

			SistemaStellare.menuPianeta(sceltaAzione);
		} while (sceltaAzione != 0);

	}
}