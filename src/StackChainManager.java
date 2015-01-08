import java.util.Stack;


public class StackChainManager extends ChainManager {

	Stack<Chain> stack; // holds all the chains 
	
	/**
	 * Constructor
	 */
	public StackChainManager(){
		stack = new Stack<Chain>();
	}
	
	/**
	 * Adds a new chain onto the stack, updates the maximum stack size;
	 */
	@Override
	public void add(Chain chain) {
		stack.push(chain);
		if(stack.size() > this.maxSize())
			this.setMaxSize(stack.size());

	}

	/**
	 * Moves onto the next chain,  removing it from the stack.
	 */
	@Override
	public Chain next() {
		if(stack.isEmpty())
			return null;
		incrementNumNexts();
		return stack.pop();
	}

}
