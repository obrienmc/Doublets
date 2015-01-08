import java.util.PriorityQueue;


public class PriorityQueueChainManager extends ChainManager {
	
	PriorityQueue<Entry> pqueue; // A priority queue holding all of the chain entries
	String target; // the eventual end word for this game
	
	/**
	 * Constructor
	 * @param str - the target word
	 */
	public PriorityQueueChainManager(String str){
		pqueue = new PriorityQueue<Entry>();
		target = str;
	}
	
	/**
	 * Moves on to the next item in the priority queue, updates the maximum size
	 */
	@Override
	public void add(Chain chain) {
		pqueue.offer(new Entry(chain, target));
		if(pqueue.size()>this.maxSize())
			this.setMaxSize(pqueue.size());

	}

	/**
	 * Moves on to the next item in the queue. 
	 */
	@Override
	public Chain next() {
		if(pqueue.isEmpty())
			return null;
		incrementNumNexts();
		return pqueue.poll().chain;
	}
	
	private class Entry implements Comparable<Entry>{
		//This class wraps a chain, making it comparable
		
		Chain chain; // the chain this entry represents
		String target; // the "goal" end word for this game
		
		public Entry(Chain ch, String s){
			this.chain = ch;
			this.target = s;
		}
		
		/**
		 * Returns a positive value if this value is greater than the other entry,
		 * 0 if they are equal, or a negative value if the other entry's value is greater
		 */
		@Override
		public int compareTo(Entry other) {
			return this.getValue() - other.getValue();
		}
		
		/**
		 * Calculates the value of this entry based on the chain length and the number of differences
		 * between the word and the target word.
		 * @return
		 */
		public int getValue(){
			int diff = 0;
			String current = this.chain.getLast();
			for(int i = 0; i < target.length(); i++){
				if(current.charAt(i) != target.charAt(i))
					diff++;
			}
			return diff + this.chain.length;
		}
		
	}

}
