import java.util.Set;

/**
 * Contains the general algorithm to search for doublets.
 *
 * @author Alia Robinson and Matthew O'Brien
 *         Created Mar 18, 2011.
 */
public class Doublets {
	Links dictionary; // Dictionary is used for links
	
	/**
	 * Takes in the given instance of links and assigns it to the dicitionary.
	 * 
	 * @param The given instance of links
	 */
	public Doublets(Links links) {
		dictionary = links;
	}
	
	/**
	 * Finds the chain of words from the 'start' to the 'end'
	 * 
	 * @param start - start word
	 * @param end - end word
	 * @param mgr - chain manager
	 * @return Calls the recursive helper method which will ultimately return
	 *         the chain.
	 */
	public Chain getChain(String start, String end, ChainManager mgr) {
		Chain startChain = new Chain();
		startChain = startChain.addLast(start);
		mgr.add(startChain);
		mgr.setMaxSize(1);

		Chain nextChain = startChain;
		while (nextChain != null) {
			Set<String> candidateSet = dictionary.getCandidates(nextChain
					.getLast());
			if (candidateSet == null) {
				return null;
			}
			// Adds all candidates of the current word to the given chain and
			// adds it to the chain manager.
			for (String candidate : candidateSet) {
				// Chain is complete
				if (candidate.equals(end)) {
					return nextChain.addLast(candidate);
				} else if (!nextChain.contains(candidate)) {
					mgr.add(nextChain.addLast(candidate));
				}
			}
			nextChain = mgr.next();
		}
		return null;
	}
	
	/**
	 * Checks to see whether the given word is in the dictionary.
	 * 
	 * @param word - word that is being searched for
	 * @return a boolean indicating whether it is in the dictionary or not
	 */
	public boolean isInDictionary(String word){
		return dictionary.allCandidates.containsKey(word);
	}
	
}
