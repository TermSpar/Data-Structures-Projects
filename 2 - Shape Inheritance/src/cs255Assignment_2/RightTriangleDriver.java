package cs255Assignment_2;

public class RightTriangleDriver {
    public static void main(String[] args){
    	ComparableRightTriangle myTri1 = new ComparableRightTriangle();
        myTri1.setA(10); myTri1.setB(15); myTri1.setC(5);
        myTri1.setFilled(true); myTri1.setColor("Black");
        
        ComparableRightTriangle myTri2 = new ComparableRightTriangle();
        myTri2.setA(10); myTri2.setB(15); myTri2.setC(5);
        myTri2.setFilled(false); myTri2.setColor("Purple");
        
        System.out.println("The area of Triangle 1 is: " + myTri1.getArea());
        System.out.println("The area of Triangle 2 is: " + myTri2.getArea());
        
        System.out.println("----------------------------");
        
        System.out.println("Triangle 1 is filled?: " + myTri1.getFilled());
        System.out.println("Triangle 2 is filled?: " + myTri2.getFilled());
        
        System.out.println("----------------------------");
        
        System.out.println("Triangle 1 is " + myTri1.getColor());
        System.out.println("Triangle 2 is " + myTri2.getColor());
        
        System.out.println("----------------------------");
        
        checkCompare(myTri1, myTri2);
        
        myTri2.setA(20); myTri2.setB(35); myTri2.setC(45);
        
        checkCompare(myTri1, myTri2);
        
        myTri1.setA(100); myTri1.setB(105); myTri1.setC(50);
        
        checkCompare(myTri1, myTri2);
        
        System.out.println("----------------------------");
        
        System.out.println("The area of Triangle 1 is: " + myTri1.getArea());
        System.out.println("The area of Triangle 2 is: " + myTri2.getArea());
    }
    
    private static void checkCompare(ComparableRightTriangle t1, ComparableRightTriangle t2) {
    	if(t1.compareTo(t2) == -1) {
        	System.out.println("Triangle 1's perimeter is less than Triangle 2's");
        }
    	else if(t1.compareTo(t2) == 1) {
        	System.out.println("Triangle 1's perimeter is greater than Triangle 2's");
        }
    	else {
    		System.out.println("Triangle 1's perimeter is equal to Triangle 2's");
    	}
    }
}
