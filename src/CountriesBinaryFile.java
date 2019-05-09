import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesBinaryFile {
	
	static ArrayList<Country> countries = new ArrayList<Country>();
	
	public static void main(String[] args) {
		
		 
		countries.add(new Country("USA", 320000000)); 
		countries.add(new Country("Japan", 100000000)); 
		countries.add(new Country("United Kingdom", 50000000)); 
		
	}
	
	public static ArrayList<Country> getCountryList() { 
		return countries; 
	}
	
	public static void readCountriesFromFile(String fileName) {
		
		Path filePath = Paths.get(fileName); 
		File file = filePath.toFile(); 
		BufferedReader br = null; 
		String line = ""; 
		ArrayList<Country> countries = new ArrayList<Country>(); 
		
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the file was not found"); 
		} 
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.out.println("Sorry, empty file"); 
		} 
		while (line != null) {
			String[] stuff = line.split(","); 
			countries.add(new Country(stuff[0], Long.parseLong(stuff[1]))); 
			try {
				line = br.readLine();
			} catch (IOException e) {
				System.out.println("Yeah, it's another error :("); 
				break; 
			} 
		}
		
		for (Country c: countries) {
			System.out.println(c); 
		}
		
		
	}
	
	
	public static void createFile(String filePath) { 
		Path path = Paths.get(filePath); 
		if (!(Files.exists(path))) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				System.out.println("Something has gone terribly wrong"); 
			}
		}
	} 
	
	public static void writeCountriesToFile(String fileName, ArrayList<Country> countries) {
		Path filePath = Paths.get(fileName); 
		File file = filePath.toFile();
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			for (Country c: countries) {
				out.println(c); 
			}
			out.close(); 
			
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, file wasn't found"); 
		} 
		
		
	}

	public static void deleteFile(String fileName) {
		Path filePath = Paths.get(fileName); 
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
