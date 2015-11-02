package haw.danielpascal.gka.datencontainer;

//Das soll ein Datencontainer werden der einen Datensatz Stadt vorhält, der dann an die Redis-Klasse zum reinwuppsen geht aus dem Hauptprogramm aus 

public class CityEntry {
	
	private String id;
	private String city;
	private double[] loc;
	private int pop;
	private String state;
	
	public CityEntry(String id, String city, double[] loc, int pop, String state){
		this.id=id;
		this.city=city;
		this.loc=loc;
		this.pop=pop;
		this.state=state;
	}

	public String getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public double[] getLoc() {
		return loc;
	}

	public int getPop() {
		return pop;
	}

	public String getState() {
		return state;
	}
	
}
