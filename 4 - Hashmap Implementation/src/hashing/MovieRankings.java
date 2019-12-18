package hashing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieRankings {

	public static void main(String[] args) {

		Map<String, Integer> movieTitleMap = new HashMap<String, Integer>();
		Map<Integer, String> movieRankingMap = new HashMap<Integer, String>();
		
		readMovieInfoIntoMaps(movieTitleMap, movieRankingMap);

		displayTopTenMovies(movieRankingMap);

		movieLookUp(movieTitleMap, movieRankingMap);

		System.out.println("Exiting...");
	}

	static void readMovieInfoIntoMaps(Map<String, Integer> movieTitleMap,
			                          Map<Integer, String> movieRankingMap){
		// ************ FINISH THIS ********************* //
		
		// read file data into br variable:
		BufferedReader br = getFileData("./MovieRankings.txt");
		
		// read data into moveTitleMap:
		String st;
		int rank;
		String title;
		try {
			while ((st = br.readLine()) != null) {
				// read the title and rank into movieTitleMap:
				try {
					// split string into rank and title:
					rank = Integer.parseInt(st.split(" ", 2)[0]);
					title = st.split(" ", 2)[1];
					// add both to hashmap:
					movieTitleMap.put(title, rank);
				} catch(NumberFormatException e) {}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// reset file data:
		br = getFileData("./MovieRankings.txt");
		
		// read data into movieRankingMap:
		try {
			while ((st = br.readLine()) != null) {
				// read the rank and title into movieRankingMap:
				try {
					// split string into rank and title:
					rank = Integer.parseInt(st.split(" ", 2)[0]);
					title = st.split(" ", 2)[1];
					// add both to hashmap:
					movieRankingMap.put(rank, title);
				} catch(NumberFormatException e) {}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static void displayTopTenMovies(Map<Integer, String> movieRankingMap) {
		// ************ FINISH THIS ********************* //
		
		System.out.println("********* The TOP TEN Movies *********");
		
		// to iterate through the map:
		Iterator iter = movieRankingMap.entrySet().iterator(); 
		int rank = 0;
		
		// iterate through the first 10 elements of the map:
        while (iter.hasNext() && rank < 10) { 
        	// get the element's rank and title, and display it:
            Map.Entry mapElement = (Map.Entry)iter.next();
            rank = (int) mapElement.getKey();
            System.out.println(mapElement.getKey() + " " + mapElement.getValue()); 
        } 
        System.out.println("");
	}

	static void movieLookUp(Map<String, Integer> movieTitleMap,
			                Map<Integer, String> movieRankingMap) {
		// ************ FINISH THIS ********************* //
		//	This method should get the Scanner and provide the
		//	option to select Rank or Title
		//
		//	Based on what is selected is should call one of the following methods
		//		which does the map lookup and display the information
		//
		//			findByRanking
		//			findByTitle
		//
		Scanner scan = new Scanner(System.in);
		String inputChar = " ";
		while(!inputChar.contentEquals("q")) {
			System.out.print("Find by Ranking (R) or Title (T): ");
			inputChar = scan.next();
			// if they want to search by ranking:
			if(inputChar.toLowerCase().contentEquals("r")) {
				findByRanking(scan, movieRankingMap);
			}
			// if they want to search by title:
			else if(inputChar.toLowerCase().contentEquals("t")) {
				findByTitle(scan, movieTitleMap);
			}
		}
	}

	static void findByRanking(Scanner input, Map<Integer, String> movieRankingMap) {
		// ************ FINISH THIS ********************* //
		boolean validRank = false;
		// keep asking until valid input:
		while(!validRank) {
			System.out.print("Enter the ranking (1 through 90): ");
			int rank = 0;
			try {
				rank = input.nextInt();
				// only accept valid input:
				if(rank >= 1 && rank <= 90) {
					// find requested movie and print it out:
					String movie = movieRankingMap.get(rank);
					System.out.println("The movie ranked #" + rank + " is \"" + movie + "\"");
					validRank = true;
				}
				// otherwise loop again:
				else {
					System.out.print("Error! ");
				}
			} catch (InputMismatchException e) {
				System.out.print("Error! ");
				input.nextLine();
			}
		}
		System.out.println("");
	}

	static void findByTitle(Scanner input, Map<String, Integer> movieTitleMap) {
		// ************ FINISH THIS ********************* //
		boolean validTitle = false;
		String title = "";
		// keep asking until valid input:
		System.out.print("Enter the movie title: ");
		input.nextLine();
		title = input.nextLine();
		// put title in camelcase to match list no matter what:
		title = toCamel(title);
		if(movieExists(title)) {
			// get the requested movie and print it out:
			int rank = movieTitleMap.get(title);
			System.out.println("The movie \"" + title + "\" is ranked #" + rank);
			validTitle = true;
		}
		// otherwise:
		else {
			System.out.println("No movie exists with the title \"" + title + "\"");
		}
		System.out.println("");
	}
	
	// check if movie exits in list:
	static boolean movieExists(String title) {
		BufferedReader br = getFileData("./MovieRankings.txt");
		
		// loop through list comparing title against all movie titles in list:
		String st = "";
		try {
			while ((st = br.readLine()) != null) {
				// if it's there, return true:
				if(title.contentEquals(st.split(" ", 2)[1]))
					return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// if not, return false:
		return false;
	}
	
	static BufferedReader getFileData(String path) {
		// get file data into BufferReader:
		File file = new File(path); 
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			return br;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// convert strings to camel-case:
	static String toCamel(String str) {
		String newString = "";
		for(int i = 0; i < str.length(); i++) {
			// if it's the first char or the first char after a space:
			if(i == 0 || str.charAt(i-1) == ' ') {
				// make it uppercase:
				newString += (str.charAt(i) + "").toUpperCase();
			}
			// otherwise:
			else {
				// make it lowercase:
				newString += (str.charAt(i) + "").toLowerCase();
			}
		}
		return newString;
	}
	
}