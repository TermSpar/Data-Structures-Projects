package cs255Assignment_2;

import java.util.Scanner;

public class MyIntegerDriver {
    public MyIntegerDriver() {
    }

    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your integer: ");
        
        int userInt = scanner.nextInt();
        MyInteger myInt = new MyInteger(userInt);
        
        if (myInt.isPrime()) {
            System.out.println("Your integer " + myInt.getValue() + " is prime");
        } 
        else {
            System.out.println("Your integer " + myInt.getValue() + " is not prime");
        }

        if (MyInteger.isEven(myInt.getValue())) {
            System.out.println("Your integer " + myInt.getValue() + " is even");
        } 
        else if (myInt.isOdd(myInt)) {
            System.out.println("Your integer " + myInt.getValue() + " is odd");
        }
        
        System.out.println("----------------------------");
        
        System.out.print("Enter another integer: ");
        userInt = scanner.nextInt();
        MyInteger myInt2 = new MyInteger(userInt);
        
        if(myInt.equals(myInt2)) {
        	System.out.println("Your integer " + myInt.getValue() + " equals the integer you just entered: " + myInt2.getValue());
        }
        else {
        	System.out.println("Your integer " + myInt.getValue() + " does not equal the integer you just entered: " + myInt2.getValue());
        }
        
        System.out.println("----------------------------");
        
        System.out.print("Enter another integer: ");
        userInt = scanner.nextInt();
        
        if(myInt.equals(userInt)) {
        	System.out.println("Your integer " + myInt.getValue() + " equals the integer you just entered: " + userInt);
        }
        else {
        	System.out.println("Your integer " + myInt.getValue() + " does not equal the integer you just entered: " + userInt);
        }
        
        System.out.println("----------------------------");
        
        System.out.print("Enter a numeric array of chars: ");
        String userCharRay = scanner.next();
        char[] charRay = new char[userCharRay.length()];
        userCharRay.getChars(0, userCharRay.length(), charRay, 0);
        System.out.println("You entered: " + MyInteger.parseInt(charRay));
        
        System.out.println("----------------------------");
        
        System.out.print("Enter a numeric string: ");
        String userString = scanner.next();
        System.out.println("You entered: " + MyInteger.parseInt(userString));
        
        scanner.close();
    }
}
