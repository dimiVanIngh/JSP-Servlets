package be.vdab.entities;

import java.util.Date;

public class GastenboekBericht {
	
	private long id;
	private String naam;
	private String bericht;
	private Date timestamp;
	
	
	public GastenboekBericht(long id,String naam, String bericht, Date timestamp) {
		this.id = id;
		this.naam = naam;
		this.bericht = bericht;
		this.timestamp = timestamp;
	}
	public GastenboekBericht(String naam, String bericht){
		this.naam = naam;
		this.bericht = bericht;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getBericht() {
		return bericht;
	}
	public void setBericht(String bericht) {
		this.bericht = bericht;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public static boolean isNaamValid(String naam){
		return naam != null && !naam.isEmpty();
	}
	public static boolean isBerichtValid(String bericht){
		return bericht != null && !bericht.isEmpty();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
