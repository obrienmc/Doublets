import java.util.LinkedList;
import java.util.Queue;


public class QueueChainManager extends ChainManager {

	Queue<Chain> queue; //a queue holding all of the chains that still must be examined
	
	/**
	 * Constructor
	 */
	public QueueChainManager(){
		queue = new LinkedList<Chain>();
	}
	
	/**
	 * Adds another chain to this manager, updates the maximum size
	 */
	@Override
	public void add(Chain chain) {
		queue.offer(chain);
		if(queue.size()>this.maxSize())
			this.setMaxSize(queue.size());

	}

	/**
	 * Moves on to the next chain in the queue
	 */
	@Override
	public Chain next() {
		if(queue.isEmpty())
			return null;
		incrementNumNexts();
		return queue.poll();
	}

}
