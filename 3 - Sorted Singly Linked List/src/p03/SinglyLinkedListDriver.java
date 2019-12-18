package p03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SinglyLinkedListDriver {

	public static int getInteger(Scanner input) {
		// DO THIS
		//	Gets an integer from the scanner, tests for valid integer
		//	If not valid,  display "Please enter an integer: "
		//	Stay here until a valid integer is entered.
		
		int returnInt = 0;
		boolean isInt = false;
		// wait for valid int input:
		do {
			// check for valid int input:
			try {
				input.nextLine();
				returnInt = input.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error! Please enter a valid integer: ");
				isInt = false;
			}
		} while(!isInt);
		
		// return valid input:
		return returnInt;
	}

	public static char getAction(Scanner input) {
		// DO THIS
		//	Read a line from the scanner ... get the first character from the line to determine the action
		//	Make sure the line read is not equal to 0.
		//	Return the action character
		
		// return first char to lower:
		char retChar = input.next().toLowerCase().charAt(0);
		if(retChar != 0)
			return retChar;
		return 'N';
	}

	public static void main (String[] args) {

		// DO NOT ADD ANY EXTRA VARIABLES
		SortedSinglyLinkedList<Integer> sll = new SortedSinglyLinkedList<Integer>();
		int value;
		char action;
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do?\n\n'a' add node\n'd' delete node\n'c' clear list\n'p' print list\n'f' find a node\n's' get size of list\n'q' quit program\n");
		do {
			action = getAction(input);

			switch (action) {
				// DO THIS -- handle the case for each action
			
			// add node:
			case 'a':
				System.out.println("Please enter an integer to add: ");
				sll.add(getInteger(input));
				break;
			// remove node:
			case 'd':
				System.out.println("Please enter an integer to be deleted: ");
				sll.remove(getInteger(input));
				break;
			case 'c':
				sll.clearList();
				break;
			case 'p':
				sll.print();
				break;
			case 'f':
				System.out.println("Please enter an integer to be searched: ");
				sll.find(getInteger(input));
				break;
			case 's':
				System.out.println("The size of the list is: " + sll.getSize() + "\n");;
				break;
			case 'q':
				System.out.println("Quitting...");
				break;
			default:
				System.out.println("Error! Please choose one of the following valid commands:\n\n'a' add node\n'd' delete node\n'c' clear list\n'p' print list\n'f' find a node\n's' get size of list\n'q' quit program\n");
				break;
			}
			
			if(action != 'q')
				System.out.print("Enter a command: ");
		} while (action != 'q');

		input.close();
		System.out.println("Done.\n");
	}
	// end main()
}