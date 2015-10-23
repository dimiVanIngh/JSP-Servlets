package be.vdab.entities;

public class Gemeente {
	private String naam;
	private int postCode;

	public Gemeente() {
	}

	public Gemeente(int postCode,String naam) {
		this.naam = naam;
		this.postCode = postCode;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString(){
		return postCode + " " + naam;
	}

}
