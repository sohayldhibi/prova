package it.unibs.planetario;

//classe principale di cui le classi: Stella, Pianeta e Stallite sono classi figlie 
public class CorpoCeleste {
	private String id;
	private  String nome;
	private double massa;
	private Posizione coordinateRelative;
	


	
public CorpoCeleste(String id, String nome, Posizione coordinateRelative, double massa)
{
	this.id=id;
	this.nome=nome;
	this.coordinateRelative=coordinateRelative;
	this.massa=massa;
}
	
	public String getId() {
		return id;
	}
	public  String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public  double getMassa() {
		return massa;
	}
	public Posizione getCoordinateRelative() {
		return coordinateRelative;
	}
	
	public String toString() {

        

        return "ha id "+id+", ha come nome "+nome+ ", ha massa "+massa+", si trova in coordinate "+coordinateRelative+" rispetto al centro del sistema stellare";

}
}
