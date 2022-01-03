package lab5;

import java.util.Calendar;

public class ContBancar implements  Operatiuni{

	private String numarCont;
	private float suma;
	private String moneda;
	private Calendar data_deschiderii;
	private Calendar data_ultimei_operatiuni;

	public ContBancar(String numarCont, float suma, String moneda, Calendar data_deschiderii, Calendar data_ultimei_operatiuni){
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschiderii = data_deschiderii;
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}

	public ContBancar(ContBancar e)
	{
		this(e.numarCont, e.suma, e.moneda, e.data_deschiderii, e.data_ultimei_operatiuni);
	}

	public float calculeaza_dobanda() 
	{
		Calendar data_de_azi = Calendar.getInstance();
		float diferenta = (data_de_azi.getTimeInMillis() - data_ultimei_operatiuni.getTimeInMillis())/1000/60/60/24;
	
		System.out.println((data_de_azi.getTimeInMillis() - data_ultimei_operatiuni.getTimeInMillis())/1000/60/60/24);
	    	
		
		if(moneda.toLowerCase().equals("ron")) return diferenta * 0.3f;
		else return diferenta * 0.1f;
	}

	public float actualizare_suma() 
	{
		suma = suma - calculeaza_dobanda();
		
        Calendar data_de_azi = Calendar.getInstance();
        data_ultimei_operatiuni = data_de_azi;

		return suma;
	}

	public void depunere(float suma) 
	{
		this.suma = this.suma + suma;	
		Calendar data_de_azi = Calendar.getInstance();
        data_ultimei_operatiuni = data_de_azi;
	}

	public void extragere(float suma) 
	{
		if(this.suma >= suma) this.suma = this.suma - suma;	
		else System.out.println("Exista doar " + this.suma + " in cont ! ");

		Calendar data_de_azi = Calendar.getInstance();
        data_ultimei_operatiuni = data_de_azi;

	}
	
	public String toString()
	{
		return numarCont + " " + suma + " " + moneda.toUpperCase() + "  " + data_deschiderii.get(Calendar.YEAR) + "/" +
	     (data_deschiderii.get(Calendar.MONTH) + 1) + "/" + data_deschiderii.get(Calendar.DAY_OF_MONTH) + "\n";
 	}
	
	public String getNumarCont() {
		return numarCont;
	}

	public float getSuma() {
		return suma;
	}

	public String getMoneda() {
		return moneda;
	}

	public Calendar getData_deschiderii() {
		return data_deschiderii;
	}

	public Calendar getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}

}
