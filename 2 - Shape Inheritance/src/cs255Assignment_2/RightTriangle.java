package cs255Assignment_2;

public class RightTriangle extends GeometricObject {

    private int a; private int b; private int c;

    public RightTriangle(){
        this(1,1,1);
    }

    public RightTriangle(int a, int b, int c){
        this.a = a; this.b = b; this.c = c;
    }
    
    public int getA() { return a; }
    public int getB() { return b; }
    public int getC() { return c; }
    
    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }
    public void setC(int c) { this.c = c; }
    
    @Override
    public double getArea() {
        return (a * b)/2;
    }

    @Override
    public double getPerimeter() {
        return (a + b + c);
    }
}
