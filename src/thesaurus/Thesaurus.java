package thesaurus;

import java.util.HashMap;
import java.util.HashSet;


/**
 * The Thesaurus class gives a list of alternative words that means the same as
 * a given word.
 * 
 * The class is used to create new sentences by replacing a given word by its
 * synonyms.
 * 
 * @author Cristina Pat
 * @version 2022.03.27
 */

public class Thesaurus {
	// Used to map key words to synonyms
	private HashMap<String, HashSet<String>> synonyms;

	/**
	 * Construct a synonyms map.
	 */

	public Thesaurus() {
		synonyms = new HashMap<>();
	}

	/**
	 * A getter for synonyms map
	 * 
	 * @return This synonyms map.
	 */
	public HashMap<String, HashSet<String>> getThesaurus() {
		return synonyms;
	}

	/**
	 * Put the given sample entries into the map.
	 * 
	 */

	public void populate() {
		HashSet<String> happy = new HashSet<String>();
		happy.add("joyful");
		happy.add("contented");
		happy.add("cheerful");
		synonyms.put("happy", happy);

		HashSet<String> angry = new HashSet<String>();
		angry.add("annoyed");
		angry.add("vexed");
		synonyms.put("angry", angry);

	}
	
	/**
	 * Print out the whole thesaurus (map);
	 * 
	 */
	public void print() {
		for (HashMap.Entry<String, HashSet<String>> entry : synonyms.entrySet()) {
			String key = entry.getKey();
			HashSet<String> value = entry.getValue();

			String synonym = "";
			for (String i : value) {
				synonym = i + " " + synonym;
			}

			System.out.println(key + " - " + synonym);

		}
	}

}