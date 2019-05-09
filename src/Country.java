
public class Country {

	String name; 
	long population;
	
	public Country () {
		
	}
	
	public Country(String nam, long pop) {
		name = nam; 
		population = pop; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	} 
	
	public String toString() {
		return name + "," + population;  
	}
}
