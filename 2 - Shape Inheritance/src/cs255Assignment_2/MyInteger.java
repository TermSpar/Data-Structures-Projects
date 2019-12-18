package cs255Assignment_2;

public class MyInteger {
    private int value;

    public MyInteger() {
    }

    public MyInteger(int num) {
        value = num;
    }

    public int getValue() {
        return value;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i < num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isEven() {
        return isEven(getValue());
    }

    public boolean isOdd() {
        return isOdd(getValue());
    }

    public boolean isPrime() {
        return isPrime(getValue());
    }

    public boolean isEven(MyInteger num) {
        return isEven(getValue());
    }

    public boolean isOdd(MyInteger num) {
        return isOdd(getValue());
    }

    public boolean isPrime(MyInteger num) {
        return isPrime(getValue());
    }

    public boolean equals(int num) {
        return value == num;
    }

	public boolean equals(MyInteger num) {
        return num.getValue() == getValue();
    }

    public static int parseInt(char[] c) {
    	String strInt = "";
    	int retInt = 0;
    	
    	for(int i = 0; i < c.length; i++) {
    		if(c[i] >= 48 && c[i] <= 57) {
    			strInt += Character.getNumericValue(c[i]);
    		}
    		else {
    			System.out.println("ERROR: you must enter a numeric char!");
    			return -1;
    		}
    	}
        retInt = Integer.parseInt(strInt);
        return retInt;
    }

    public static int parseInt(String s) {
        try {
        	return Integer.parseInt(s);
        }
        catch(Exception e) {
        	System.out.println("ERROR: You must enter a numeric string!");
        	return -1;
        }
    }
}
