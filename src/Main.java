import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner used to read from
												// dictionary
		Doublets doublets; // Initialize the doublets

		// Variable input so user selects dictionary.
		System.out.println("Welcome to Doublets.");
		System.out
				.println("Enter a dictionary number (10, 20, 35, 40, 50, 55, 60, 70, 80, 95): ");
		String dictNumber = input.nextLine();
		String filename = "english.cleaned.all." + dictNumber + ".txt";
		doublets = new Doublets(new Links(filename));

		// Continue game until user specifies to quit with an 'x' key stroke.
		while (true) {
			System.out.println("Enter starting word: ");
			String start = input.nextLine();
			start = start.trim();
			System.out.println("Enter ending word: ");
			String end = input.nextLine();
			end = end.trim();
			// Check to make sure words are valid.
			if (!doublets.isInDictionary(start)) {
				System.out.println("The word " + start + " is invalid.");
			} else if (!doublets.isInDictionary(end)) {
				System.out.println("The word " + end + " is invalid.");

			} else if (start.length() != end.length()) {
				System.out
						.println("The words need to be the same length. Try again!");
			} else if (start.equals(end)) {
				System.out.println("Those are the same word!");
			} else {
				// Select the chain manager
				ChainManager manager;
				while (true) {
					System.out
							.println("Enter chain manager (s: stack, q: queue, p: priority queue, x: exit): ");
					String m = input.nextLine();
					if (m.equals("s")) {
						manager = new StackChainManager();
						break;
					} else if (m.equals("q")) {
						manager = new QueueChainManager();
						break;
					} else if (m.equals("p")) {
						manager = new PriorityQueueChainManager(end);
						break;
					} else if (m.equals("x")) {
						System.out.println("Thanks for playing!");
						input.close();
						System.exit(0);
					} else {
						System.out.println("Invalid input. Try again.");
					}
				}
				// Find the chain
				Chain chain = doublets.getChain(start, end, manager);
				// If there is no solution
				if (chain == null)
					System.out.println("no solution");
				else {
					System.out.println(chain.toString());
					System.out.println("Length: " + chain.length());
					System.out.println("Candidates: "
							+ manager.getNumberOfNexts());
					System.out.println("Max Size: " + manager.maxSize() + "\n");
				}
			}

		}

	}

}
