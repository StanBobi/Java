package Cartile;


public class Carte {

	private String titlu, autor;
	private int an_aparitie;
	private static int id = 0;
	
	Carte(String titlu, String autor, int an_aparitie)
	{
		this.titlu = titlu;
		this.an_aparitie = an_aparitie;
		this.autor = autor;
		Carte.id++;
	}
	
	Carte(){}
	
	Carte(Carte e)
	{
		this(e.getTitlu(), e.getAutor(), e.getAn_aparitie());
	}
    
	public static int getId()
	{
		return id;
	}
	
	public String getTitlu() {
		return titlu;
	}

	public String getAutor() {
		return autor;
	}

	public int getAn_aparitie() {
		return an_aparitie;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}
 
	public String toString()
	{
	   return titlu + " " + autor + " " + an_aparitie;	
	}
	
}
