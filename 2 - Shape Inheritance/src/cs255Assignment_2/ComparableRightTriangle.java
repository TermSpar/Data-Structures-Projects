package cs255Assignment_2;

public class ComparableRightTriangle extends RightTriangle implements Comparable<ComparableRightTriangle> {
    public ComparableRightTriangle(){ }

    @Override
    public int compareTo(ComparableRightTriangle o) {
    	if(getPerimeter() < o.getPerimeter()){
            return -1;
        }
        else if(getPerimeter() > o.getPerimeter()){
            return 1;
        }
        return 0;
    }
}
