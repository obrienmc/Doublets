import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Links {

	Map<String, Set<String>> allCandidates; // Maps each word to a set of possible candidates

	/**
	 * Constructs a Links object representing a database of all the words and their candidates.
	 * @param filename - the name of the dictionary input file
	 */
	public Links(String filename) {
		allCandidates = new HashMap<String, Set<String>>();
		try {
			populateCandidates(filename);
		} catch (IOException e) {
			System.out.println("Invalid dictionary number.  Defaulting to 35");
			try {
				populateCandidates("english.cleaned.all.35.txt");
			} catch (IOException e1) {
				//should never reach here
				System.out.print("Dictionary file is missing!");
			}
		}
	}

	/**
	 * Getter method for candidates
	 * @param word
	 * @return set of possible candidates for word
	 */
	public Set<String> getCandidates(String word) {
		return allCandidates.get(word);
	}

	/**
	 * Populates the map of words and their candidates using a BufferedReader
	 * @param filename - dictionary
	 * @throws IOException
	 */
	private void populateCandidates(String filename)
			throws IOException {
		HashSet<String> set = new HashSet<String>(); // Temporarily stores all of the words in the file
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String word;
		
		//Adds all the words in the dictionary to the set
		while ((word = reader.readLine()) != null) {
			set.add(word);
		}
	
		//examines each word in the dictionary set
		for(String s : set){
			String tempString = s;
			HashSet<String> wordset = new HashSet<String>(); //set of candidates for this word
			//iterates through each possible value for each character of the word, finding all possible candidates
			for(int i = 0; i < s.length(); i++){
				String start = s.substring(0, i);
				String end = "";
				if(i < s.length() - 1)
					end = s.substring(i + 1);
				for(int j = 97; j <= 122; j++){
					tempString = start + (char)(j) + end; 
					if(!tempString.equals(s) && set.contains(tempString)) //tests if it is a valid word in the dictionary and is not equal to itself
						wordset.add(tempString);
				}
			}
			if (wordset.isEmpty()) //return null if the set is empty
				allCandidates.put(s, null);
			else
				allCandidates.put(s, wordset);

		}
		reader.close();

	}

}
