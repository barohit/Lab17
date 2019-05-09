import java.util.ArrayList;
import java.util.Scanner;

public class CountriesBinaryApp {
	// for the extended challenge, this is the modified version that uses the .dat file instead
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		CountriesBinaryFile cbf = new CountriesBinaryFile(); 
		CountriesBinaryFile.main(args); // the initialization 
		ArrayList<Country> countries = CountriesBinaryFile.getCountryList(); // so I can accesst he list. 
		
		char continueChar = 'y'; 
		Scanner scan = new Scanner (System.in);
		System.out.println("Welcome to the Countries Maintenance Application!"); 
		
		CountriesBinaryFile.createFile("countries.dat");
		CountriesBinaryFile.writeCountriesToFile("countries.dat", countries);
		
		while (continueChar == 'y') {
			System.out.println("\nWhat would you like to do next?\n"); 
			displayMenu(); 
			int userChoice = Validator.validateInt(scan);
			switch(userChoice) {
			case 1: 
				CountriesBinaryFile.readCountriesFromFile("countries.dat");
				break; 
			case 2: 
				countries.add(addCountry(scan)); 
				System.out.println("Country added!\n"); 
				CountriesBinaryFile.deleteFile("countries.dat"); 
				CountriesBinaryFile.createFile("countries.dat");
				CountriesBinaryFile.writeCountriesToFile("countries.dat", countries); 
				System.out.println("Here is the remaining list of countries: \n");
				CountriesBinaryFile.readCountriesFromFile("countries.dat");
				break; 
			case 3: 
				System.out.println("Buh-bye!"); 
				continueChar = 'n';
				break; 
			case 4: 
				deleteCountries(countries, scan);
				CountriesBinaryFile.deleteFile("countries.dat");
				CountriesBinaryFile.createFile("countries.dat");
				CountriesBinaryFile.writeCountriesToFile("countries.dat", countries);
				System.out.println("Here is the remaining list of countries: \n");
				CountriesBinaryFile.readCountriesFromFile("countries.dat");
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
				} 
			} if (validInput == false) {
				System.out.println("Error, invalid input"); 
				scan.nextLine(); 
				continue; 
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

