package cs255Assignment_2;

public abstract class GeometricObject {
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        this ("white", false);
    }

    protected GeometricObject (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = new java.util.Date();
    }

    public String getColor () {
        return color;
    }

    public boolean getFilled () {
        return filled;
    }

    public java.util.Date getDateCreated () {
        return dateCreated;
    }
    public void setColor (String color) {
        this.color = color;
    }

    public void setFilled (boolean filled) {
        this.filled = filled;
    }

    public String toString () {
        return "created on " + dateCreated + "\nColor: " + color + " and filled: " + filled;
    }

    public abstract double getArea ();

    public abstract double getPerimeter ();
}