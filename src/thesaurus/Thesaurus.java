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
	
	/**
	 * Add a new synonym to the thesaurus (map);
	 * 
	 * @param aWord A word which is added in the map as a key if it not already exist.
	 * @param aSynonym A String synonym is added as a value to the map.
	 * 
	 */
	public void addSynonym(String aWord, String aSynonym) {
		if (synonyms.containsKey(aWord)) {
			HashSet<String> word = synonyms.get(aWord);
			word.add(aSynonym);
		} else {
			HashSet<String> newSet = new HashSet<String>();
			newSet.add(aSynonym);
			synonyms.put(aWord, newSet);
		}
	}
	
	/**
	 * Print new variations of a given sentence, where the given word is replaced by a different
	 * synonyms.
	 * 
	 * @param aWord The word that needs to be replaced.
	 * @param aSentence The sentence where the given word must be replaced with its synonyms.
	 * 
	 */
	public void replaceWord(String aWord, String aSentence) {
		HashSet<String> set = synonyms.get(aWord);
		for (String i : set) {
			String result = aSentence.replace(aWord, i);
			System.out.println(result);
		}
	}
	/**
	 * Cross-reference each synonym in the thesaurus.
	 * 
	 */

	public void crossReference() {
		// convert key set to array so that it does not change when we add new entries
		// to the HashMap
		Object[] mapKeys = synonyms.keySet().toArray();

		for (Object keyObj : mapKeys) {
			// convert the key object to String
			String key = (String) keyObj;
			
			HashSet<String> set = synonyms.get(key);

			for (String j : set) {

				HashSet<String> newSet = new HashSet<String>();
				for (String k : set) {
					if (!j.equals(k)) {
						newSet.add(k);
					}
				}
				newSet.add(key);

				synonyms.put(j, newSet);
			}
		}
	}

}