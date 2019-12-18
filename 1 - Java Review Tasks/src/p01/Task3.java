// Ben Bollinger, Task3.java, 9/12/2019 
   
/* DESCRIPTION:
 * This program has a class called LinearEquations, which has six variables corresponding to the different variables that are in
 * a linear equation. The class contains getter methods for all the variables, a method that checks if the variables given are able
 * to be solved linearly, and two equations that return the X and Y results of the equation. I also created a checkAndPrint method
 * that checks if the given variables are solvable, and prints the answer. Then I implemented this in the main method. */

package p01;

public class Task3 {
    public static void main(String[] args){
        LinearEquations le = new LinearEquations(9.0, 4.0, 3.0, -5.0, -5.0, -21.0);
        checkAndPrint(le);

        System.out.println("\n------------------\n");

        le = new LinearEquations(1.0, 2.0, 2.0, 4.0, 4.0, 5.0);
        checkAndPrint(le);
    }

    // check if equation is solvable, and print answer/error:
    private static void checkAndPrint(LinearEquations linearEq){
        if(linearEq.isSolvable()){
            System.out.println("X value:" + Math.round(linearEq.getX()) + "\nY value: " + Math.round(linearEq.getY()));
        }
        else{
            System.out.println("This equation has no solution");
        }
    }
}

class LinearEquations{

	// equation vars:
    private double A;
    private double B;
    private double C;
    private double D;
    private double E;
    private double F;

    // answer vars:
    private double x;
    private double y;

    LinearEquations(){
    }

    LinearEquations(double a, double b, double c, double d, double e, double f){
        A = a; B = b; C = c; D = d; E = e; F = f;
    }

    // equation getters:
    public double getA() { return A; }
    public double getB() { return B; }
    public double getC() { return C; }
    public double getD() { return D; }
    public double getE() { return E; }
    public double getF() { return F; }

    public boolean isSolvable(){
        if((A * D) - (B * C) != 0)
            return true;
        else
            return false;
    }

    public double getX(){
        x = ((E * D) - (B * F))/((A*D) - (B*C));
        return x;
    }

    public double getY(){
        y = ((A * F) - (E * C))/((A * D) - (B * C));
        return y;
    }
}