package it.unibs.planetario;

import java.util.*;


import it.unibs.fp.mylib.*;


public class SistemaStellare {
	private String id;
	private String nome;
	private Posizione coordinateAssolute;
	
	private static Stella stella;
	
	private static ArrayList<Pianeta> elencoPianeti = new ArrayList<Pianeta>();
	private CentroDiMassa centroDiMassaSistemaStellare;
	
	public SistemaStellare(String id, String nome, Stella stella,Posizione coordinateAssolute)
	{
		this.id=id;
		this.nome=nome;
		this.stella=stella;
		this.coordinateAssolute=coordinateAssolute;
		
		
	}
	 public ArrayList<Pianeta> getArrayListPianeti(){

         return elencoPianeti;

}
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public Stella getStella() {
		return stella;
	}
	
	public Posizione getCoordinateAssolute() {
		return coordinateAssolute;
	}
	
	public CentroDiMassa getCentroDiMassaSistemaStellare() {
		return centroDiMassaSistemaStellare;
	}
	
	public void setCentroDiMassaSistemaStellare(CentroDiMassa centroDiMassaSistemaStellare) {
		this.centroDiMassaSistemaStellare = centroDiMassaSistemaStellare;
	}
	
	//questo menu mi permette di scegliere cosa fare all'interno del sistema, cioè aggiungere pianeti ecc..
	public static void menuPianeta(int sceltaAzione)
	{
		
		
			switch (sceltaAzione) {
			case 1:
				//Mi permette di aggiungere all'array list di una sistema stellare un pianeta
				aggiungiPianeta();
				break;
			case 2:
				//richiedo l'id del pianeta da rimuovere
				String id1=InputDati.leggiStringa("Inserisci l' id del pianeta da rimuovere");
				rimuoviPianeta(id1);
				break;
			case 3:
				//mi permette di entrare nella scheda del pianeta per poter aggiungere eventuali satelliti
				String id2;
				do {

				 id2=InputDati.leggiStringa("Inserisci id del pianeta  in cui vuoi entrare");
				}while(ControlloP.èPresentePianeta(id2, elencoPianeti)==false);
				
				entraSistemaPlanetario(id2);
				break;
			case 4:
				//mi permette di visualizzare tutti i pianeti presenti 
				mostraPianeti();
				break;
			case 5:
				PlanetariumMain.main(null);
				break;
				
			default:
				System.out.println("Scelta non valida");
				break;
			}
		
			
		
		}
	
	private static void aggiungiPianeta( ) 
	{
		Pianeta pianeta=CreaOggetti.creaPianeta();
		System.out.println("Il Pianeta "+ pianeta +" è stato aggiunto con successo\n");
		elencoPianeti.add(pianeta);
		
	}
	
	private static void rimuoviPianeta(String idDaRimuovere) 
	{
		//avendo l'id contro quale sia l'id uguale a quello inserito e lo rimuovo
		boolean trovato=false;
		for(int i=0;i<elencoPianeti.size();i++){
			
			if(elencoPianeti.get(i).getId().compareToIgnoreCase(idDaRimuovere)==0)
			{
				trovato=true;
				elencoPianeti.remove(i);
				i=elencoPianeti.size();
			}
			
		}
		if(trovato)
			System.out.println("Il Sistema Planetario è stato rimosso con successo\n");
		else
			
			//se l'id non è stato trovato all'interno del sistema stellare voiene mostrato a video 
			
			System.out.println("Il Sistema Planetario non è stato trovato\n");
		}
	
	public static void mostraPianeti()
	{
		//mostro a video il nome dei diversi pianeti presenti nel sistema stellare
		
		System.out.println("\t"+" Stella "+stella.getId()+"\t  nome: " +stella.getNome() + ",  Coordinate "+ stella.getCoordinateRelative());
			for(int i=0;i<elencoPianeti.size();i++)
			{
				System.out.println("\t\t"+(i+1)+" Pianeta \t"+elencoPianeti.get(i).getId()+", nome: " + elencoPianeti.get(i).getNome()+ " Coordinate: "+ elencoPianeti.get(i).getCoordinateRelative());
				elencoPianeti.get(i).mostraSatelliti();
			}
				
		}
	
	public static void entraSistemaPlanetario(String id)
	{
		//creo il menu che mi permette di interagire con i pianeti di quel sistema stellare
		
		final String MENU_PRINCIPALE = "MENU PRINCIPALE PIANETA";
		
		final String[] VOCI= {"1 - AGGIUNGERE SATELLITE ", 
				"2 - RIMUOVERE SATELLITE", 
				"3 - MOSTRARE TUTTI I SATELLITI DI QUEL PIANETA ", 
				"4 - TORNARE AL MENU PRINCIPALE"};
		
		int sceltaAzione=0;
		MyMenu menu= new MyMenu(MENU_PRINCIPALE, VOCI);
		
		do {
		sceltaAzione=menu.scegli();
	
		Pianeta.menuSatellite(sceltaAzione);
		}while(sceltaAzione!=0);
	}
	
	public String toString() {

        

        return "Il sistema stellare ha come id "+id +", come nome "+nome+ " e si trova in posizione "+coordinateAssolute+" rispetto all'intero universo";

}
	
	public void calcolaCollisioni()
	{
		for(int i=0;i<elencoPianeti.size();i++)
		{
			for(int j=0;j<elencoPianeti.get(i).getArrayListSatelliti().size();j++)
			{
				
			}
		}
	}
}
