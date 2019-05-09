import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<Country> countries = new ArrayList<Country>(); 
		countries.add(new Country("USA", 320000000)); 
		countries.add(new Country("Japan", 100000000)); 
		countries.add(new Country("United Kingdom", 50000000)); 
		
		char continueChar = 'y'; 
		Scanner scan = new Scanner (System.in);
		System.out.println("Welcome to the Countries Maintenance Application!"); 
		
		CountriesTextFile.createFile("countries.txt");
		CountriesTextFile.writeCountriesToFile("countries.txt", countries);
		
		while (continueChar == 'y') {
			System.out.println("\nWhat would you like to do next?\n"); 
			displayMenu(); 
			int userChoice = Validator.validateInt(scan);
			switch(userChoice) {
			case 1: 
				CountriesTextFile.readCountriesFromFile("countries.txt");
				break; 
			case 2: 
				countries.add(addCountry(scan)); 
				System.out.println("Country added!\n"); 
				CountriesTextFile.deleteFile("countries.txt"); 
				CountriesTextFile.createFile("countries.txt");
				CountriesTextFile.writeCountriesToFile("countries.txt", countries); 
				System.out.println("Here is the remaining list of countries: \n");
				CountriesTextFile.readCountriesFromFile("countries.txt");
				break; 
			case 3: 
				System.out.println("Buh-bye!"); 
				continueChar = 'n';
				break; 
			case 4: 
				deleteCountries(countries, scan);
				CountriesTextFile.deleteFile("countries.txt");
				CountriesTextFile.createFile("countries.txt");
				CountriesTextFile.writeCountriesToFile("countries.txt", countries);
				System.out.println("Here is the remaining list of countries: \n");
				CountriesTextFile.readCountriesFromFile("countries.txt");
			}
		
		}
	}
	
	public static void deleteCountries(ArrayList<Country> countries, Scanner scan) {
		System.out.println("Which country would you like to delete?"); 
		boolean validInput = false; 
		while (validInput == false) {
			String userInput = Validator.validateString(scan); 
			for (Country c: countries) {
				if (c.getName().equalsIgnoreCase(userInput)) {
					countries.remove(c); 
					validInput = true; 
					break; 
				} else {
					System.out.println("Error, invalid input"); 
					continue; 
				}
			}
		}
		
	}
	public static void displayMenu() {
		System.out.println("1 - See the list of countries"); 
		System.out.println("2 - Add a Country"); 
		System.out.println("3 - Exit"); 
		System.out.println("4 - Delete country: ");
	}
	
	public static Country addCountry(Scanner scan) {
		System.out.println("Enter country: "); 
		String name = Validator.validateString(scan); 
		System.out.println("Enter population: ");
		long population = Validator.validateLong(scan); 
		Country c = new Country(name, population); 
		return c; 
	}
	
	
	
	

}
